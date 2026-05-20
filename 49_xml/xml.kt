import javax.xml.parsers.DocumentBuilderFactory
import org.w3c.dom.Element

data class Plant(val id: Int, val name: String, val origin: List<String>) {
    override fun toString() = "Plant id=$id, name=$name, origin=${origin.joinToString(" ", "[", "]")}"
}

fun plantToXml(plant: Plant, prefix: String = " ", indent: String = "  "): String = buildString {
    append("$prefix<plant id=\"${plant.id}\">")
    append("\n$prefix$indent<name>${plant.name}</name>")
    for (o in plant.origin) append("\n$prefix$indent<origin>$o</origin>")
    append("\n$prefix</plant>")
}

fun nestingToXml(plants: List<Plant>, prefix: String = " ", indent: String = "  "): String = buildString {
    val i2 = indent + indent
    val i3 = i2 + indent
    append("$prefix<nesting>")
    append("\n$prefix$indent<parent>")
    append("\n$prefix$i2<child>")
    for (p in plants) {
        append("\n")
        append(plantToXml(p, prefix + i3, indent))
    }
    append("\n$prefix$i2</child>")
    append("\n$prefix$indent</parent>")
    append("\n$prefix</nesting>")
}

fun parsePlant(xmlStr: String): Plant {
    val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
        .parse(xmlStr.trim().byteInputStream())
    val root = doc.documentElement as Element
    val id = root.getAttribute("id").toInt()
    val name = root.getElementsByTagName("name").item(0).textContent
    val originNodes = root.getElementsByTagName("origin")
    val origins = (0 until originNodes.length).map { originNodes.item(it).textContent }
    return Plant(id, name, origins)
}

fun main() {
    val coffee = Plant(27, "Coffee", listOf("Ethiopia", "Brazil"))

    val out = plantToXml(coffee)
    println(out)

    val xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
    println(xmlHeader + out)

    val p = parsePlant(out)
    println(p)

    val tomato = Plant(81, "Tomato", listOf("Mexico", "California"))

    println(nestingToXml(listOf(coffee, tomato)))
}
