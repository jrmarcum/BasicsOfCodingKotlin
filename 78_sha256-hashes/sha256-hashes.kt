import java.security.MessageDigest

fun main() {
    val s = "sha256 this string"
    val digest = MessageDigest.getInstance("SHA-256")
    val bs = digest.digest(s.toByteArray())
    println(s)
    println(bs.joinToString("") { "%02x".format(it.toInt() and 0xFF) })
}
