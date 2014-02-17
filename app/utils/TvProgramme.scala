package utils
import java.util.Date
import play.api.libs.json._
import play.api.libs.functional.syntax._




case class TvProgramme( val name : String, var channel : String , val start : Date, val end : Option[Date], val description : String , val rating : Double, categorie : Categorie.Value) {
	



}
object TvProgramme{
    implicit val fmt = Json.format[TvProgramme]
    
//    implicit val fmt = (
//  (__ \ "name").format[String] and
//  (__ \ "channel").format[String] and
//  (__ \ "start").format[Date] and
//   (__ \ "end").format[Option[Date]] and
//    (__ \ "description").format[String] and
//   (__ \ "rating").format[Double]
//)(TvProgramme.apply, unlift(TvProgramme.unapply))  
  }