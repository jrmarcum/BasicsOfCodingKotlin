Kotlin uses interface delegation (`by` keyword) to approximate Go's struct embedding; the embedded type is accessed via an explicit field rather than a promoted field.

___

##### Run Command:
`kotlinc struct-embedding.kt -include-runtime -d struct-embedding.jar && java -jar struct-embedding.jar`

##### Results:
`co={num: 1, str: some name}`
`also num: 1`
`describe: base with num=1`
`describer: base with num=1`
