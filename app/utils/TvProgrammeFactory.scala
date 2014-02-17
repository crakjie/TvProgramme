package utils

import java.text.SimpleDateFormat
import java.util.Date
import xmltv.Programme


object TvProgrammeFactory {
	def makeTvProgrammeFromXmlProgramme(xmlProgramme : Programme) : TvProgramme = {
	val name : String =xmlProgramme.title.head.mixed.head.value.toString;
	val channel : String = xmlProgramme.channel;
	
	val simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss Z")
	val start : Date =  simpleDateFormat.parse(xmlProgramme.start);
	val end : Option[Date] =  xmlProgramme.stop match  {
	  case None =>
	    None
	  case Some(stop) =>
	    Some(simpleDateFormat.parse(xmlProgramme.stop.get))
	}
	
	val desciption : String = xmlProgramme.desc.foldLeft("")((x1 : String ,x2 : xmltv.Desc) => x1 + x2.mixed.head.value)
	val rating : Double = 0.0;
	
	val categorie = xmlProgramme.category.head.mixed.head.value match {
	  case "Documentaire" => Categorie.Documentary
	  case "Magazine" => Categorie.Magazine
	  case "Film" => Categorie.Movie
	  case "Série" => Categorie.Show
	  case _ => Categorie.Other
	}
	
	return TvProgramme(name,channel,start,end,desciption,rating,categorie)
	}
}