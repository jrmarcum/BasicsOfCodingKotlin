fun parseFoo(args: Array<String>): Triple<Boolean, String, List<String>> {
    var enable = false
    var name = ""
    val tail = mutableListOf<String>()
    var i = 0
    while (i < args.size) {
        val arg = args[i]
        when {
            arg == "-enable" || arg == "--enable" -> { enable = true; i++ }
            arg.startsWith("-name=") || arg.startsWith("--name=") -> { name = arg.substringAfter('='); i++ }
            arg == "-name" || arg == "--name" -> { name = args[++i]; i++ }
            else -> { tail.add(arg); i++ }
        }
    }
    return Triple(enable, name, tail)
}

fun parseBar(args: Array<String>): Pair<Int, List<String>> {
    var level = 0
    val tail = mutableListOf<String>()
    var i = 0
    while (i < args.size) {
        val arg = args[i]
        when {
            arg.startsWith("-level=") || arg.startsWith("--level=") -> { level = arg.substringAfter('=').toInt(); i++ }
            arg == "-level" || arg == "--level" -> { level = args[++i].toInt(); i++ }
            else -> { tail.add(arg); i++ }
        }
    }
    return Pair(level, tail)
}

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("expected 'foo' or 'bar' subcommands")
        System.exit(1)
    }

    when (args[0]) {
        "foo" -> {
            val (enable, name, tail) = parseFoo(args.drop(1).toTypedArray())
            println("subcommand 'foo'")
            println("  enable: $enable")
            println("  name: $name")
            println("  tail: ${tail.joinToString(" ", "[", "]")}")
        }
        "bar" -> {
            val (level, tail) = parseBar(args.drop(1).toTypedArray())
            println("subcommand 'bar'")
            println("  level: $level")
            println("  tail: ${tail.joinToString(" ", "[", "]")}")
        }
        else -> {
            println("expected 'foo' or 'bar' subcommands")
            System.exit(1)
        }
    }
}
