import java.util.concurrent.LinkedBlockingQueue

fun main() {
    val queue = LinkedBlockingQueue<String>()

    Thread {
        Thread.sleep(1000)
        queue.put("one")
    }.start()

    Thread {
        Thread.sleep(2000)
        queue.put("two")
    }.start()

    repeat(2) {
        println("received ${queue.take()}")
    }
}
