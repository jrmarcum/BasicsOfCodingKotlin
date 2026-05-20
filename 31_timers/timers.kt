import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

fun main() {
    val executor = Executors.newScheduledThreadPool(2)

    val latch = CountDownLatch(1)
    executor.schedule({
        println("Timer 1 fired")
        latch.countDown()
    }, 2, TimeUnit.SECONDS)
    latch.await()

    val future = executor.schedule({
        println("Timer 2 fired")
    }, 1, TimeUnit.SECONDS)
    val stopped = future.cancel(false)
    if (stopped) println("Timer 2 stopped")

    Thread.sleep(2000)
    executor.shutdown()
}
