Kotlin has no built-in JSON library; this lesson implements a minimal JSON encoder and recursive-descent parser inline.

___

##### Run Command:
`kotlinc json.kt -include-runtime -d json.jar && java -jar json.jar`

##### Results:
`true`
`1`
`2.34`
`"vector"`
`["apple","peach","pear"]`
`{"apple":5,"lettuce":7}`
`{"Page":1,"Fruits":["apple","peach","pear"]}`
`{"page":1,"fruits":["apple","peach","pear"]}`
`map[num:6.13 strs:[a b]]`
`6.13`
`a`
`{1 [apple peach]}`
`apple`
`{"apple":5,"lettuce":7}`
