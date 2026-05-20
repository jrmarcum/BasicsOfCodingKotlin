Kotlin uses `scheduleAtFixedRate` in place of Go's time.NewTicker; timestamps are ISO 8601 format (e.g. 2026-05-20T00:43:21.474549500) rather than Go's RFC3339 format. Results vary with run time.

___

##### Run Command:
`kotlinc tickers.kt -include-runtime -d tickers.jar && java -jar tickers.jar`

##### Results:
`Tick at 2026-05-20T00:43:21.474549500`
`Tick at 2026-05-20T00:43:21.956437500`
`Tick at 2026-05-20T00:43:22.456600100`
`Ticker stopped`
