import java.time.Instant
import java.time.ZonedDateTime
import java.time.ZoneOffset
import java.time.format.TextStyle
import java.util.Locale

fun ZonedDateTime.goString(): String {
    val ns = nano
    val nsStr = if (ns == 0) "" else "." + "%09d".format(ns).trimEnd('0')
    val off = if (offset == ZoneOffset.UTC) "+0000 UTC"
              else offset.toString().replace(":", "") + " " + zone.getDisplayName(TextStyle.SHORT, Locale.ENGLISH)
    return "%04d-%02d-%02d %02d:%02d:%02d%s %s".format(
        year, monthValue, dayOfMonth, hour, minute, second, nsStr, off)
}

fun main() {
    val now = ZonedDateTime.now(ZoneOffset.UTC)
    val secs = now.toEpochSecond()
    val nanos = secs * 1_000_000_000L + now.nano.toLong()
    val millis = nanos / 1_000_000L
    println(now.goString())

    println(secs)
    println(millis)
    println(nanos)

    println(ZonedDateTime.ofInstant(Instant.ofEpochSecond(secs), ZoneOffset.UTC).goString())
    println(ZonedDateTime.ofInstant(Instant.ofEpochSecond(0, nanos), ZoneOffset.UTC).goString())
}
