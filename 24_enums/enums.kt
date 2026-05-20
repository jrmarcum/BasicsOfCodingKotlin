enum class ServerState {
    Idle, Connected, Error, Retrying;

    override fun toString() = name.lowercase()
}

fun transition(s: ServerState): ServerState = when (s) {
    ServerState.Idle -> ServerState.Connected
    ServerState.Connected, ServerState.Retrying -> ServerState.Idle
    ServerState.Error -> ServerState.Error
}

fun main() {
    val ns = transition(ServerState.Idle)
    println(ns)

    val ns2 = transition(ns)
    println(ns2)
}
