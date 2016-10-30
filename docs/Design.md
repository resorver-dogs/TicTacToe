# Design

##Introduction
This how we designed of implementation of the game TitTacToe. 

## Initial design

We started out by drafting a class diagram where the program was broken dowin to to tasks. The class diagram contained the following classes: TicTacToe, Game, Board, Cell, Player, HumanPlayer and Computer.

TicTacToe:
Creates an instance of Game and calles the runGame() function from the Game class to start the game.

Game:
The class Game starts by getting the players' names then runGame() keeps track of who's turn it is in the game while checking gameShouldEnd() it either of the player has won. GameShouldEnd() calles checkForWin() and isDraw() from the Board class.

Board:
The Board class handles all the logig in the program. It startes by calling initBoard() wich initializes and empty TicTacToe board. AddToCell() checkes if the input in within range, if so the function calles getCellMark() and adds eihter an X or an O to the board.

Cell:
The Cell calls draws the cells in the game.

Player:
The Player class keeps track of information about the players, names, assigned mark and number of wins for each player.


![Classdiagram](https://github.com/resorver-dogs/TicTacToe/blob/documentation/images/classDiagram.png)
