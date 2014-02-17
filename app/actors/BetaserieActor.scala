package actors

import akka.actor.Actor
import utils.TvProgramme


class BetaserieActor extends Actor {
	def receive = {
	  case GetNote(programme : TvProgramme) =>
	    //todo
	}
}

case class GetNote(programme : TvProgramme)