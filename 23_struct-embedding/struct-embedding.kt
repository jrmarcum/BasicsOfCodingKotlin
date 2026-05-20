interface Describer {
    fun describe(): String
}

class Base(val num: Int) : Describer {
    override fun describe() = "base with num=$num"
}

class Container(val base: Base, val str: String) : Describer by base {
    val num get() = base.num
}

fun main() {
    val co = Container(Base(1), "some name")

    println("co={num: ${co.num}, str: ${co.str}}")
    println("also num: ${co.base.num}")
    println("describe: ${co.describe()}")

    val d: Describer = co
    println("describer: ${d.describe()}")
}
