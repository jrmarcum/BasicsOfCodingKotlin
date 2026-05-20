import java.util.concurrent.LinkedBlockingQueue

fun main() {
    val messages = LinkedBlockingQueue<String>()

    Thread { messages.put("ping") }.start()

    val msg = messages.take()
    println(msg)
}
