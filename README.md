# Basics of Coding Kotlin
## Preface
What this text is and what it is not: This text is intended to introduce the reader to the basics of the Kotlin programming language in the sense that they will be able to write minimal types of programs and run the code. It is not intended to go into advanced topics like concurrency and use of pointers, advanced data structures, object oriented programming, testing and debugging techniques and other software engineering principals.

The programs are intended to be run in the terminal as that is common to most operating systems. Linux and Mac come preinstalled with a terminal. Windows may or may not have it pre-installed. "Windows Terminal" can be installed from the Microsoft store. Just do a search for it and install it.
## Installation and Setup of Kotlin
To setup Kotlin for use, navigate to the [Kotlin](https://kotlinlang.org/docs/getting-started.html) website and download the appropriate installer for your operating system. Install and follow the directions on how to perform further settings for use. A package manager makes the install process much easier (brew for Mac, sdkman for Linux/Mac, chocolatey for Windows). If the language has been installed properly you will be able to type the following command in the terminal command line and receive the response shown:
```
$ kotlinc -version
info: kotlinc-jvm 2.x.x (JRE x.x.x)
(Note: the version shown here varies with your installed version)
```
## How to Run Examples

Each lesson folder contains a `.kt` source file and a `.md` file showing the run command and expected output. To run any example, navigate to its folder in your terminal first, then use the command shown in the `.md` file:

```
$ cd 01_hello-world
$ kotlinc hello-world.kt -include-runtime -d hello-world.jar && java -jar hello-world.jar
```

## Comments
Comments are used to document what your code does so that others can understand it when reviewing your code. Comments also document items that are non-performant in order to debug the code items at a later date.
## Keywords
|           |          |          |            |          |
|:---------:|:--------:|:--------:|:----------:|:--------:|
| as        | break    | class    | continue   | do       |
| else      | false    | for      | fun        | if       |
| in        | interface| is       | null       | object   |
| package   | return   | super    | this       | throw    |
| true      | try      | typealias| typeof     | val      |
| var       | when     | while    |            |          |

## Attribution

This project is adapted in part from **[Go by Example](https://github.com/mmcgrana/gobyexample)**
by [Mark McGranaghan](https://github.com/mmcgrana), licensed under the
[Creative Commons Attribution 3.0 Unported License](http://creativecommons.org/licenses/by/3.0/).

This project exists as a platform for multi-language comparative study of
syntax, language simplicity, lines of code required, and compile/run
performance. Attribution for Go by Example derived content is provided
centrally in this README and the NOTICE file — no per-file attribution
footer is added to individual lesson files.

## License

This repository contains two tiers of content:

| Content | License |
| --- | --- |
| Lesson files and code examples adapted from *Go by Example* | [CC BY 3.0](http://creativecommons.org/licenses/by/3.0/) — see NOTICE |
| Original contributions by Jon Marcum (project structure, README, comparative study additions) | [CC0 1.0 Universal](https://creativecommons.org/publicdomain/zero/1.0/) — see LICENSE |

The root `LICENSE` file (CC0) applies to Jon Marcum's original contributions.
The `NOTICE` file clarifies that CC BY 3.0 governs all content adapted from *Go by Example*.
