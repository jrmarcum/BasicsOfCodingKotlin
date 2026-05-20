import kotlin.system.exitProcess

fun main() {
    // try-finally does not run when exitProcess is called,
    // so this println will never execute.
    try {
        exitProcess(3)
    } finally {
        println("!")
    }
}
