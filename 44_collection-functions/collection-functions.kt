fun index(vs: List<String>, t: String): Int {
    for ((i, v) in vs.withIndex()) {
        if (v == t) return i
    }
    return -1
}

fun include(vs: List<String>, t: String): Boolean = index(vs, t) >= 0

fun any(vs: List<String>, f: (String) -> Boolean): Boolean {
    for (v in vs) { if (f(v)) return true }
    return false
}

fun all(vs: List<String>, f: (String) -> Boolean): Boolean {
    for (v in vs) { if (!f(v)) return false }
    return true
}

fun filter(vs: List<String>, f: (String) -> Boolean): List<String> {
    val result = mutableListOf<String>()
    for (v in vs) { if (f(v)) result.add(v) }
    return result
}

fun map(vs: List<String>, f: (String) -> String): List<String> {
    val result = mutableListOf<String>()
    for (v in vs) result.add(f(v))
    return result
}

fun main() {
    val strs = listOf("peach", "apple", "pear", "plum")

    println(index(strs, "pear"))
    println(include(strs, "grape"))
    println(any(strs) { it.startsWith("p") })
    println(all(strs) { it.startsWith("p") })
    println(filter(strs) { it.contains("e") }.joinToString(" ", "[", "]"))
    println(map(strs) { it.uppercase() }.joinToString(" ", "[", "]"))
}
