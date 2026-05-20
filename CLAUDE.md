# BasicsOfCoding[LANGUAGE] — Session Context

## What This Project Is

A multi-language comparative study of programming syntax, simplicity, lines
of code, and performance. Each language implements the same 78 example
programs so they can be compared side-by-side.

The source of truth for program logic and expected output is **Basics of
Coding Go** by Jon Marcum (https://github.com/jrmarcum/BasicsOfCodingGo),
which lives as a git submodule at `upstream/basicsofcodinggo`. For every
lesson, read the upstream `.go` source and `.md` to understand what the
program does and what output it produces, then translate to idiomatic
[LANGUAGE].

The structural reference is **BasicsOfCodingC**
(https://github.com/jrmarcum/BasicsOfCodingC). Match its repo layout,
CLAUDE.md shape, NOTICE/LICENSE structure, and lesson `.md` format exactly.

## Project Structure

```
BasicsOfCoding[LANGUAGE]/
├── CLAUDE.md
├── LICENSE            — CC0 (Jon Marcum original contributions)
├── NOTICE             — CC BY 3.0 attribution for derived lesson content
├── README.md
├── upstream/
│   └── basicsofcodinggo/  — git submodule
└── ##_topic-name/
    ├── topic-name.[ext]
    └── topic-name.md
```

All 78 lessons: `01_hello-world` through `78_sha256-hashes`.
Numbers match BasicsOfCodingGo exactly — do not renumber.

## Lesson .md Format (exact, no deviations)

```
[Optional one-line description]

___

##### Run Command:
`[run command]`

##### Results:
`[output line 1]`
`[output line 2]`
```

No per-file attribution footers. Time-dependent or nondeterministic
lessons note this in the description line.

## Licensing Rule

Do NOT add per-file attribution footers. Attribution is handled centrally
in README and NOTICE. This is intentional and differs from some other repos.

## Output Matching

Match upstream Go output line-for-line. Where the language produces
structurally different output (e.g., map ordering, array formatting),
document the difference in the lesson `.md` description line.

## Special Lessons

- **58–60** (reading/writing files, line-filters): require a `tmp/`
  directory at runtime (gitignored, create manually). Lesson 58 also needs
  `tmp/dat.txt` containing `hello\n[lang]\n`.
- **50–52, 32, 37**: time-dependent output — note in `.md` that results vary.
- **27–37** (concurrency): nondeterministic per-thread ordering — note in `.md`.
- **64–66** (command-line args/flags/subcommands): must be compiled to a
  binary before running; args passed after `--` separator or equivalent.
- **68** (testing-and-benchmarking): use the language's native test framework.

---

## Language-Specific Reference

### KOTLIN

**Toolchain:**

```
$ kotlinc filename.kt -include-runtime -d filename.jar && java -jar filename.jar
```

The jar is always named after the source file (e.g. `url-parsing.kt` → `url-parsing.jar`), never `out.jar`.

**Key translations:**
| Go | Kotlin |
|---|---|
| `fmt.Println` | `println()` |
| `fmt.Printf` | `"${...}"` string templates |
| Slices | `MutableList<T>` / `mutableListOf()` |
| Maps | `LinkedHashMap<K,V>()` |
| Multiple return | `Pair<A,B>` / data class |
| Closures | `{ x -> x * 2 }` lambda |
| `interface` | `interface` |
| `defer` | `use { }` / `try-finally` |
| goroutines | `launch { }` (kotlinx.coroutines) |
| channels | `Channel<T>` (kotlinx.coroutines) |
| `select` | `select { }` expression |
| `sync.WaitGroup` | `Job.join()` / `coroutineScope { }` |
| `sync.Mutex` | `Mutex()` (kotlinx.coroutines) |
| `sync/atomic` | `AtomicLong` |
| `error` | `Exception` / sealed `Result<T>` |
| `regexp` | `Regex("pattern")` / `findAll` |
| SHA1/SHA256 | `MessageDigest.getInstance("SHA-256")` |
| Base64 | `java.util.Base64` |

**Notes:** `LinkedHashMap` for insertion-order map output. kotlinx.coroutines
required for lessons 27–37. Use `str.codePoints()` for Unicode in lesson 22.

**.gitignore:** `*.class`, `*.jar`, `build/`, `.gradle/`, `out/`, `tmp/`

---

## Project Memory

> All session context, decisions, and progress notes live here so they travel
> with the repo and are available to any machine or collaborator.
> Do NOT use the local `~/.claude` memory system for this project.

### Progress

All 78 lessons implemented and compiled. Toolchain: Kotlin 2.3.21 / JRE 25.0.2 on Windows 11.

| Range | Status |
|---|---|
| 01–10 | ✓ complete |
| 11–20 | ✓ complete |
| 21–30 | ✓ complete |
| 31–40 | ✓ complete |
| 41–50 | ✓ complete |
| 51–60 | ✓ complete |
| 61–70 | ✓ complete |
| 71–78 | ✓ complete |

### Decisions & Notes

**Array / list formatting** — Use `.joinToString(" ", "[", "]")` to match Go's
`[v1 v2 v3]` format.

**Map formatting** — Use a `fun <K,V> Map<K,V>.fmt()` extension that produces
`map[k1:v1 k2:v2]` output. Keys must be sorted for deterministic order.

**Concurrency (lessons 27–37)** — Implemented with `Thread` +
`LinkedBlockingQueue`, NOT kotlinx.coroutines, to avoid external dependencies
with the standard `-include-runtime` build.

**No kotlin-reflect** — Avoid `kotlin-reflect.jar` (not included by
`-include-runtime`). Use Java reflection (`getDeclaredField`) instead.

**Lesson 46 type name** — `p::class.qualifiedName` shows `"point"` (Kotlin);
Go shows `"main.point"`. Documented in `.md`.

**Lesson 47 regex ranges** — Kotlin `MatchResult.range` is inclusive (IntRange);
convert to Go's exclusive end with `range.last + 1`.

**Lesson 48 JSON** — No stdlib JSON; uses inline `toJson()` encoder (sorts map
keys alphabetically) and recursive-descent `JsonParser`.

**Lesson 49 XML** — Manual XML generation with `buildString`;
`DocumentBuilderFactory` for parsing (no JAXB needed).

**Lesson 50–52 time formatting** — `goString()` extension on `ZonedDateTime`
trims trailing zeros with `"%09d".format(ns).trimEnd('0')`.

**Lesson 57 base64** — URL-safe variant requires `Base64.getUrlEncoder().withoutPadding()`
to match Go's output (`YWJjMTIzIT8kKiYoKSctPUB-`).

**Lesson 58 dat.txt** — Needs `tmp/dat.txt` containing `hello\nkotlin\n`
(not `go\n`) to match the Kotlin-specific expected output.

**Lesson 61 Windows paths** — `Paths.get("dir1","dir2","filename")` outputs
`dir1\dir2\filename` (backslash). `/dir/file` is not absolute on Windows
(no drive letter). Both differences documented in `.md`.

**Lesson 67 env vars** — Java cannot set environment variables at runtime
(`System.setenv` doesn't exist). Lesson shows `System.getenv()` read-only.
Pre-set `FOO` and `BAR` in the shell before running.

**Lesson 73 templates** — Inline mini template engine handling `{{.}}`,
`{{.Field}}`, `{{if . -}}...{{else -}}...{{end}}`, and `{{range .}}...{{end}}`.
Uses `-` trim modifiers.

**Lessons 74–75 Windows** — `syscall.Exec` / Unix commands have no direct
Windows equivalent. Uses `cmd /c dir /a` (74) and `cmd /c date /t`, `findstr`,
and `cmd /c dir /b` (75). Output documented as "varies by system".

**Lesson 76 signals** — `Runtime.addShutdownHook` handles SIGINT/SIGTERM.
Shutdown hook prints output; main thread blocks on `Thread.sleep(Long.MAX_VALUE)`.

**Lesson 77 exit** — `exitProcess(3)` skips `finally` blocks (same as Go's
`os.Exit`). Unlike `go run`, `java -jar` does not print `exit status 3`.

**SHA hex encoding** — `bs.joinToString("") { "%02x".format(it.toInt() and 0xFF) }`
handles unsigned byte conversion correctly.
