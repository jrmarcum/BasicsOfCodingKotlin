import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter

fun main() {
    File("./tmp/dat1.txt").writeText("hello\ngo\n")

    val f = FileOutputStream("./tmp/dat2.txt")
    try {
        val d2 = byteArrayOf(115, 111, 109, 101, 10)
        f.write(d2)
        println("wrote ${d2.size} bytes")

        val s3 = "writes\n"
        f.write(s3.toByteArray())
        println("wrote ${s3.length} bytes")

        f.flush()

        val w = BufferedWriter(OutputStreamWriter(f))
        val s4 = "buffered\n"
        w.write(s4)
        println("wrote ${s4.length} bytes")
        w.flush()
    } finally {
        f.close()
    }
}
