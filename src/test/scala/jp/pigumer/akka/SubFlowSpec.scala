package jp.pigumer.akka

import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Flow, Sink, Source}
import org.specs2.mutable.Specification

import scala.concurrent.Await
import scala.concurrent.duration._

class SubFlowSpec extends Specification {

  implicit val system = Main.createActorSystem
  implicit val materializer = ActorMaterializer()

  "SubFlow" should {

    "spec" in {

      val future = Source.single(3).
        via(Flow[Int].mapAsync(1)(SubFlow(_))).
        runWith(Sink.head)

      val result = Await.result(future, 3 seconds)
      result must_== 12
    }
  }
}
