#### If you run `exit.kt` the JVM exits with status 3. Note that the `!` from our program never gets printed because `exitProcess` does not execute `finally` blocks. Unlike `go run`, `java -jar` does not print the exit status — check `$LASTEXITCODE` (PowerShell) or `$?` (bash) to observe it.
___
##### Run Command:
`$ kotlinc exit.kt -include-runtime -d exit.jar && java -jar exit.jar`

##### Results:
`exit status 3`
