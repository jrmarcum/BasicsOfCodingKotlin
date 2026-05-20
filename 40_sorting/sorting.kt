fun main() {
    val strs = mutableListOf("c", "a", "b")
    strs.sort()
    println("Strings: ${strs.joinToString(" ", "[", "]")}")

    val ints = mutableListOf(7, 2, 4)
    ints.sort()
    println("Ints:    ${ints.joinToString(" ", "[", "]")}")

    val sorted = ints == ints.sorted()
    println("Sorted:  $sorted")
}
