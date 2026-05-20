Kotlin has no raw pointers; an IntArray simulates pass-by-reference. The pointer line shows the object's identity hash code in hex rather than a memory address, and changes each run.

___

##### Run Command:
`kotlinc pointers.kt -include-runtime -d pointers.jar && java -jar pointers.jar`

##### Results:
`initial: 1`
`zeroval: 1`
`zeroptr: 0`
`pointer: 7852e922`
