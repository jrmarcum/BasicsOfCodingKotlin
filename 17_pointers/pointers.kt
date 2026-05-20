fun zeroval(ival: Int) {
    @Suppress("UNUSED_VARIABLE")
    val ignored = 0
}

fun zeroptr(iptr: IntArray) {
    iptr[0] = 0
}

fun main() {
    var i = 1
    println("initial: $i")

    zeroval(i)
    println("zeroval: $i")

    val iRef = intArrayOf(i)
    zeroptr(iRef)
    i = iRef[0]
    println("zeroptr: $i")

    println("pointer: ${Integer.toHexString(System.identityHashCode(iRef))}")
}
