Uses Kotlin's `toDouble()`, `toLong()`, `java.lang.Long.decode()` for hex; error message matches Go's `strconv.Atoi` format.

___

##### Run Command:
`kotlinc number-parsing.kt -include-runtime -d number-parsing.jar && java -jar number-parsing.jar`

##### Results:
`1.234`
`123`
`456`
`789`
`135`
`strconv.Atoi: parsing "wat": invalid syntax`
