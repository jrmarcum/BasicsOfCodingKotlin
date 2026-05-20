import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val client = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder()
        .uri(URI("https://gobyexample.com"))
        .GET()
        .build()

    val response = client.send(request, HttpResponse.BodyHandlers.ofInputStream())
    println("Response status: ${response.statusCode()} OK")

    val reader = BufferedReader(InputStreamReader(response.body()))
    var count = 0
    var line: String?
    while (reader.readLine().also { line = it } != null && count < 5) {
        println(line)
        count++
    }
}
