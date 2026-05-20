class Person(var name: String, var age: Int) {
    override fun toString() = "{$name $age}"
}

fun newPerson(name: String): Person {
    val p = Person(name, 0)
    p.age = 42
    return p
}

fun main() {
    println(Person("Bob", 20))
    println(Person("Alice", 30))
    println(Person("Fred", 0))
    println(Person("Ann", 40))
    println(newPerson("Jon"))

    val s = Person("Sean", 50)
    println(s.name)

    val sp = s
    println(sp.age)

    sp.age = 51
    println(sp.age)
}
