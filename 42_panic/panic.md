Running this program throws an uncaught RuntimeException and prints a Java stack trace instead of Go's goroutine trace.

___

##### Run Command:
`kotlinc panic.kt -include-runtime -d panic.jar && java -jar panic.jar`

##### Results:
`Exception in thread "main" java.lang.RuntimeException: a problem`
`	at PanicKt.main(panic.kt:2)`
`	at PanicKt.main(panic.kt)`
