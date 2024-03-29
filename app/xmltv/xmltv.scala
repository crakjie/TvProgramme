// Generated by <a href="http://scalaxb.org/">scalaxb</a>.
package xmltv

case class Tv(channel: Seq[xmltv.Channel] = Nil,
  programme: Seq[xmltv.Programme] = Nil,
  date: Option[String] = None,
  sourceu45infou45url: Option[String] = None,
  sourceu45infou45name: Option[String] = None,
  sourceu45datau45url: Option[String] = None,
  generatoru45infou45name: Option[String] = None,
  generatoru45infou45url: Option[String] = None)


case class Channel(displayu45name: Seq[xmltv.Displayu45name] = Nil,
  icon: Seq[xmltv.Icon] = Nil,
  url: Seq[String] = Nil,
  id: String)


case class Displayu45name(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  lang: Option[String] = None)


case class Programme(programmesequence1: xmltv.ProgrammeSequence1,
  programmesequence2: xmltv.ProgrammeSequence2,
  programmesequence3: xmltv.ProgrammeSequence3,
  start: String,
  stop: Option[String] = None,
  pdcu45start: Option[String] = None,
  vpsu45start: Option[String] = None,
  showview: Option[String] = None,
  videoplus: Option[String] = None,
  channel: String,
  clumpidx: String) {
  lazy val title = programmesequence1.title
  lazy val subu45title = programmesequence1.subu45title
  lazy val desc = programmesequence1.desc
  lazy val credits = programmesequence1.credits
  lazy val date = programmesequence1.date
  lazy val category = programmesequence1.category
  lazy val language = programmesequence1.language
  lazy val origu45language = programmesequence1.origu45language
  lazy val length = programmesequence1.length
  lazy val icon = programmesequence1.icon
  lazy val url = programmesequence2.url
  lazy val country = programmesequence2.country
  lazy val episodeu45num = programmesequence2.episodeu45num
  lazy val video = programmesequence2.video
  lazy val audio = programmesequence2.audio
  lazy val previouslyu45shown = programmesequence2.previouslyu45shown
  lazy val premiere = programmesequence2.premiere
  lazy val lastu45chance = programmesequence2.lastu45chance
  lazy val newValue = programmesequence2.newValue
  lazy val subtitles = programmesequence2.subtitles
  lazy val rating = programmesequence3.rating
  lazy val staru45rating = programmesequence3.staru45rating
  lazy val review = programmesequence3.review
}


case class ProgrammeSequence1(title: Seq[xmltv.Title] = Nil,
  subu45title: Seq[xmltv.Subu45title] = Nil,
  desc: Seq[xmltv.Desc] = Nil,
  credits: Option[xmltv.Credits] = None,
  date: Option[String] = None,
  category: Seq[xmltv.Category] = Nil,
  language: Option[xmltv.Language] = None,
  origu45language: Option[xmltv.Origu45language] = None,
  length: Option[xmltv.Length] = None,
  icon: Seq[xmltv.Icon] = Nil)

case class ProgrammeSequence2(url: Seq[String] = Nil,
  country: Seq[xmltv.Country] = Nil,
  episodeu45num: Seq[xmltv.Episodeu45num] = Nil,
  video: Option[xmltv.Video] = None,
  audio: Option[xmltv.Audio] = None,
  previouslyu45shown: Option[xmltv.Previouslyu45shown] = None,
  premiere: Option[xmltv.Premiere] = None,
  lastu45chance: Option[xmltv.Lastu45chance] = None,
  newValue: Option[xmltv.New] = None,
  subtitles: Seq[xmltv.Subtitles] = Nil)

case class ProgrammeSequence3(rating: Seq[xmltv.Rating] = Nil,
  staru45rating: Seq[xmltv.Staru45rating] = Nil,
  review: Seq[xmltv.Review] = Nil)


case class Title(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  lang: Option[String] = None)


case class Subu45title(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  lang: Option[String] = None)


case class Desc(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  lang: Option[String] = None)


case class Credits(director: Seq[String] = Nil,
  actor: Seq[xmltv.Actor] = Nil,
  writer: Seq[String] = Nil,
  adapter: Seq[String] = Nil,
  producer: Seq[String] = Nil,
  composer: Seq[String] = Nil,
  editor: Seq[String] = Nil,
  presenter: Seq[String] = Nil,
  commentator: Seq[String] = Nil,
  guest: Seq[String] = Nil)


case class Actor(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  role: Option[String] = None)


case class Category(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  lang: Option[String] = None)


case class Language(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  lang: Option[String] = None)


case class Origu45language(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  lang: Option[String] = None)


case class Length(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  units: xmltv.Units)

trait Units

object Units {
  def fromString(value: String, scope: scala.xml.NamespaceBinding): Units = value match {
    case "seconds" => Seconds
    case "minutes" => Minutes
    case "hours" => Hours

  }
}

case object Seconds extends Units { override def toString = "seconds" }
case object Minutes extends Units { override def toString = "minutes" }
case object Hours extends Units { override def toString = "hours" }


case class Icon(src: String,
  width: Option[String] = None,
  height: Option[String] = None)


case class Country(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  lang: Option[String] = None)


case class Episodeu45num(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  system: String)


case class Video(present: Option[String] = None,
  colour: Option[String] = None,
  aspect: Option[String] = None,
  quality: Option[String] = None)


case class Audio(present: Option[String] = None,
  stereo: Option[String] = None)


case class Previouslyu45shown(start: Option[String] = None,
  channel: Option[String] = None)


case class Premiere(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  lang: Option[String] = None)


case class Lastu45chance(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  lang: Option[String] = None)


case class New()


case class Subtitles(language: Option[xmltv.Language] = None,
  typeValue: Option[xmltv.Type] = None)

trait Type

object Type {
  def fromString(value: String, scope: scala.xml.NamespaceBinding): Type = value match {
    case "teletext" => Teletext
    case "onscreen" => Onscreen
    case "deaf-signed" => Deafu45signed

  }
}

case object Teletext extends Type { override def toString = "teletext" }
case object Onscreen extends Type { override def toString = "onscreen" }
case object Deafu45signed extends Type { override def toString = "deaf-signed" }


case class Rating(value: String,
  icon: Seq[xmltv.Icon] = Nil,
  system: Option[String] = None)


case class Staru45rating(value: String,
  icon: Seq[xmltv.Icon] = Nil,
  system: Option[String] = None)


case class Review(mixed: Seq[scalaxb.DataRecord[Any]] = Nil,
  typeValue: xmltv.TypeType,
  source: Option[String] = None,
  reviewer: Option[String] = None,
  lang: Option[String] = None)

trait TypeType

object TypeType {
  def fromString(value: String, scope: scala.xml.NamespaceBinding): TypeType = value match {
    case "text" => Text
    case "url" => Url

  }
}

case object Text extends TypeType { override def toString = "text" }
case object Url extends TypeType { override def toString = "url" }


case class Attlistu46review(typeValue: xmltv.TypeType,
  source: Option[String] = None,
  reviewer: Option[String] = None,
  lang: Option[String] = None)


case class Attlistu46staru45rating(system: Option[String] = None)


case class Attlistu46rating(system: Option[String] = None)


case class Attlistu46subtitles(typeValue: Option[xmltv.Type] = None)


case class Attlistu46lastu45chance(lang: Option[String] = None)


case class Attlistu46premiere(lang: Option[String] = None)


case class Attlistu46previouslyu45shown(start: Option[String] = None,
  channel: Option[String] = None)


case class Attlistu46episodeu45num(system: String)


case class Attlistu46country(lang: Option[String] = None)


case class Attlistu46icon(src: String,
  width: Option[String] = None,
  height: Option[String] = None)


case class Attlistu46length(units: xmltv.Units)


case class Attlistu46origu45language(lang: Option[String] = None)


case class Attlistu46language(lang: Option[String] = None)


case class Attlistu46category(lang: Option[String] = None)


case class Attlistu46actor(role: Option[String] = None)


case class Attlistu46desc(lang: Option[String] = None)


case class Attlistu46subu45title(lang: Option[String] = None)


case class Attlistu46title(lang: Option[String] = None)


case class Attlistu46programme(start: String,
  stop: Option[String] = None,
  pdcu45start: Option[String] = None,
  vpsu45start: Option[String] = None,
  showview: Option[String] = None,
  videoplus: Option[String] = None,
  channel: String,
  clumpidx: String)


case class Attlistu46displayu45name(lang: Option[String] = None)


case class Attlistu46channel(id: String)


case class Attlistu46tv(date: Option[String] = None,
  sourceu45infou45url: Option[String] = None,
  sourceu45infou45name: Option[String] = None,
  sourceu45datau45url: Option[String] = None,
  generatoru45infou45name: Option[String] = None,
  generatoru45infou45url: Option[String] = None)

