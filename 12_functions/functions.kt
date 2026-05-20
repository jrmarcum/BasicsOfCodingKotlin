fun plus(a: Int, b: Int): Int = a + b

fun plusPlus(a: Int, b: Int, c: Int): Int = a + b + c

fun main() {
    val res = plus(1, 2)
    println("1+2 = $res")

    val res2 = plusPlus(1, 2, 3)
    println("1+2+3 = $res2")
}
