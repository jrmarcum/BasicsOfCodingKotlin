Kotlin's `Random(seed)` is deterministic per seed; values differ from Go's `rand.NewSource(42)` due to different RNG algorithms. Results vary per run.

___

##### Run Command:
`kotlinc random-numbers.kt -include-runtime -d random-numbers.jar && java -jar random-numbers.jar`

##### Results:
`88,74`
`0.2661451328416833`
`7.386915736449264,7.861374302257673`
`72,20`
`33,40`
`33,40`
