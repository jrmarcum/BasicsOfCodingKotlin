fun sum(vararg nums: Int) {
    print(nums.joinToString(" ", "[", "]") + " ")
    println(nums.sum())
}

fun main() {
    sum(1, 2)
    sum(1, 2, 3)

    val nums = intArrayOf(1, 2, 3, 4)
    sum(*nums)
}
