import java.time.LocalDateTime
import java.util.concurrent.Executors
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.TimeUnit

fun main() {
    val requests = (1..5).toList()

    val limiter = LinkedBlockingQueue<Long>()
    val executor = Executors.newSingleThreadScheduledExecutor()
    executor.scheduleAtFixedRate({ limiter.offer(System.currentTimeMillis()) }, 0, 200, TimeUnit.MILLISECONDS)

    for (req in requests) {
        limiter.take()
        println("request $req ${LocalDateTime.now()}")
    }
    executor.shutdown()

    val burstyLimiter = LinkedBlockingQueue<Long>(3)
    repeat(3) { burstyLimiter.put(System.currentTimeMillis()) }

    val burstyExecutor = Executors.newSingleThreadScheduledExecutor()
    burstyExecutor.scheduleAtFixedRate({ burstyLimiter.offer(System.currentTimeMillis()) }, 200, 200, TimeUnit.MILLISECONDS)

    for (req in 1..5) {
        burstyLimiter.take()
        println("request $req ${LocalDateTime.now()}")
    }
    burstyExecutor.shutdown()
}
