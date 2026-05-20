import java.nio.file.Files

fun main() {
    val f = Files.createTempFile("sample", "")
    println("Temp file name: $f")

    try {
        f.toFile().writeBytes(byteArrayOf(1, 2, 3, 4))
    } finally {
        Files.deleteIfExists(f)
    }

    val dname = Files.createTempDirectory("sampledir")
    println("Temp dir name: $dname")

    try {
        val fname = dname.resolve("file1")
        fname.toFile().writeBytes(byteArrayOf(1, 2))
    } finally {
        dname.toFile().deleteRecursively()
    }
}
