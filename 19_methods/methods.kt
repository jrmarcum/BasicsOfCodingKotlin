class Rect(val width: Int, val height: Int) {
    fun area(): Int = width * height
    fun perim(): Int = 2 * width + 2 * height
}

fun main() {
    val r = Rect(10, 5)
    println("area:  ${r.area()}")
    println("perim: ${r.perim()}")

    val rp = r
    println("area:  ${rp.area()}")
    println("perim: ${rp.perim()}")
}
