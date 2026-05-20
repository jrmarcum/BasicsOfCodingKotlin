import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    var line: String?
    while (reader.readLine().also { line = it } != null) {
        println(line!!.uppercase())
    }
    if (reader.ready()) {
        System.err.println("error: scanner error")
    }
}
