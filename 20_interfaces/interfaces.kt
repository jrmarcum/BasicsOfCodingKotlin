import kotlin.math.PI

interface Geometry {
    fun area(): Double
    fun perim(): Double
}

class Rect(val width: Double, val height: Double) : Geometry {
    override fun area() = width * height
    override fun perim() = 2 * width + 2 * height
    override fun toString() = "{${fmtNum(width)} ${fmtNum(height)}}"
}

class Circle(val radius: Double) : Geometry {
    override fun area() = PI * radius * radius
    override fun perim() = 2 * PI * radius
    override fun toString() = "{${fmtNum(radius)}}"
}

fun fmtNum(d: Double) = if (d == d.toLong().toDouble()) d.toLong().toString() else d.toString()

fun measure(g: Geometry) {
    println(g)
    println(fmtNum(g.area()))
    println(fmtNum(g.perim()))
}

fun main() {
    val r = Rect(3.0, 4.0)
    val c = Circle(5.0)
    measure(r)
    measure(c)
}
