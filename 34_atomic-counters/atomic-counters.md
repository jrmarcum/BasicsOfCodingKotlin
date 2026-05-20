Kotlin uses `AtomicLong.addAndGet` in place of Go's `sync/atomic.Uint64.Add`.

___

##### Run Command:
`kotlinc atomic-counters.kt -include-runtime -d atomic-counters.jar && java -jar atomic-counters.jar`

##### Results:
`ops: 50000`
