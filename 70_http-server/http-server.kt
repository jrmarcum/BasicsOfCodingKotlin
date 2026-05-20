import com.sun.net.httpserver.HttpServer
import com.sun.net.httpserver.HttpExchange
import java.net.InetSocketAddress

fun hello(exchange: HttpExchange) {
    val response = "hello\n"
    exchange.sendResponseHeaders(200, response.length.toLong())
    exchange.responseBody.use { it.write(response.toByteArray()) }
}

fun headers(exchange: HttpExchange) {
    val sb = StringBuilder()
    for ((name, values) in exchange.requestHeaders) {
        for (value in values) {
            sb.append("$name: $value\n")
        }
    }
    val response = sb.toString()
    exchange.sendResponseHeaders(200, response.length.toLong())
    exchange.responseBody.use { it.write(response.toByteArray()) }
}

fun main() {
    val server = HttpServer.create(InetSocketAddress(8090), 0)
    server.createContext("/hello") { hello(it) }
    server.createContext("/headers") { headers(it) }
    server.start()
}
