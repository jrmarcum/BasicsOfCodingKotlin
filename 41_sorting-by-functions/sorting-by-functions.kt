fun main() {
    val fruits = mutableListOf("peach", "banana", "kiwi")
    fruits.sortWith(compareBy { it.length })
    println(fruits.joinToString(" ", "[", "]"))
}
