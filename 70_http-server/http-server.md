Uses `com.sun.net.httpserver.HttpServer` (JDK built-in); server runs until killed.

___

##### Run Command:
`kotlinc http-server.kt -include-runtime -d http-server.jar && java -jar http-server.jar`

##### Results:
`$ curl localhost:8090/hello`
`hello`
