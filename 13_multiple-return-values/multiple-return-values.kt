fun vals(): Pair<Int, Int> = Pair(3, 7)

fun main() {
    val (a, b) = vals()
    println(a)
    println(b)

    val (_, c) = vals()
    println(c)
}
