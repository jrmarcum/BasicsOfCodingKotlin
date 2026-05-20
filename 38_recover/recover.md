Kotlin uses `try/catch` with `RuntimeException` in place of Go's `defer`+`recover`+`panic`.

___

##### Run Command:
`kotlinc recover.kt -include-runtime -d recover.jar && java -jar recover.jar`

##### Results:
`Recovered. Error:`
` a problem`
