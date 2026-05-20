Kotlin uses `ScheduledExecutorService` in place of Go's time.NewTimer; `future.cancel(false)` replaces timer.Stop().

___

##### Run Command:
`kotlinc timers.kt -include-runtime -d timers.jar && java -jar timers.jar`

##### Results:
`Timer 1 fired`
`Timer 2 stopped`
