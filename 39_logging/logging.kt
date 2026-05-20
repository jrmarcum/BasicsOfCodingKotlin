import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private val fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
private fun ts() = LocalDateTime.now().format(fmt)

class SimpleLogger(private var prefix: String = "", private val out: PrintStream = System.err) {
    fun println(msg: String) = out.println("$prefix${ts()} $msg")
    fun setPrefix(p: String) { prefix = p }
}

fun main() {
    val log = SimpleLogger(out = System.err)
    log.println("standard logger")
    log.println("with micro")
    log.println("with file/line")

    val mylog = SimpleLogger(prefix = "my:", out = System.out)
    mylog.println("from mylog")
    mylog.setPrefix("ohmy:")
    mylog.println("from mylog")

    val buf = ByteArrayOutputStream()
    val buflog = SimpleLogger(prefix = "buf:", out = PrintStream(buf))
    buflog.println("hello")
    print("from buflog:${buf.toString()}")

    System.err.println("""{"time":"${LocalDateTime.now()}","level":"INFO","msg":"hi there"}""")
    System.err.println("""{"time":"${LocalDateTime.now()}","level":"INFO","msg":"hello again","key":"val","age":25}""")
}
