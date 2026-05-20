Arrays are formatted with joinToString to match Go's space-separated `[v1 v2 v3]` style.

___

##### Run Command:
`kotlinc arrays.kt -include-runtime -d arrays.jar && java -jar arrays.jar`

##### Results:
`emp: [0 0 0 0 0]`
`set: [0 0 0 0 100]`
`get: 100`
`len: 5`
`dcl: [1 2 3 4 5]`
`2d:  [[0 1 2] [1 2 3]]`
