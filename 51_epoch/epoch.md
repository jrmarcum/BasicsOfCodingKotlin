Uses `java.time.Instant` for epoch conversions; time format matches Go's UTC layout. Results vary with each run.

___

##### Run Command:
`kotlinc epoch.kt -include-runtime -d epoch.jar && java -jar epoch.jar`

##### Results:
`2026-05-20 05:14:03.5941222 +0000 UTC`
`1779254043`
`1779254043594`
`1779254043594122200`
`2026-05-20 05:14:03 +0000 UTC`
`2026-05-20 05:14:03.5941222 +0000 UTC`
