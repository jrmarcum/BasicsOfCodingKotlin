import com.sun.net.httpserver.HttpServer
import java.net.InetSocketAddress
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

val cancelLatch = CountDownLatch(1)

fun main() {
    val server = HttpServer.create(InetSocketAddress(8090), 0)
    server.createContext("/hello") { exchange ->
        println("server: hello handler started")
        val cancelled = cancelLatch.await(10, TimeUnit.SECONDS)
        try {
            if (cancelled) {
                println("server: context canceled")
                exchange.sendResponseHeaders(500, -1)
            } else {
                val response = "hello\n"
                exchange.sendResponseHeaders(200, response.length.toLong())
                exchange.responseBody.use { it.write(response.toByteArray()) }
            }
        } finally {
            println("server: hello handler ended")
        }
    }
    server.executor = Executors.newCachedThreadPool()
    server.start()

    Runtime.getRuntime().addShutdownHook(Thread {
        cancelLatch.countDown()
        Thread.sleep(500)
        server.stop(0)
    })
}
