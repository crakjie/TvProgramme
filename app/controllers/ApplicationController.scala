package controllers

import scala.concurrent.duration._
import play.api.mvc._
import play.api.libs.concurrent.Akka
import play.api.Play.current
import akka.util.Timeout
import akka.actor.Props
import actors.TvUserActor
import java.text.SimpleDateFormat
import java.util.Date
import akka.pattern.{ ask, pipe }
import actors.WatchEveningShows
import scala.concurrent.ExecutionContext
import ExecutionContext.Implicits.global
import play.api.libs.json._
import actors.JSonShows
import play.api.libs.EventSource
import actors.Shows
import actors.WatchShows


object ApplicationController extends Controller {
	
	 implicit val timeout = Timeout(30 seconds)
	
	val tvUserActor = Akka.system.actorOf(Props[TvUserActor])
  
	
	def programmeEvening(day: String)= Action.async {
	   val simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")
	    val programmeDate : Date  = simpleDateFormat.parse(day)
		(tvUserActor ?  WatchEveningShows(programmeDate)).mapTo[JSonShows]
				.map({ answer => 
				  Ok(answer.out)})
	 }
	 
	 def programme(day: String)= Action.async {
	   val simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")
	    val programmeDate : Date  = simpleDateFormat.parse(day)
		(tvUserActor ?  WatchShows(programmeDate)).mapTo[JSonShows]
				.map({ answer => 
				  Ok(answer.out)})
	 }

	 
}