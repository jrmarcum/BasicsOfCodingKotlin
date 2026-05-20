Kotlin uses `try-finally` in place of Go's `defer` keyword. Requires a `tmp/` directory at runtime.

___

##### Run Command:
`kotlinc defer.kt -include-runtime -d defer.jar && java -jar defer.jar`

##### Results:
`creating`
`writing`
`closing`
