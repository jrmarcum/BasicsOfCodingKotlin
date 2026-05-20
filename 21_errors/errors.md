Kotlin uses exceptions and Pair<Int, Exception?> to mirror Go's error return pattern; `is` replaces Go's type assertion.

___

##### Run Command:
`kotlinc errors.kt -include-runtime -d errors.jar && java -jar errors.jar`

##### Results:
`f1 worked: 10`
`f1 failed: can't work with 42`
`f2 worked: 10`
`f2 failed: 42 - can't work with it`
`42`
`can't work with it`
