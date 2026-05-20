Kotlin's `Regex` API; `IntRange` is inclusive-end so `range.last + 1` converts to Go's exclusive-end index format.

___

##### Run Command:
`kotlinc regular-expressions.kt -include-runtime -d regular-expressions.jar && java -jar regular-expressions.jar`

##### Results:
`true`
`true`
`peach`
`[0 5]`
`[peach ea]`
`[0 5 1 3]`
`[peach punch pinch]`
`[[0 5 1 3] [6 11 7 9] [12 17 13 15]]`
`[peach punch]`
`true`
`p([a-z]+)ch`
`a <fruit>`
`a PEACH`
