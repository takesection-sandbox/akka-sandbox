package jp.pigumer.akka

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Flow, Sink, Source}

import scala.util.{Failure, Success}

object Main extends App {

  implicit val system = ActorSystem("sandbox")
  implicit val meterializer = ActorMaterializer()
  implicit val executeContext = system.dispatcher

  val source = Source(1 to 3)
  val sink = Sink.seq[Int]

  val flow = Flow[Int].mapAsync(1)(SubFlow(_))

  val future = source.via(flow).runWith(sink)

  future.onComplete {
    case Success(v) => {
      println(v)

    }
    case Failure(t) => t.printStackTrace()
  }
}
