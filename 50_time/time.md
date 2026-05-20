Time format matches Go's layout for fixed values; large floats print with `E` notation vs Go's `e+XX`; results vary by runtime.

___

##### Run Command:
`kotlinc time.kt -include-runtime -d time.jar && java -jar time.jar`

##### Results:
`2026-05-20 01:05:27.328881500 -0400 ET`
`2009-11-17 20:34:58.651387237 +0000 UTC`
`2009`
`November`
`17`
`20`
`34`
`58`
`651387237`
`UTC`
`Tuesday`
`true`
`false`
`false`
`144656h30m28.677494263s`
`144656.50796597064`
`8679390.477958238`
`5.207634286774943E8`
`520763428677494263`
`2026-05-20 05:05:27.328881500 +0000 UTC`
`1993-05-18 12:04:29.973892974 +0000 UTC`
