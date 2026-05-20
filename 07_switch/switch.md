Kotlin uses `when` instead of `switch`. The weekday and time-of-day lines reflect the actual day and time when run. Kotlin's `x::class.simpleName` yields capitalized type names (e.g. `String` vs Go's `string`).

___

##### Run Command:
`kotlinc switch.kt -include-runtime -d switch.jar && java -jar switch.jar`

##### Results:
`Write 2 as two`
`It's a weekday`
`It's after noon`
`I'm a bool`
`I'm an int`
`Don't know type String`
