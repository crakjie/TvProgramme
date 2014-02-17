package actors

import scala.concurrent.duration._
import java.util.Date
import akka.actor._
import akka.actor.actorRef2Scala
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import utils.TvProgrammeFactory
import xmltv.Programme
import akka.pattern.pipe
import play.api.libs.iteratee.Concurrent
import scala.concurrent.ExecutionContext
import ExecutionContext.Implicits.global
import play.api.libs.iteratee.Enumerator
import akka.pattern.{ ask, pipe }
import akka.util.Timeout
import scala.concurrent.{ExecutionContext, Promise}
import java.util.concurrent.TimeoutException
import scala.concurrent.Future

class TvUserActor  extends Actor {
	implicit val timeout = Timeout(30 seconds)
	
  
	def receive = {
	 case WatchEveningShows(day : Date) =>	
	    val originalSender = sender
	    implicit val ec: ExecutionContext = context.dispatcher
	    //technique de la doc akka
	   
	 	val futurJson  = for {
		    programmes <- (XmlTvProviderActor.xmlTvProviderActor ? WatchEveningShows(day)).mapTo[Shows]
		    
		} yield programmes.programmes.map(xmlProgramme =>{ println(xmlProgramme);TvProgrammeFactory.makeTvProgrammeFromXmlProgramme(xmlProgramme)})
                
		futurJson map (programmes => {
			val futurProg = Future.sequence(
			    programmes.map(
			        x => (XmlTvProviderActor.xmlTvProviderActor ? GetChannelName(x.channel)).
			        	mapTo[ChannelName].
			        	map({y => 
			        	  		x.channel = y.name //set the true value of each object
			        	  		x // return the programme in the seq
			        	  	})
			        	)
			        )
			futurProg.map( a => originalSender ! JSonShows(Json.toJson(a.map(x =>Json.toJson(x)))))
            //originalSender ! JSonShows(Json.toJson(programmes.map(x =>Json.toJson(x))))     
		  })

	 
     case WatchShows(day : Date) =>
        val originalSender = sender
	    implicit val ec: ExecutionContext = context.dispatcher
	    //technique de l'inner actor
	    context.actorOf(Props(new Actor() {
               
                var programmes :  Seq[Programme] = null
                def receive = {                  
                  case Shows(xmlprogrammes) =>
                    programmes = xmlprogrammes
                    collectProgrammes
                }
                def collectProgrammes = (programmes) match {
                  case x : Seq[Programme] =>
                      sendResults(JSonShows(Json.toJson(x.map(xmlProgramme => Json.toJson(TvProgrammeFactory.makeTvProgrammeFromXmlProgramme(xmlProgramme)) ))))
                  case _ =>
                }
                def sendResults(json : JSonShows) = {
                  originalSender ! json
                  context.system.stop(self)
                }
                
                XmlTvProviderActor.xmlTvProviderActor.tell(WatchShows(day), self)
                
                
              }))
	 case _ =>
        sender ! akka.actor.Status.Failure(new IllegalArgumentException) 
//     case Shows(programmes : Seq[Programme]) =>
//      sender ! JSonShows( Concurrent.unicast[JsValue](onStart = (c) => {
//    	  	println("tvuser make json");
//        	play.Logger.info("logger :tvuser make json")
//        	Json.toJson(programmes.map(xmlProgramme => Json.toJson(TvProgrammeFactory.makeTvProgrammeFromXmlProgramme(xmlProgramme)) )) 
//	      },
//	      onComplete = {
//	        println("onComplete");
//        	play.Logger.info("logger :onComplete")
//	      },
//	      onError = (str, in) => {
//	        println("onError");
//        	play.Logger.info("logger :onError")
//	      }
//	    ).onDoneEnumerating(
//	      callback = {
//	         println("onDoneEnumerating");
//	         play.Logger.info("logger :onDoneEnumerating")
//	      })
//	   )
//         
  
        
           
  }
}



case class JSonShows(out:JsValue)