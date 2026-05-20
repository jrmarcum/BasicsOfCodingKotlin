import java.net.URI

fun main() {
    val s = "postgres://user:pass@host.com:5432/path?k=v#f"
    val u = URI(s)

    println(u.scheme)

    println(u.userInfo)
    val userParts = u.userInfo.split(":", limit = 2)
    println(userParts[0])
    println(userParts[1])

    println("${u.host}:${u.port}")
    println(u.host)
    println(u.port)

    println(u.path)
    println(u.fragment)

    println(u.rawQuery)
    val queryMap = u.rawQuery.split("&").associate { pair ->
        val (k, v) = pair.split("=", limit = 2)
        k to listOf(v)
    }
    println("map[${queryMap.entries.joinToString(" ") { "${it.key}:[${it.value.joinToString(" ")}]" }}]")
    println(queryMap["k"]!![0])
}
