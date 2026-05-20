Kotlin has no pointer concept, so the `&{Ann 40}` and `&{Jon 42}` pointer-prefix lines from Go appear without the `&` here.

___

##### Run Command:
`kotlinc structs.kt -include-runtime -d structs.jar && java -jar structs.jar`

##### Results:
`{Bob 20}`
`{Alice 30}`
`{Fred 0}`
`{Ann 40}`
`{Jon 42}`
`Sean`
`50`
`51`
