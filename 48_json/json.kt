data class Response1(val page: Int, val fruits: List<String>)

data class Response2(var page: Int = 0, var fruits: List<String> = emptyList()) {
    override fun toString() = "{$page ${fruits.joinToString(" ", "[", "]")}}"
}

fun toJson(v: Any?): String = when (v) {
    null -> "null"
    is Boolean -> v.toString()
    is Number -> {
        val d = v.toDouble()
        if (d == d.toLong().toDouble()) d.toLong().toString() else d.toString()
    }
    is String -> "\"$v\""
    is List<*> -> "[${v.joinToString(",") { toJson(it) }}]"
    is Map<*, *> -> "{${v.entries.sortedBy { it.key.toString() }.joinToString(",") { "\"${it.key}\":${toJson(it.value)}" }}}"
    else -> "null"
}

class JsonParser(private val input: String) {
    var pos = 0

    private fun skipWs() { while (pos < input.length && input[pos].isWhitespace()) pos++ }

    fun parseValue(): Any? {
        skipWs()
        if (pos >= input.length) return null
        return when (input[pos]) {
            '"' -> parseStr()
            '[' -> parseArr()
            '{' -> parseObj()
            't' -> { pos += 4; true }
            'f' -> { pos += 5; false }
            'n' -> { pos += 4; null }
            else -> parseNum()
        }
    }

    private fun parseStr(): String {
        pos++ // skip opening "
        val sb = StringBuilder()
        while (pos < input.length && input[pos] != '"') {
            if (input[pos] == '\\') { pos++; sb.append(input[pos]) }
            else sb.append(input[pos])
            pos++
        }
        pos++ // skip closing "
        return sb.toString()
    }

    private fun parseArr(): List<Any?> {
        pos++ // skip [
        skipWs()
        val list = mutableListOf<Any?>()
        while (pos < input.length && input[pos] != ']') {
            list.add(parseValue())
            skipWs()
            if (pos < input.length && input[pos] == ',') pos++
        }
        pos++ // skip ]
        return list
    }

    private fun parseObj(): Map<String, Any?> {
        pos++ // skip {
        skipWs()
        val map = mutableMapOf<String, Any?>()
        while (pos < input.length && input[pos] != '}') {
            skipWs()
            val key = parseStr()
            skipWs()
            pos++ // skip :
            val value = parseValue()
            map[key] = value
            skipWs()
            if (pos < input.length && input[pos] == ',') pos++
        }
        pos++ // skip }
        return map
    }

    private fun parseNum(): Number {
        val start = pos
        while (pos < input.length && (input[pos].isDigit() || input[pos] in ".-+eE")) pos++
        val s = input.substring(start, pos)
        return if ('.' in s || 'e' in s || 'E' in s) s.toDouble() else s.toLong()
    }
}

fun fromJson(json: String): Any? = JsonParser(json.trim()).parseValue()

fun fmtJsonVal(v: Any?): String = when (v) {
    is List<*> -> "[${v.joinToString(" ") { fmtJsonVal(it) }}]"
    else -> v.toString()
}

fun fmtGoMap(m: Map<*, *>): String {
    val parts = m.entries.sortedBy { it.key.toString() }.joinToString(" ") { "${it.key}:${fmtJsonVal(it.value)}" }
    return "map[$parts]"
}

fun main() {
    println(toJson(true))
    println(toJson(1))
    println(toJson(2.34))
    println(toJson("vector"))

    val slcD = listOf("apple", "peach", "pear")
    println(toJson(slcD))

    val mapD = mapOf("apple" to 5, "lettuce" to 7)
    println(toJson(mapD))

    val res1D = Response1(1, listOf("apple", "peach", "pear"))
    println("{\"Page\":${res1D.page},\"Fruits\":${toJson(res1D.fruits)}}")

    val res2D = Response2(1, listOf("apple", "peach", "pear"))
    println("{\"page\":${res2D.page},\"fruits\":${toJson(res2D.fruits)}}")

    val byt = """{"num":6.13,"strs":["a","b"]}"""
    @Suppress("UNCHECKED_CAST")
    val dat = fromJson(byt) as Map<String, Any?>
    println(fmtGoMap(dat))

    val num = dat["num"] as Double
    println(num)

    @Suppress("UNCHECKED_CAST")
    val strs = dat["strs"] as List<Any?>
    val str1 = strs[0] as String
    println(str1)

    val str = """{"page": 1, "fruits": ["apple", "peach"]}"""
    @Suppress("UNCHECKED_CAST")
    val resMap = fromJson(str) as Map<String, Any?>
    val res = Response2(
        page = (resMap["page"] as Long).toInt(),
        fruits = (resMap["fruits"] as List<*>).map { it as String }
    )
    println(res)
    println(res.fruits[0])

    val d = mapOf("apple" to 5, "lettuce" to 7)
    println(toJson(d))
}
