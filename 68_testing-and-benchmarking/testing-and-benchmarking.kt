fun intMin(a: Int, b: Int): Int = if (a < b) a else b

data class TestCase(val a: Int, val b: Int, val want: Int)

fun main() {
    var allPassed = true

    println("=== RUN   TestIntMinBasic")
    run {
        val ans = intMin(2, -2)
        if (ans != -2) {
            println("    IntMin(2, -2) = $ans; want -2")
            println("--- FAIL: TestIntMinBasic (0.00s)")
            allPassed = false
        } else {
            println("--- PASS: TestIntMinBasic (0.00s)")
        }
    }

    val tests = listOf(
        TestCase(0, 1, 0),
        TestCase(1, 0, 0),
        TestCase(2, -2, -2),
        TestCase(0, -1, -1),
        TestCase(-1, 0, -1)
    )

    println("=== RUN   TestIntMinTableDriven")
    var tablePassed = true
    for (tt in tests) {
        val name = "${tt.a},${tt.b}"
        println("=== RUN   TestIntMinTableDriven/$name")
        val ans = intMin(tt.a, tt.b)
        if (ans != tt.want) {
            println("    got $ans, want ${tt.want}")
            println("    --- FAIL: TestIntMinTableDriven/$name (0.00s)")
            tablePassed = false
            allPassed = false
        } else {
            println("    --- PASS: TestIntMinTableDriven/$name (0.00s)")
        }
    }
    if (tablePassed) {
        println("--- PASS: TestIntMinTableDriven (0.00s)")
    } else {
        println("--- FAIL: TestIntMinTableDriven (0.00s)")
    }

    if (allPassed) {
        println("PASS")
        println("ok  \ttesting-and-benchmarking\t0.023s")
    } else {
        println("FAIL")
    }
}
