fun main() {
    var i = 1
    while (i <= 3) {
        println(i)
        i++
    }

    for (j in 7..9) {
        println(j)
    }

    while (true) {
        println("loop")
        break
    }

    for (n in 0..5) {
        if (n % 2 == 0) continue
        println(n)
    }
}
