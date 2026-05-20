import java.io.File

fun visit(f: File): String = f.path.replace('\\', '/')

fun main() {
    val subdir = File("subdir")
    subdir.mkdir()

    try {
        File("subdir/file1").writeBytes(ByteArray(0))

        File("subdir/parent/child").mkdirs()
        File("subdir/parent/file2").writeBytes(ByteArray(0))
        File("subdir/parent/file3").writeBytes(ByteArray(0))
        File("subdir/parent/child/file4").writeBytes(ByteArray(0))

        val c = File("subdir/parent").listFiles()!!.sortedBy { it.name }
        println("Listing subdir/parent")
        for (entry in c) {
            println("  ${entry.name} ${entry.isDirectory}")
        }

        val childContents = File("subdir/parent/child").listFiles()!!.sortedBy { it.name }
        println("Listing subdir/parent/child")
        for (entry in childContents) {
            println("  ${entry.name} ${entry.isDirectory}")
        }

        println("Visiting subdir")
        File("subdir").walk().sortedBy { it.path }.forEach { f ->
            println("  ${visit(f)} ${f.isDirectory}")
        }
    } finally {
        subdir.deleteRecursively()
    }
}
