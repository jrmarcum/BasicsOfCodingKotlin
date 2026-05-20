#### The spawned programs return output that is the same as if we had run them directly from the command-line. Note: adapted for Windows using `cmd /c date /t`, `findstr`, and `cmd /c dir /b` in place of Unix `date`, `grep`, and `bash`. Output varies by system.
___
##### Run Command:
`$ kotlinc spawning-processes.kt -include-runtime -d spawning-processes.jar && java -jar spawning-processes.jar`

##### Results:
`> date`
`Wed 05/20/2026 `
`command exit rc = 1`
`> grep hello`
`hello grep`
`> ls -a -l -h`
`spawning-processes.kt`
`spawning-processes.jar`
