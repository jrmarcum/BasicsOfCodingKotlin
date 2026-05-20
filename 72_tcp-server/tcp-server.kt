import java.net.ServerSocket

fun handleConnection(socket: java.net.Socket) {
    socket.use {
        val line = it.getInputStream().bufferedReader().readLine() ?: return
        val response = "ACK: ${line.trim().uppercase()}\n"
        it.getOutputStream().write(response.toByteArray())
    }
}

fun main() {
    val server = ServerSocket(8090)
    server.use {
        while (true) {
            val client = it.accept()
            Thread { handleConnection(client) }.start()
        }
    }
}
