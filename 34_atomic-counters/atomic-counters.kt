import java.util.concurrent.atomic.AtomicLong

fun main() {
    val ops = AtomicLong(0)

    val threads = (1..50).map {
        Thread {
            repeat(1000) {
                ops.addAndGet(1)
            }
        }
    }
    threads.forEach { it.start() }
    threads.forEach { it.join() }

    println("ops: ${ops.get()}")
}
