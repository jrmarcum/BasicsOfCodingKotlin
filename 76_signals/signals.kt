fun main() {
    println("awaiting signal")

    Runtime.getRuntime().addShutdownHook(Thread {
        println()
        println("interrupt signal received")
        println("exiting")
    })

    try {
        Thread.sleep(Long.MAX_VALUE)
    } catch (e: InterruptedException) {
        // interrupted during JVM shutdown
    }
}
