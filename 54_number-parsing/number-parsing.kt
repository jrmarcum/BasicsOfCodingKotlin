fun main() {
    val f = "1.234".toDouble()
    println(f)

    val i = "123".toLong()
    println(i)

    val d = java.lang.Long.decode("0x1c8")
    println(d)

    val u = "789".toULong()
    println(u)

    val k = "135".toInt()
    println(k)

    try {
        "wat".toInt()
    } catch (e: NumberFormatException) {
        println("strconv.Atoi: parsing \"wat\": invalid syntax")
    }
}
