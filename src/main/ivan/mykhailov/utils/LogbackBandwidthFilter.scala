package ivan.mykhailov.utils

import java.util.concurrent.ConcurrentLinkedQueue

import ch.qos.logback.classic.spi.ILoggingEvent
import ch.qos.logback.core.filter.Filter
import ch.qos.logback.core.spi.FilterReply


class LogbackBandwidthFilter extends Filter[ILoggingEvent] {

  var logsPerSecond = 50

  protected val SecondMillis = 1000//1 secons

  protected val q = new ConcurrentLinkedQueue[java.lang.Long]

  override def decide(event: ILoggingEvent): FilterReply = {
    cleanOldest()
    if (q.size() < logsPerSecond) {
      q.add(System.currentTimeMillis)
      //print(q.size()+ " ACCEPT")
      FilterReply.ACCEPT
    } else {
      //print(q.size()+ " DENY")
      FilterReply.DENY
    }
  }

  def setValue(lps: java.lang.String) {
    logsPerSecond = lps.toInt
  }

  protected def cleanOldest(): Unit = {
    val oldestTime = q.peek()
    if (oldestTime != null && System.currentTimeMillis - oldestTime > SecondMillis) {
      q.poll()
    }
  }
}