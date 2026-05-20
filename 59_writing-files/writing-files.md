Uses `FileOutputStream` and `BufferedWriter`; requires a `tmp/` directory at runtime.

___

##### Run Command:
`kotlinc writing-files.kt -include-runtime -d writing-files.jar && java -jar writing-files.jar`

##### Results:
`wrote 5 bytes`
`wrote 7 bytes`
`wrote 9 bytes`
