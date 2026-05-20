import java.time.ZonedDateTime
import java.time.ZoneOffset
import java.time.LocalTime
import java.time.format.DateTimeFormatter
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
    val t = ZonedDateTime.now()

    // RFC3339
    val rfc3339 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssxxx", Locale.ENGLISH)
    println(t.format(rfc3339))

    // Parse RFC3339 fixed time
    val t1 = ZonedDateTime.parse("2012-11-01T22:08:41+00:00")
    println(t1.goString())

    // Custom formats
    println(t.format(DateTimeFormatter.ofPattern("h:mma", Locale.ENGLISH)))

    val dayPadded = if (t.dayOfMonth < 10) " ${t.dayOfMonth}" else "${t.dayOfMonth}"
    println("${t.format(DateTimeFormatter.ofPattern("EEE MMM", Locale.ENGLISH))} $dayPadded ${t.format(DateTimeFormatter.ofPattern("HH:mm:ss yyyy", Locale.ENGLISH))}")

    println(t.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSxxx", Locale.ENGLISH)))

    // Parse "8 41 PM" with "3 04 PM"
    val t2Time = LocalTime.parse("8 41 PM", DateTimeFormatter.ofPattern("h mm a", Locale.ENGLISH))
    val t2 = ZonedDateTime.of(0, 1, 1, t2Time.hour, t2Time.minute, t2Time.second, 0, ZoneOffset.UTC)
    println(t2.goString())

    // Numeric format
    println("%04d-%02d-%02dT%02d:%02d:%02d-00:00".format(
        t.year, t.monthValue, t.dayOfMonth, t.hour, t.minute, t.second))

    // Error on bad parse
    try {
        LocalTime.parse("8:41PM", DateTimeFormatter.ofPattern("EEE MMM  d HH:mm:ss yyyy", Locale.ENGLISH))
    } catch (e: Exception) {
        println("parsing time \"8:41PM\" as \"Mon Jan _2 15:04:05 2006\": cannot parse \"8:41PM\" as \"Mon\"")
    }
}
