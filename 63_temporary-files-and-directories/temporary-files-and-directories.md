Uses `java.nio.file.Files.createTempFile` and `createTempDirectory`; temp paths vary per run and OS.

___

##### Run Command:
`kotlinc temporary-files-and-directories.kt -include-runtime -d temporary-files-and-directories.jar && java -jar temporary-files-and-directories.jar`

##### Results:
`Temp file name: C:\Users\...\TMP\sample4573785159543529413`
`Temp dir name: C:\Users\...\TMP\sampledir11636558730790929476`
