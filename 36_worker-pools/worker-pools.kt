import java.util.concurrent.LinkedBlockingQueue

fun main() {
    val numJobs = 5
    val jobs = LinkedBlockingQueue<Int>()
    val results = LinkedBlockingQueue<Int>()

    for (j in 1..numJobs) jobs.put(j)

    val workers = (1..3).map { w ->
        Thread {
            var j = jobs.poll()
            while (j != null) {
                println("worker $w started  job $j")
                Thread.sleep(1000)
                println("worker $w finished job $j")
                results.put(j * 2)
                j = jobs.poll()
            }
        }
    }
    workers.forEach { it.start() }

    repeat(numJobs) { results.take() }
}
