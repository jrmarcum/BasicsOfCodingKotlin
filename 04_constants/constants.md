Kotlin's Double.toString() uses uppercase E notation (6.0E11) where Go prints 6e+11.

___

##### Run Command:
`kotlinc constants.kt -include-runtime -d constants.jar && java -jar constants.jar`

##### Results:
`constant`
`6.0E11`
`600000000000`
`-0.28470407323754404`
