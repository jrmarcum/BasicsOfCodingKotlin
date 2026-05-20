Kotlin uses MutableList instead of slices; lists are formatted with joinToString to match Go's space-separated `[v1 v2 v3]` style.

___

##### Run Command:
`kotlinc slices.kt -include-runtime -d slices.jar && java -jar slices.jar`

##### Results:
`emp: [  ]`
`set: [a b c]`
`get: c`
`len: 3`
`apd: [a b c d e f]`
`cpy: [a b c d e f]`
`sl1: [c d e]`
`sl2: [a b c d e]`
`sl3: [c d e f]`
`dcl: [g h i]`
`2d:  [[0] [1 2] [2 3 4]]`
