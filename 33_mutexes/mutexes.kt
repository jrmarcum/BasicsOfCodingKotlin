import java.util.concurrent.locks.ReentrantLock

class Container {
    private val mu = ReentrantLock()
    val counters = mutableMapOf("a" to 0, "b" to 0)

    fun inc(name: String) {
        mu.lock()
        try {
            counters[name] = counters[name]!! + 1
        } finally {
            mu.unlock()
        }
    }
}

fun main() {
    val c = Container()

    val threads = listOf(
        Thread { repeat(10000) { c.inc("a") } },
        Thread { repeat(10000) { c.inc("a") } },
        Thread { repeat(10000) { c.inc("b") } }
    )
    threads.forEach { it.start() }
    threads.forEach { it.join() }

    println("map[${c.counters.entries.joinToString(" ") { "${it.key}:${it.value}" }}]")
}
