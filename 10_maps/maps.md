Kotlin's LinkedHashMap preserves insertion order; Go sorts map keys alphabetically when printing, so `map[foo:1 bar:2]` here vs `map[bar:2 foo:1]` in Go.

___

##### Run Command:
`kotlinc maps.kt -include-runtime -d maps.jar && java -jar maps.jar`

##### Results:
`map: map[k1:7 k2:13]`
`v1:  7`
`len: 2`
`map: map[k1:7]`
`prs: false`
`map: map[foo:1 bar:2]`
