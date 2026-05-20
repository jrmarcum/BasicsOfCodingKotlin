fun main(args: Array<String>) {
    val argsWithProg = listOf("command-line-arguments.jar") + args.toList()
    val argsWithoutProg = args.toList()
    val arg = args[2]

    println(argsWithProg.joinToString(" ", "[", "]"))
    println(argsWithoutProg.joinToString(" ", "[", "]"))
    println(arg)
}
