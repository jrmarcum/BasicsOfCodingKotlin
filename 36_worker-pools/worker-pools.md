Kotlin uses `LinkedBlockingQueue` and `Thread` in place of Go's buffered channels and goroutines; job/finish ordering is nondeterministic.

___

##### Run Command:
`kotlinc worker-pools.kt -include-runtime -d worker-pools.jar && java -jar worker-pools.jar`

##### Results:
`worker 1 started  job 1`
`worker 2 started  job 2`
`worker 3 started  job 3`
`worker 1 finished job 1`
`worker 1 started  job 4`
`worker 2 finished job 2`
`worker 2 started  job 5`
`worker 3 finished job 3`
`worker 1 finished job 4`
`worker 2 finished job 5`
