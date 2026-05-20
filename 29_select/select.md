A shared `LinkedBlockingQueue` replaces Go's `select` on multiple channels; both goroutines publish to the same queue and `take()` blocks until either arrives.

___

##### Run Command:
`kotlinc select.kt -include-runtime -d select.jar && java -jar select.jar`

##### Results:
`received one`
`received two`
