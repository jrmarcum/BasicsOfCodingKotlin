Java cannot set env vars for the current process; run with `FOO=1` pre-set in the shell to see the value. Key list varies by system.

___

##### Run Command:
`kotlinc environment-variables.kt -include-runtime -d environment-variables.jar && java -jar environment-variables.jar`

##### Results:
`FOO: `
`BAR: `
``
`[list of all environment variable keys]`
