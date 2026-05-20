import java.io.File
import java.nio.file.Paths

fun main() {
    val p = Paths.get("dir1", "dir2", "filename").toString()
    println("p: $p")

    println(Paths.get("dir1//", "filename").normalize())
    println(Paths.get("dir1/../dir1", "filename").normalize())

    val pFile = File(p)
    println("Dir(p): ${pFile.parent}")
    println("Base(p): ${pFile.name}")

    println(File("dir/file").isAbsolute)
    println(File("/dir/file").isAbsolute)

    val filename = "config.json"
    val dot = filename.lastIndexOf('.')
    val ext = if (dot == -1) "" else filename.substring(dot)
    println(ext)
    println(filename.removeSuffix(ext))

    val rel1 = Paths.get("a/b").relativize(Paths.get("a/b/t/file")).toString()
    println(rel1)

    val rel2 = Paths.get("a/b").relativize(Paths.get("a/c/t/file")).toString()
    println(rel2)
}
