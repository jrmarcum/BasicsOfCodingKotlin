Kotlin uses `ScheduledExecutorService` and `LinkedBlockingQueue` in place of Go's `time.Tick` channel; timestamps are ISO 8601 format and vary with run time. First 3 bursty requests are served immediately.

___

##### Run Command:
`kotlinc rate-limiting.kt -include-runtime -d rate-limiting.jar && java -jar rate-limiting.jar`

##### Results:
`request 1 2026-05-20T00:47:20.127379300`
`request 2 2026-05-20T00:47:20.307072`
`request 3 2026-05-20T00:47:20.506704600`
`request 4 2026-05-20T00:47:20.708330700`
`request 5 2026-05-20T00:47:20.907527700`
`request 1 2026-05-20T00:47:20.908881200`
`request 2 2026-05-20T00:47:20.908881200`
`request 3 2026-05-20T00:47:20.908881200`
`request 4 2026-05-20T00:47:21.110935300`
`request 5 2026-05-20T00:47:21.309877`
