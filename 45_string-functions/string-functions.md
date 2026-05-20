Kotlin string methods replace Go's `strings` package functions; `Char.code` gives the byte value.

___

##### Run Command:
`kotlinc string-functions.kt -include-runtime -d string-functions.jar && java -jar string-functions.jar`

##### Results:
`Contains:   true`
`Count:      2`
`HasPrefix:  true`
`HasSuffix:  true`
`Index:      1`
`Join:       a-b`
`Repeat:     aaaaa`
`Replace:    f00`
`Replace:    f0o`
`Split:      [a b c d e]`
`ToLower:    test`
`ToUpper:    TEST`
`Len:  5`
`Char: 101`
