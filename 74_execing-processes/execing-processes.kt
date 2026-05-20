import kotlin.system.exitProcess

fun main() {
    val args = listOf("cmd", "/c", "dir", "/a")
    val process = ProcessBuilder(args)
        .also { it.environment().putAll(System.getenv()) }
        .inheritIO()
        .start()
    exitProcess(process.waitFor())
}
