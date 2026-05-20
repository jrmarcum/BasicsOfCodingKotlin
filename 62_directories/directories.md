Uses `File.walk()` and `File.mkdirs()`; path separators normalized to `/` in walk output to match Go.

___

##### Run Command:
`kotlinc directories.kt -include-runtime -d directories.jar && java -jar directories.jar`

##### Results:
`Listing subdir/parent`
`  child true`
`  file2 false`
`  file3 false`
`Listing subdir/parent/child`
`  file4 false`
`Visiting subdir`
`  subdir true`
`  subdir/file1 false`
`  subdir/parent true`
`  subdir/parent/child true`
`  subdir/parent/child/file4 false`
`  subdir/parent/file2 false`
`  subdir/parent/file3 false`
