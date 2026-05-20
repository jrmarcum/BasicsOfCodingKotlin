Uses `java.util.Base64`; URL encoder uses `withoutPadding()` to match Go's output.

___

##### Run Command:
`kotlinc base64-encoding.kt -include-runtime -d base64-encoding.jar && java -jar base64-encoding.jar`

##### Results:
`YWJjMTIzIT8kKiYoKSctPUB+`
`abc123!?$*&()'-=@~`
``
`YWJjMTIzIT8kKiYoKSctPUB-`
`abc123!?$*&()'-=@~`
