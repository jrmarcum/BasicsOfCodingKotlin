#### Run the server in the background, then simulate a client request to `/hello`. Hit Ctrl+C shortly after to signal cancellation. Context cancellation is implemented with a `CountDownLatch` released by a shutdown hook.
___
##### Run Command:
`$ kotlinc context.kt -include-runtime -d context.jar && java -jar context.jar &`
`$ curl localhost:8090/hello`

##### Results:
`server: hello handler started`
`^C`
`server: context canceled`
`server: hello handler ended`
