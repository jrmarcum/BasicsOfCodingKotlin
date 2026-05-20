import java.time.LocalDateTime
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

fun main() {
    val executor = Executors.newSingleThreadScheduledExecutor()

    val future = executor.scheduleAtFixedRate({
        println("Tick at ${LocalDateTime.now()}")
    }, 500, 500, TimeUnit.MILLISECONDS)

    Thread.sleep(1600)
    future.cancel(false)
    executor.shutdown()
    println("Ticker stopped")
}
