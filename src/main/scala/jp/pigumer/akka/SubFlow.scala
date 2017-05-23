package jp.pigumer.akka

import akka.stream.Materializer
import akka.stream.scaladsl._

object SubFlow {

  def apply(n: Int)(implicit meterializer: Materializer) = {
    val source = Source(Seq(n, n).toVector)
    val sink = Sink.fold[Int, Int](0)(_ + _)

    source.via(Flow[Int].map(_ * 2)).runWith(sink)
  }
}
