Uses `java.nio.file.Paths`; on Windows the path separator is `\` instead of `/`, and `/dir/file` is not absolute without a drive letter.

___

##### Run Command:
`kotlinc file-paths.kt -include-runtime -d file-paths.jar && java -jar file-paths.jar`

##### Results:
`p: dir1\dir2\filename`
`dir1\filename`
`dir1\filename`
`Dir(p): dir1\dir2`
`Base(p): filename`
`false`
`false`
`.json`
`config`
`t\file`
`..\c\t\file`
