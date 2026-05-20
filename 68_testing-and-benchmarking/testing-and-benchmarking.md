Implements a minimal inline test runner to match Go's `go test -v` output format; Kotlin's native testing uses `kotlin.test` with JUnit.

___

##### Run Command:
`kotlinc testing-and-benchmarking.kt -include-runtime -d testing-and-benchmarking.jar && java -jar testing-and-benchmarking.jar`

##### Results:
`=== RUN   TestIntMinBasic`
`--- PASS: TestIntMinBasic (0.00s)`
`=== RUN   TestIntMinTableDriven`
`=== RUN   TestIntMinTableDriven/0,1`
`    --- PASS: TestIntMinTableDriven/0,1 (0.00s)`
`=== RUN   TestIntMinTableDriven/1,0`
`    --- PASS: TestIntMinTableDriven/1,0 (0.00s)`
`=== RUN   TestIntMinTableDriven/2,-2`
`    --- PASS: TestIntMinTableDriven/2,-2 (0.00s)`
`=== RUN   TestIntMinTableDriven/0,-1`
`    --- PASS: TestIntMinTableDriven/0,-1 (0.00s)`
`=== RUN   TestIntMinTableDriven/-1,0`
`    --- PASS: TestIntMinTableDriven/-1,0 (0.00s)`
`--- PASS: TestIntMinTableDriven (0.00s)`
`PASS`
`ok  	testing-and-benchmarking	0.023s`
