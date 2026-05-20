fun intSeq(): () -> Int {
    var i = 0
    return { ++i }
}

fun main() {
    val nextInt = intSeq()
    println(nextInt())
    println(nextInt())
    println(nextInt())

    val newInts = intSeq()
    println(newInts())
}
