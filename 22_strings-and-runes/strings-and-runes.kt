fun fmtRune(cp: Int): String = "U+%04X '${String(Character.toChars(cp))}'" .format(cp)

fun examineRune(r: Int) {
    if (r == 't'.code) println("found tee")
    else if (r == 'ส'.code) println("found so sua")
}

fun main() {
    val s = "สวัสดี"
    val bytes = s.toByteArray(Charsets.UTF_8)

    println("Len: ${bytes.size}")

    print(bytes.joinToString(" ") { "%x".format(it.toInt() and 0xFF) } + " ")
    println()

    println("Rune count: ${s.codePointCount(0, s.length)}")

    var byteIdx = 0
    var charIdx = 0
    while (charIdx < s.length) {
        val cp = s.codePointAt(charIdx)
        val cpWidth = Character.charCount(cp)
        val byteWidth = String(Character.toChars(cp)).toByteArray(Charsets.UTF_8).size
        println("${fmtRune(cp)} starts at $byteIdx")
        byteIdx += byteWidth
        charIdx += cpWidth
    }

    println()
    println("Using DecodeRuneInString")
    byteIdx = 0
    charIdx = 0
    while (charIdx < s.length) {
        val cp = s.codePointAt(charIdx)
        val cpWidth = Character.charCount(cp)
        val byteWidth = String(Character.toChars(cp)).toByteArray(Charsets.UTF_8).size
        println("${fmtRune(cp)} starts at $byteIdx")
        examineRune(cp)
        byteIdx += byteWidth
        charIdx += cpWidth
    }
}
