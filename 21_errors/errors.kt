class ArgError(val arg: Int, val prob: String) : Exception("$arg - $prob")

fun f1(arg: Int): Pair<Int, Exception?> =
    if (arg == 42) Pair(-1, Exception("can't work with 42")) else Pair(arg + 3, null)

fun f2(arg: Int): Pair<Int, Exception?> =
    if (arg == 42) Pair(-1, ArgError(arg, "can't work with it")) else Pair(arg + 3, null)

fun main() {
    for (i in listOf(7, 42)) {
        val (r, e) = f1(i)
        if (e != null) println("f1 failed: ${e.message}")
        else println("f1 worked: $r")
    }
    for (i in listOf(7, 42)) {
        val (r, e) = f2(i)
        if (e != null) println("f2 failed: ${e.message}")
        else println("f2 worked: $r")
    }

    val (_, e) = f2(42)
    if (e is ArgError) {
        println(e.arg)
        println(e.prob)
    }
}
