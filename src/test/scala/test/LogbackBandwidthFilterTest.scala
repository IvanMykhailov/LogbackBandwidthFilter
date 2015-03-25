package test

import ch.qos.logback.classic.spi.LoggingEvent
import ch.qos.logback.core.spi.FilterReply
import ivan.mykhailov.utils.LogbackBandwidthFilter
import org.scalatest.{Matchers, FlatSpec}


class LogbackBandwidthFilterTest extends FlatSpec with Matchers {

  val event = new LoggingEvent

  "LogbackBandwidthFilter" should "skip events after saturation" in {
    val filter = new LogbackBandwidthFilter
    filter.setValue("10")
    (1 to 10).foreach { i =>
      filter.decide(event) shouldBe FilterReply.ACCEPT
    }
    filter.decide(event) shouldBe FilterReply.DENY
  }

  it should "allow events if saturation is gone" in {
    val filter = new LogbackBandwidthFilter
    filter.setValue("10")
    (1 to 5).foreach { i =>
      filter.decide(event) shouldBe FilterReply.ACCEPT
    }
    Thread.sleep(500)
    (1 to 5).foreach { i =>
      filter.decide(event) shouldBe FilterReply.ACCEPT
    }
    filter.decide(event) shouldBe FilterReply.DENY

    Thread.sleep(500)
    (1 to 5).foreach { i =>
      filter.decide(event) shouldBe FilterReply.ACCEPT
    }
    filter.decide(event) shouldBe FilterReply.DENY
  }

}
