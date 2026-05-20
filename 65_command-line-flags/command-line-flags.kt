fun main(args: Array<String>) {
    var word = "foo"
    var numb = 42
    var fork = false
    var svar = "bar"
    val tail = mutableListOf<String>()

    var i = 0
    while (i < args.size) {
        val arg = args[i]
        when {
            arg.startsWith("-word=") || arg.startsWith("--word=") -> { word = arg.substringAfter('='); i++ }
            arg == "-word" || arg == "--word" -> { word = args[++i]; i++ }
            arg.startsWith("-numb=") || arg.startsWith("--numb=") -> { numb = arg.substringAfter('=').toInt(); i++ }
            arg == "-numb" || arg == "--numb" -> { numb = args[++i].toInt(); i++ }
            arg == "-fork" || arg == "--fork" -> { fork = true; i++ }
            arg.startsWith("-svar=") || arg.startsWith("--svar=") -> { svar = arg.substringAfter('='); i++ }
            arg == "-svar" || arg == "--svar" -> { svar = args[++i]; i++ }
            else -> { tail.add(arg); i++ }
        }
    }

    println("word: $word")
    println("numb: $numb")
    println("fork: $fork")
    println("svar: $svar")
    println("tail: ${tail.joinToString(" ", "[", "]")}")
}
