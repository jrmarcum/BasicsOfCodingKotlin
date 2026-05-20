Subcommands and their flags parsed manually to match Go's `flag.NewFlagSet` pattern.

___

##### Run Command:
`kotlinc command-line-subcommands.kt -include-runtime -d command-line-subcommands.jar && java -jar command-line-subcommands.jar foo -enable -name=joe a1 a2`

##### Results:
`subcommand 'foo'`
`  enable: true`
`  name: joe`
`  tail: [a1 a2]`

##### Run Command:
`java -jar command-line-subcommands.jar bar -level=8 a1 a2`

##### Results:
`subcommand 'bar'`
`  level: 8`
`  tail: [a1 a2]`
