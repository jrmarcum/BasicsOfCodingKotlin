fun worker(id: Int) {
    println("Worker $id starting")
    Thread.sleep(1000)
    println("Worker $id done")
}

fun main() {
    val threads = (1..5).map { i -> Thread { worker(i) } }
    threads.forEach { it.start() }
    threads.forEach { it.join() }
}
