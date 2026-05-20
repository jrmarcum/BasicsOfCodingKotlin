class ArgError(val arg: Int, override val message: String) : Exception("$arg - $message")

fun f(arg: Int): Pair<Int, Exception?> =
    if (arg == 42) Pair(-1, ArgError(arg, "can't work with it")) else Pair(arg + 3, null)

fun main() {
    val (_, err) = f(42)
    if (err is ArgError) {
        println(err.arg)
        println(err.message)
    } else {
        println("err doesn't match argError")
    }
}
