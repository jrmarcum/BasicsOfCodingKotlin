RFC3339-parsed times show `+0000 UTC` in Kotlin vs Go's `+0000 +0000`; custom format patterns use Java's `DateTimeFormatter`. Results vary with each run.

___

##### Run Command:
`kotlinc time-formatting-parsing.kt -include-runtime -d time-formatting-parsing.jar && java -jar time-formatting-parsing.jar`

##### Results:
`2026-05-20T01:14:22-04:00`
`2012-11-01 22:08:41 +0000 UTC`
`1:14AM`
`Wed May 20 01:14:22 2026`
`2026-05-20T01:14:22.750977-04:00`
`0000-01-01 20:41:00 +0000 UTC`
`2026-05-20T01:14:22-00:00`
`parsing time "8:41PM" as "Mon Jan _2 15:04:05 2006": cannot parse "8:41PM" as "Mon"`
