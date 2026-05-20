import java.io.BufferedWriter
import java.io.File

fun createFile(p: String): BufferedWriter {
    println("creating")
    return File(p).bufferedWriter()
}

fun writeFile(f: BufferedWriter) {
    println("writing")
    f.write("data\n")
}

fun closeFile(f: BufferedWriter) {
    println("closing")
    f.close()
}

fun main() {
    val f = createFile("./tmp/defer.txt")
    try {
        writeFile(f)
    } finally {
        closeFile(f)
    }
}
