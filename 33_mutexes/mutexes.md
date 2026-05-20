Kotlin uses `ReentrantLock` with `try/finally` in place of Go's `sync.Mutex` with `defer Unlock`.

___

##### Run Command:
`kotlinc mutexes.kt -include-runtime -d mutexes.jar && java -jar mutexes.jar`

##### Results:
`map[a:20000 b:10000]`
