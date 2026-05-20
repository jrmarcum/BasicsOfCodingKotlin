import java.time.ZonedDateTime
import java.time.ZoneOffset
import java.time.Duration
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

fun ZonedDateTime.goString(): String {
    val ns = "%09d".format(nano)
    val off = if (offset == ZoneOffset.UTC) "+0000 UTC"
              else offset.toString().replace(":", "") + " " + zone.getDisplayName(TextStyle.SHORT, Locale.ENGLISH)
    return "%04d-%02d-%02d %02d:%02d:%02d.%s %s".format(
        year, monthValue, dayOfMonth, hour, minute, second, ns, off)
}

fun main() {
    val now = ZonedDateTime.now()
    println(now.goString())

    val then = ZonedDateTime.of(2009, 11, 17, 20, 34, 58, 651387237, ZoneOffset.UTC)
    println(then.goString())

    println(then.year)
    println(then.month.getDisplayName(TextStyle.FULL, Locale.ENGLISH))
    println(then.dayOfMonth)
    println(then.hour)
    println(then.minute)
    println(then.second)
    println(then.nano)
    println(if (then.offset == ZoneOffset.UTC) "UTC" else then.zone)

    println(then.dayOfWeek.getDisplayName(TextStyle.FULL, Locale.ENGLISH))

    println(then.isBefore(now))
    println(then.isAfter(now))
    println(then == now)

    val diff = Duration.between(then.toInstant(), now.toInstant())
    val totalNanos = diff.toNanos()
    val diffHours = totalNanos.toDouble() / 3_600_000_000_000.0
    val diffMins = totalNanos.toDouble() / 60_000_000_000.0
    val diffSecs = totalNanos.toDouble() / 1_000_000_000.0

    val h = diff.toHours()
    val m = (diff.toMinutes() % 60)
    val s = (diff.toSeconds() % 60)
    val ns = (totalNanos % 1_000_000_000)
    val nsStr = if (ns == 0L) "" else ".%d".format(ns).trimEnd('0')
    println("${h}h${m}m${s}${nsStr}s")

    println(diffHours)
    println(diffMins)
    println(diffSecs)
    println(totalNanos)

    val thenInstant = then.toInstant()
    println(ZonedDateTime.ofInstant(thenInstant.plusNanos(totalNanos), ZoneOffset.UTC).goString())
    println(ZonedDateTime.ofInstant(thenInstant.minusNanos(totalNanos), ZoneOffset.UTC).goString())
}
