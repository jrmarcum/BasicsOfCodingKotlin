fun <K, V> Map<K, V>.fmt() = "map[${entries.joinToString(" ") { "${it.key}:${it.value}" }}]"

fun main() {
    val m = LinkedHashMap<String, Int>()
    m["k1"] = 7
    m["k2"] = 13
    println("map: ${m.fmt()}")

    val v1 = m["k1"]
    println("v1:  $v1")

    println("len: ${m.size}")

    m.remove("k2")
    println("map: ${m.fmt()}")

    val prs = m.containsKey("k2")
    println("prs: $prs")

    val n = linkedMapOf("foo" to 1, "bar" to 2)
    println("map: ${n.fmt()}")
}
