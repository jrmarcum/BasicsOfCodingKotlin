fun main() {
    println("FOO: ${System.getenv("FOO") ?: ""}")
    println("BAR: ${System.getenv("BAR") ?: ""}")

    println()
    for (key in System.getenv().keys) {
        println(key)
    }
}
