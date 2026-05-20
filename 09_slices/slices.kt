fun main() {
    val s = MutableList(3) { "" }
    println("emp: ${s.joinToString(" ", "[", "]")}")

    s[0] = "a"
    s[1] = "b"
    s[2] = "c"
    println("set: ${s.joinToString(" ", "[", "]")}")
    println("get: ${s[2]}")

    println("len: ${s.size}")

    s.add("d")
    s.addAll(listOf("e", "f"))
    println("apd: ${s.joinToString(" ", "[", "]")}")

    val c = s.toMutableList()
    println("cpy: ${c.joinToString(" ", "[", "]")}")

    val l1 = s.subList(2, 5)
    println("sl1: ${l1.joinToString(" ", "[", "]")}")

    val l2 = s.subList(0, 5)
    println("sl2: ${l2.joinToString(" ", "[", "]")}")

    val l3 = s.subList(2, s.size)
    println("sl3: ${l3.joinToString(" ", "[", "]")}")

    val t = mutableListOf("g", "h", "i")
    println("dcl: ${t.joinToString(" ", "[", "]")}")

    val twoD = Array(3) { i -> MutableList(i + 1) { j -> i + j } }
    println("2d:  ${twoD.joinToString(" ", "[", "]") { it.joinToString(" ", "[", "]") }}")
}
