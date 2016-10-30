# Design

## Introduction
This document describes the initial design of the game TitTacToe. 

## Initial design

In the beginning, a class diagram was drafted where the game was broken down into tasks. The class diagram contains the following classes: TicTacToe, Game, Board, Cell and Player. Each class is described here below.

##### TicTacToe:
Creates an instance of the Game class and calls the runGame() function from the Game class to start the game.

##### Game:
The class Game starts by creating two instances of the Player class and one of the Board class. The method runGame() prints the board each round and keeps track of whose player's turn it is each time. Each player adds his own mark to a cell in the board, either X or O,  using the method playerPlayes() and the method gameShouldEnd() checks if either of the player has won or if there is a draw. After each round, the players are asked if they want to play another round or quit.

##### Board:
The Board class handles all the logic in the game. It startes by calling initBoard() wich initializes an empty TicTacToe board, a two-dimensional Cell array. AddToCell() checks if the input in within range and adds the mark to the chosen cell. The functions checkForRowsWin(), checkForColsWin() and checkForDiagWin() "reads" the marks in the board cells and find out whether the game has been won.

##### Cell:
The Cell represents the cell in the TicTacToe board and stores and returns the mark added to it.

##### Player:
The Player class keeps track of information about the players, their names, assigned mark and number of wins for each player.


![Classdiagram](https://github.com/resorver-dogs/TicTacToe/blob/documentation/images/classDiagram.png)
