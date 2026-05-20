Kotlin uses `Thread.join()` in place of Go's `sync.WaitGroup`; worker start/done ordering is nondeterministic.

___

##### Run Command:
`kotlinc waitgroups.kt -include-runtime -d waitgroups.jar && java -jar waitgroups.jar`

##### Results:
`Worker 1 starting`
`Worker 2 starting`
`Worker 3 starting`
`Worker 4 starting`
`Worker 5 starting`
`Worker 1 done`
`Worker 2 done`
`Worker 3 done`
`Worker 4 done`
`Worker 5 done`
