fun main() {
    val a = IntArray(5)
    println("emp: ${a.joinToString(" ", "[", "]")}")

    a[4] = 100
    println("set: ${a.joinToString(" ", "[", "]")}")
    println("get: ${a[4]}")

    println("len: ${a.size}")

    val b = intArrayOf(1, 2, 3, 4, 5)
    println("dcl: ${b.joinToString(" ", "[", "]")}")

    val twoD = Array(2) { IntArray(3) }
    for (i in 0 until 2) {
        for (j in 0 until 3) {
            twoD[i][j] = i + j
        }
    }
    println("2d:  ${twoD.joinToString(" ", "[", "]") { it.joinToString(" ", "[", "]") }}")
}
