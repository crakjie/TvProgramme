package utils

import play.api.libs.json.Reads
import play.api.libs.json.Writes
import play.api.libs.json.Format




object Categorie extends Enumeration
{
  
	type Categorie = Value
	val Movie = Value("Movie")
	val Magazine = Value("Magazine")
	val Documentary = Value("Documentary")
	val Show = Value("Show")
	val Other = Value("Other")
	
	implicit val enumReads: Reads[Categorie] = EnumUtils.enumReads(Categorie)

  	implicit val enumWrites: Writes[Categorie] = EnumUtils.enumWrites
	
	implicit val enumFormat : Format[Categorie]= Format[Categorie](enumReads, enumWrites)
}
