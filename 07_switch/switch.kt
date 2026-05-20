import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime

fun main() {
    val i = 2
    print("Write $i as ")
    when (i) {
        1 -> println("one")
        2 -> println("two")
        3 -> println("three")
    }

    when (LocalDate.now().dayOfWeek) {
        DayOfWeek.SATURDAY, DayOfWeek.SUNDAY -> println("It's the weekend")
        else -> println("It's a weekday")
    }

    val t = LocalTime.now()
    when {
        t.hour < 12 -> println("It's before noon")
        else -> println("It's after noon")
    }

    val whatAmI = { x: Any ->
        when (x) {
            is Boolean -> println("I'm a bool")
            is Int -> println("I'm an int")
            else -> println("Don't know type ${x::class.simpleName}")
        }
    }
    whatAmI(true)
    whatAmI(1)
    whatAmI("hey")
}
