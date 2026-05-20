import kotlin.math.sin

const val s = "constant"

fun main() {
    println(s)

    val n = 500_000_000
    val d = 3e20 / n.toDouble()
    println(d)
    println(d.toLong())
    println(sin(n.toDouble()))
}
