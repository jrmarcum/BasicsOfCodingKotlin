fun main() {
    val nums = listOf(2, 3, 4)
    var sum = 0
    for (num in nums) {
        sum += num
    }
    println("sum: $sum")

    for ((i, num) in nums.withIndex()) {
        if (num == 3) {
            println("index: $i")
        }
    }

    val kvs = mapOf("a" to "apple", "b" to "banana")
    for ((k, v) in kvs) {
        println("$k -> $v")
    }

    for (k in kvs.keys) {
        println("key: $k")
    }

    for ((i, c) in "go".withIndex()) {
        println("$i ${c.code}")
    }
}
