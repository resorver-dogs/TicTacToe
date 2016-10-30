# Administrator manual

## Introduction
This manual takes you through the necessary steps in order to install and run 
the game TicTacToe on a fresh machine.

##Requirements

Git account
[Java version 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

##Pull and deploy
 - Go to the group [repository](https://github.com/resorver-dogs/TicTacToe/) on [GitHub](https://github.com/) and clone the repository on to your machine: `git clone https://github.com/resorver-dogs/TicTacToe.git`.
 - Make sure you have set up the Java 8 Developement kit. Open command line and make sure the Java interpreter (java) is executable.
 - Open command line and navigate to the projects' root directory. Run `bin/build_and_play` to build and play the game. The .jar file should be found in the root directory and can independently be run using `bin/play`.

In total:
 ```
 git clone https://github.com/resorver-dogs/TicTacToe.git
 cd TicTacToe
 bin/build_and_play (compile and play the game)
    *or*
 bin/play (only if game is compiled)
 ```
 
##Maintenance
To access the latest version of the program go to the TicTacToe directory and performe the following `Git` commands:
```
git pull origin master
```