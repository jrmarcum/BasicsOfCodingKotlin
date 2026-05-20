import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.TimeUnit

fun main() {
    val c1 = LinkedBlockingQueue<String>()
    Thread {
        Thread.sleep(2000)
        c1.put("result 1")
    }.start()

    val res1 = c1.poll(1, TimeUnit.SECONDS)
    if (res1 != null) println(res1) else println("timeout 1")

    val c2 = LinkedBlockingQueue<String>()
    Thread {
        Thread.sleep(2000)
        c2.put("result 2")
    }.start()

    val res2 = c2.poll(3, TimeUnit.SECONDS)
    if (res2 != null) println(res2) else println("timeout 2")
}
