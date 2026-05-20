fun <E> slicesIndex(s: List<E>, v: E): Int {
    for (i in s.indices) {
        if (v == s[i]) return i
    }
    return -1
}

class SinglyLinkedList<T> {
    private class Node<T>(val value: T, var next: Node<T>? = null)

    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    fun push(v: T) {
        val node = Node(v)
        if (tail == null) {
            head = node
            tail = node
        } else {
            tail!!.next = node
            tail = node
        }
    }

    fun allElements(): List<T> {
        val elems = mutableListOf<T>()
        var e = head
        while (e != null) {
            elems.add(e.value)
            e = e.next
        }
        return elems
    }
}

fun main() {
    val s = listOf("foo", "bar", "zoo")
    println("index of zoo: ${slicesIndex(s, "zoo")}")

    val lst = SinglyLinkedList<Int>()
    lst.push(10)
    lst.push(13)
    lst.push(23)
    println("list: ${lst.allElements().joinToString(" ", "[", "]")}")
}
