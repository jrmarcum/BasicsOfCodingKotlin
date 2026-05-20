data class Person(val Name: String)

fun fmtVal(v: Any?): String = when (v) {
    is List<*> -> "[${v.joinToString(" ")}]"
    null -> "<nil>"
    else -> v.toString()
}

fun fieldOf(obj: Any?, name: String): Any? = when (obj) {
    is Map<*, *> -> obj[name]
    null -> null
    else -> obj.javaClass.declaredFields.find { it.name == name }
        ?.also { it.isAccessible = true }?.get(obj)
}

fun truthy(v: Any?) = v != null && v != false && v != 0 && v != ""

class Template(private val src: String) {
    fun execute(data: Any?) = print(render(src, data))

    private data class Block(
        val body: String,
        val elseBody: String?,
        val elseTA: Boolean,
        val nextI: Int
    )

    private fun extractBlock(t: String, start: Int): Block {
        var depth = 1
        var pos = start
        var elseAt = -1
        var elseBodyAt = -1
        var elseTA = false
        while (pos < t.length) {
            val a = t.indexOf("{{", pos).takeIf { it >= 0 } ?: break
            val b = t.indexOf("}}", a + 2).takeIf { it >= 0 } ?: break
            val raw = t.substring(a + 2, b)
            val action = raw.trim('-').trim()
            when {
                action.startsWith("if ") || action.startsWith("range ") -> depth++
                action == "end" -> {
                    depth--
                    if (depth == 0) {
                        val bodyEnd = if (elseAt >= 0) elseAt else a
                        return Block(
                            body = t.substring(start, bodyEnd),
                            elseBody = if (elseBodyAt >= 0) t.substring(elseBodyAt, a) else null,
                            elseTA = elseTA,
                            nextI = b + 2
                        )
                    }
                }
                action == "else" && depth == 1 -> {
                    elseAt = a
                    elseBodyAt = b + 2
                    elseTA = raw.endsWith("-")
                }
            }
            pos = b + 2
        }
        return Block(t.substring(start), null, false, t.length)
    }

    private fun render(t: String, data: Any?): String {
        val sb = StringBuilder()
        var i = 0
        while (i < t.length) {
            val a = t.indexOf("{{", i)
            if (a < 0) { sb.append(t.substring(i)); break }
            sb.append(t.substring(i, a))
            val b = t.indexOf("}}", a + 2).takeIf { it >= 0 } ?: run { sb.append(t[i++]); continue }
            val raw = t.substring(a + 2, b)
            val trimAfter = raw.endsWith("-")
            val action = raw.trim('-').trim()
            i = b + 2
            when {
                action == "." -> sb.append(fmtVal(data))
                action.startsWith(".") -> sb.append(fmtVal(fieldOf(data, action.drop(1))))
                action.startsWith("if ") -> {
                    val cond = action.drop(3).trim()
                    val condVal = if (cond == ".") data else fieldOf(data, cond.drop(1))
                    val blk = extractBlock(t, i)
                    val rendered = if (truthy(condVal)) {
                        render(if (trimAfter) blk.body.trimStart() else blk.body, data)
                    } else {
                        blk.elseBody?.let { render(if (blk.elseTA) it.trimStart() else it, data) } ?: ""
                    }
                    sb.append(rendered)
                    i = blk.nextI
                }
                action.startsWith("range ") -> {
                    val rangeVal = action.drop(6).trim()
                    val items = (if (rangeVal == ".") data else fieldOf(data, rangeVal.drop(1))) as? List<*>
                        ?: emptyList<Any>()
                    val blk = extractBlock(t, i)
                    val body = if (trimAfter) blk.body.trimStart() else blk.body
                    for (item in items) sb.append(render(body, item))
                    i = blk.nextI
                }
            }
        }
        return sb.toString()
    }
}

fun main() {
    val t1 = Template("Value: {{.}}\n")
    t1.execute("some text")
    t1.execute(5)
    t1.execute(listOf("Go", "Rust", "C++", "C#"))

    val t2 = Template("Name: {{.Name}}\n")
    t2.execute(Person("Jane Doe"))
    t2.execute(mapOf("Name" to "Mickey Mouse"))

    val t3 = Template("{{if . -}} yes {{else -}} no {{end}}\n")
    t3.execute("not empty")
    t3.execute("")

    val t4 = Template("Range: {{range .}}{{.}} {{end}}\n")
    t4.execute(listOf("Go", "Rust", "C++", "C#"))
}
