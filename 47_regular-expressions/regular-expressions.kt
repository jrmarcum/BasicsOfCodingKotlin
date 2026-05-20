fun main() {
    val matched = Regex("p([a-z]+)ch").containsMatchIn("peach")
    println(matched)

    val r = Regex("p([a-z]+)ch")

    println(r.containsMatchIn("peach"))

    println(r.find("peach punch")?.value)

    val loc = r.find("peach punch")?.range
    println("[${loc!!.first} ${loc.last + 1}]")

    val m = r.find("peach punch")!!
    println("[${m.value} ${m.groupValues[1]}]")

    val si = r.find("peach punch")!!
    val g1 = si.groups[1]!!
    println("[${si.range.first} ${si.range.last + 1} ${g1.range.first} ${g1.range.last + 1}]")

    println(r.findAll("peach punch pinch").map { it.value }.joinToString(" ", "[", "]"))

    val allIdx = r.findAll("peach punch pinch").map { match ->
        val indices = mutableListOf(match.range.first, match.range.last + 1)
        match.groups.drop(1).forEach { g ->
            if (g != null) { indices.add(g.range.first); indices.add(g.range.last + 1) }
        }
        "[${indices.joinToString(" ")}]"
    }.toList()
    println("[${allIdx.joinToString(" ")}]")

    println(r.findAll("peach punch pinch").take(2).map { it.value }.joinToString(" ", "[", "]"))

    println(r.containsMatchIn("peach"))

    println(r.pattern)

    println(r.replace("a peach", "<fruit>"))

    println(r.replace("a peach") { it.value.uppercase() })
}
