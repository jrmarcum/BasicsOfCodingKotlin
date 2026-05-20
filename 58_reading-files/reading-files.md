Uses `RandomAccessFile` for seek operations; requires `tmp/dat.txt` containing `hello\ngo\n`.

___

##### Run Command:
`kotlinc reading-files.kt -include-runtime -d reading-files.jar && java -jar reading-files.jar`

##### Results:
`hello`
`go`
`5 bytes: hello`
`2 bytes @ 6: go`
`2 bytes @ 6: go`
`5 bytes: hello`
