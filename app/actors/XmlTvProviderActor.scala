package actors

import akka.actor.Actor
import java.util.Date
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import akka.actor.ActorRef
import play.libs.Akka
import akka.actor.Props
import java.text.SimpleDateFormat
import xmltv.Programme
import org.joda.time.DateTime
import org.apache.commons.lang3.time.DateUtils
import akka.actor.actorRef2Scala
import scala.annotation.implicitNotFound
import xmltv.XmltvTvFormat

class XmlTvProviderActor extends Actor {
  
  var  tv  = scalaxb.fromXML[xmltv.Tv](scala.xml.XML.loadFile("xmltv.xml"))
  lazy val simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss Z")
  //Extraite le scheduler et le chargement du fichier dans un autre acteur.
  val stockTick = context.system.scheduler.schedule(Duration.Zero, 24.hours, self, Update)
  
  def receive = {
     case Update =>
       
       tv = scalaxb.fromXML[xmltv.Tv](scala.xml.XML.loadFile("xmltv.xml"))
       
     case WatchEveningShows(day: Date) => 
       var programmes = tv.programme.filter(x =>          
       		DateUtils.isSameDay( simpleDateFormat.parse(x.start), day)
       		&& new DateTime(simpleDateFormat.parse(x.start)).getHourOfDay() > 20
       		&& new DateTime(simpleDateFormat.parse(x.stop.getOrElse("20000101000101 +100"))).getHourOfDay() <=0
       	)
      
       sender ! Shows(programmes)
       
    case WatchShows(day: Date) =>       
       	var programmes = tv.programme.filter(x => DateUtils.isSameDay(simpleDateFormat.parse(x.start), day))      
      	sender ! Shows(programmes)
      	
    case GetChannelName(code: String) => 
       	var name = tv.channel.filter(x => x.id ==code).head.displayu45name.filter(x => x.lang =="fr" || x.lang == None).head.mixed.head.value.toString   
      	sender ! ChannelName(name)
  }
	 
	
}

object XmlTvProviderActor {
  lazy val xmlTvProviderActor: ActorRef = Akka.system.actorOf(Props(classOf[XmlTvProviderActor]))
}

case class WatchEveningShows(day: Date)

case class WatchShows(day: Date)

case class Shows(programmes : Seq[Programme])

case class Update()

case class GetChannelName(code: String)

case class ChannelName(name: String)