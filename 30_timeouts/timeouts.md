Timeouts use `LinkedBlockingQueue.poll(timeout, unit)` in place of Go's channel-select-with-time.After pattern.

___

##### Run Command:
`kotlinc timeouts.kt -include-runtime -d timeouts.jar && java -jar timeouts.jar`

##### Results:
`timeout 1`
`result 2`
