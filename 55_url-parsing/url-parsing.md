Uses `java.net.URI` for URL parsing; `URI.port` returns an `Int` directly.

___

##### Run Command:
`kotlinc url-parsing.kt -include-runtime -d url-parsing.jar && java -jar url-parsing.jar`

##### Results:
`postgres`
`user:pass`
`user`
`pass`
`host.com:5432`
`host.com`
`5432`
`/path`
`f`
`k=v`
`map[k:[v]]`
`v`
