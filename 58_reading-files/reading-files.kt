import java.io.File
import java.io.RandomAccessFile

fun main() {
    print(File("./tmp/dat.txt").readText())

    val f = RandomAccessFile("./tmp/dat.txt", "r")

    val b1 = ByteArray(5)
    val n1 = f.read(b1)
    println("$n1 bytes: ${String(b1, 0, n1)}")

    f.seek(6)
    val b2 = ByteArray(2)
    val n2 = f.read(b2)
    println("$n2 bytes @ 6: ${String(b2, 0, n2)}")

    f.seek(6)
    val b3 = ByteArray(2)
    var n3 = 0
    while (n3 < 2) {
        val r = f.read(b3, n3, 2 - n3)
        if (r == -1) break
        n3 += r
    }
    println("$n3 bytes @ 6: ${String(b3, 0, n3)}")

    f.seek(0)
    val b4 = ByteArray(5)
    f.read(b4)
    println("5 bytes: ${String(b4)}")

    f.close()
}
