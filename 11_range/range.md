Kotlin's mapOf preserves insertion order, so map iteration is deterministic here; Go map iteration is non-deterministic.

___

##### Run Command:
`kotlinc range.kt -include-runtime -d range.jar && java -jar range.jar`

##### Results:
`sum: 9`
`index: 1`
`a -> apple`
`b -> banana`
`key: a`
`key: b`
`0 103`
`1 111`
