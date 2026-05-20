Kotlin uses `Thread` in place of goroutines; `kotlinx.coroutines` with `launch {}` is the idiomatic alternative. The interleaved lines after `direct` are nondeterministic.

___

##### Run Command:
`kotlinc goroutines.kt -include-runtime -d goroutines.jar && java -jar goroutines.jar`

##### Results:
`direct : 0`
`direct : 1`
`direct : 2`
`goroutine : 0`
`going`
`goroutine : 1`
`goroutine : 2`
`done`
