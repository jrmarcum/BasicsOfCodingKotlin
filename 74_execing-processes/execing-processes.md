#### When we run our program it spawns `cmd /c dir /a` and exits with its return code. Note: Go uses `syscall.Exec` to replace the process — JVM has no equivalent, so `ProcessBuilder` is used instead. This example runs on Windows; output varies by system.
___
##### Run Command:
`$ kotlinc execing-processes.kt -include-runtime -d execing-processes.jar && java -jar execing-processes.jar`

##### Results:
`(Windows dir /a output — varies by system)`
