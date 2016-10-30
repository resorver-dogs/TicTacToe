# Development manual
===================
## Introduction
This manual contains directions on how to set up and run TicTacToe on a new machine for a new developer.

## Requirements

[Git version control system](https://help.github.com/articles/set-up-git)

[Java version 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html/)

[Gradle](https://gradle.org/)

## Source control and access
The source code is stored on the Reservoir Dogs group [repository](https://github.com/resorver-dogs/TicTacToe/) on [GitHub](https://github.com/). There you need to clone or download the repository on to your machine using the following command:
`git clone https://github.com/resorver-dogs/TicTacToe`. Now a new directory will be added to your computer containing all the project files.

## Build enviroment
All build process is done using Gradle. To compile, test and run the application, run `bin/build_and_compile` in command prompt in the root directory.
It runs each build script stored in the `bin` folder. The `compile` script compiles all the classes and unit tests.

## Dependencies
All new dependencies must be added to the build.gradle file in the root directory.
