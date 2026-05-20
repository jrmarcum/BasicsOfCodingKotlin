Kotlin has native enum classes; `toString()` is overridden to return lowercase names matching Go's iota-based string map.

___

##### Run Command:
`kotlinc enums.kt -include-runtime -d enums.jar && java -jar enums.jar`

##### Results:
`connected`
`idle`
