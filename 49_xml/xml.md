XML is generated manually using `buildString`; parsing uses `javax.xml.parsers.DocumentBuilderFactory` from the JDK.

___

##### Run Command:
`kotlinc xml.kt -include-runtime -d xml.jar && java -jar xml.jar`

##### Results:
` <plant id="27">`
`   <name>Coffee</name>`
`   <origin>Ethiopia</origin>`
`   <origin>Brazil</origin>`
` </plant>`
`<?xml version="1.0" encoding="UTF-8"?>`
` <plant id="27">`
`   <name>Coffee</name>`
`   <origin>Ethiopia</origin>`
`   <origin>Brazil</origin>`
` </plant>`
`Plant id=27, name=Coffee, origin=[Ethiopia Brazil]`
` <nesting>`
`   <parent>`
`     <child>`
`       <plant id="27">`
`         <name>Coffee</name>`
`         <origin>Ethiopia</origin>`
`         <origin>Brazil</origin>`
`       </plant>`
`       <plant id="81">`
`         <name>Tomato</name>`
`         <origin>Mexico</origin>`
`         <origin>California</origin>`
`       </plant>`
`     </child>`
`   </parent>`
` </nesting>`
