import java.util.Base64

fun main() {
    val data = "abc123!?${'$'}*&()'-=@~"

    val sEnc = Base64.getEncoder().encodeToString(data.toByteArray())
    println(sEnc)

    val sDec = Base64.getDecoder().decode(sEnc)
    println(String(sDec))
    println()

    val uEnc = Base64.getUrlEncoder().withoutPadding().encodeToString(data.toByteArray())
    println(uEnc)
    val uDec = Base64.getUrlDecoder().decode(uEnc)
    println(String(uDec))
}
