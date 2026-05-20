Reads stdin line-by-line via `BufferedReader`; uppercases each line.

___

##### Run Command:
`kotlinc line-filters.kt -include-runtime -d line-filters.jar && echo "filter" | java -jar line-filters.jar`

##### Results:
`FILTER`
