Kotlin uses `LinkedBlockingQueue` (JVM) in place of Go channels; `kotlinx.coroutines Channel<T>` is the idiomatic alternative.

___

##### Run Command:
`kotlinc channels.kt -include-runtime -d channels.jar && java -jar channels.jar`

##### Results:
`ping`
