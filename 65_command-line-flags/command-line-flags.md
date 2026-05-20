Flags parsed manually (no `flag` package equivalent in Kotlin stdlib); supports `-flag=value` and `-flag value` styles.

___

##### Run Command:
`kotlinc command-line-flags.kt -include-runtime -d command-line-flags.jar && java -jar command-line-flags.jar -word=opt -numb=7 -fork -svar=flag`

##### Results:
`word: opt`
`numb: 7`
`fork: true`
`svar: flag`
`tail: []`
