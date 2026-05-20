#### Run the TCP server in the background, then send data and capture the response using netcat.
___
##### Run Command:
`$ kotlinc tcp-server.kt -include-runtime -d tcp-server.jar && java -jar tcp-server.jar &`
`$ echo "Hello from netcat" | nc localhost 8090`

##### Results:
`ACK: HELLO FROM NETCAT`
