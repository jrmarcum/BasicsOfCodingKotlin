import kotlin.random.Random

fun main() {
    val r = Random.Default
    print("${r.nextInt(100)},")
    println(r.nextInt(100))

    println(r.nextDouble())

    print("${(r.nextDouble() * 5) + 5},")
    println((r.nextDouble() * 5) + 5)

    val r1 = Random(System.nanoTime())
    print("${r1.nextInt(100)},")
    println(r1.nextInt(100))

    val r2 = Random(42)
    print("${r2.nextInt(100)},")
    println(r2.nextInt(100))

    val r3 = Random(42)
    print("${r3.nextInt(100)},")
    print(r3.nextInt(100))
}
