Kotlin uses `args: Array<String>`; `command-line-arguments.jar` approximates Go's program name (`os.Args[0]`). Must be compiled first.

___

##### Run Command:
`kotlinc command-line-arguments.kt -include-runtime -d command-line-arguments.jar && java -jar command-line-arguments.jar a b c d`

##### Results:
`[command-line-arguments.jar a b c d]`
`[a b c d]`
`c`
