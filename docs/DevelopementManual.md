#Development manual
===================
##Introduction
This manual contains directions on how to set up and run TicTacToe on a new machine for a new developer.

##Requirements

[GitHub](https://github.com/)

[Java version 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html/)

[Gradle](https://gradle.org/)

##Source control and access
The source code is stored on the Reservoir Dogs group [repository](https://github.com/resorver-dogs/TicTacToe/) on [GitHub](https://github.com/). There you need to clone or download the repository on to your machine. 
In order to access the organization and its repositories you'll need to have a GitHub account. If you don't, [sign up here](https://github.com/join).

Once all that is finished you can run the following git command in your command prompt
`git clone https://github.com/resorver-dogs/TicTacToe` and all necesseary files will install on to your Git directory.

##Build enviroment
All build process is done using Gradle. To compile, test and run the application, run `bin/build_and_compile` in command prompt in the root directory.
It runs each build script in the `bin` folder. The `compile` script compiles all the classes and unit tests.

##Dependencies

All new dependencies must be added to the build.gradle file in the root directory.
