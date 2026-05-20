fun f(from: String) {
    for (i in 0 until 3) {
        println("$from : $i")
    }
}

fun main() {
    f("direct")

    val t1 = Thread { f("goroutine") }
    t1.start()

    val t2 = Thread { println("going") }
    t2.start()

    Thread.sleep(1000)
    println("done")
}
