fun mayPanic() {
    throw RuntimeException("a problem")
}

fun main() {
    try {
        mayPanic()
        println("After mayPanic()")
    } catch (r: RuntimeException) {
        println("Recovered. Error:\n ${r.message}")
    }
}
