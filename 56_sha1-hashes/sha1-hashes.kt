import java.security.MessageDigest

fun main() {
    val s = "sha1 this string"
    val h = MessageDigest.getInstance("SHA-1")
    h.update(s.toByteArray())
    val bs = h.digest()
    println(s)
    println(bs.joinToString("") { "%02x".format(it.toInt() and 0xFF) })
}
