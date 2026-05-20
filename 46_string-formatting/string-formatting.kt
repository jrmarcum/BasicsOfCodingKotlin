import java.io.PrintStream

data class point(val x: Int, val y: Int) {
    override fun toString() = "{$x $y}"
}

fun main() {
    val p = point(1, 2)

    println(p)
    println("{x:${p.x} y:${p.y}}")
    println("main.point{x:${p.x}, y:${p.y}}")
    println(p::class.qualifiedName)

    println(true)
    println(123)
    println(14.toString(2))
    println(33.toChar())
    println(456.toString(16))

    println("%.6f".format(78.9))
    println("%.6e".format(123400000.0))
    println("%.6E".format(123400000.0))

    println("\"string\"")
    println("\"\\\"string\\\"\"")
    println("hex this".toByteArray(Charsets.UTF_8).joinToString("") { "%02x".format(it.toInt() and 0xFF) })

    println("0x%x".format(System.identityHashCode(p)))

    println("|%6d|%6d|".format(12, 345))
    println("|%6.2f|%6.2f|".format(1.2, 3.45))
    println("|%-6.2f|%-6.2f|".format(1.2, 3.45))
    println("|%6s|%6s|".format("foo", "b"))
    println("|%-6s|%-6s|".format("foo", "b"))

    val s = "a %s".format("string")
    println(s)

    System.err.println("an %s".format("error"))
}
