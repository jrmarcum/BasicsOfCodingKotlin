`%T` equivalent prints `point` (Kotlin class name) vs Go's `main.point`; pointer uses `System.identityHashCode`, not actual address.

___

##### Run Command:
`kotlinc string-formatting.kt -include-runtime -d string-formatting.jar && java -jar string-formatting.jar`

##### Results:
`{1 2}`
`{x:1 y:2}`
`main.point{x:1, y:2}`
`point`
`true`
`123`
`1110`
`!`
`1c8`
`78.900000`
`1.234000e+08`
`1.234000E+08`
`"string"`
`"\"string\""`
`6865782074686973`
`0x...`
`|    12|   345|`
`|  1.20|  3.45|`
`|1.20  |3.45  |`
`|   foo|     b|`
`|foo   |b     |`
`a string`
`an error`
