Kotlin uses a custom SimpleLogger with `yyyy/MM/dd HH:mm:ss` format matching Go's default; timestamp and JSON time values vary with run time.

___

##### Run Command:
`kotlinc logging.kt -include-runtime -d logging.jar && java -jar logging.jar`

##### Results:
`2023/08/22 10:45:16 standard logger`
`2023/08/22 10:45:16 with micro`
`2023/08/22 10:45:16 with file/line`
`my:2023/08/22 10:45:16 from mylog`
`ohmy:2023/08/22 10:45:16 from mylog`
`from buflog:buf:2023/08/22 10:45:16 hello`
`{"time":"2023-08-22T10:45:16.904166391","level":"INFO","msg":"hi there"}`
`{"time":"2023-08-22T10:45:16.904178985","level":"INFO","msg":"hello again","key":"val","age":25}`
