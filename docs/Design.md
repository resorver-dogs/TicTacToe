# Design

##Introduction
This how we designed of implementation of the game TitTacToe. 

## Initial design

Í upphafi gerðum við uppdrátt af klasariti þar sem við brutum verkefnið niður í verkþætti. Þetta klasarit innihélt klasana Game, Board, Cell, Player, Human og Computer.

TicTacToe:
Gerir tilvik af Game og kallar svo á runGame fallið í Game klasanum til að byrja leikinn.

Game:
Game klasinn byrjar á að biðja um nafn leikmanna. runGame fallið sé svo um að láta leikmenn skiptast á að gera í leiknum og athugar stöðugt í gameShouldEnd fallinu hvort annarhvor
leikmannana hefur sigrað leikinn. gameShouldEnd fallið kallar á checkForWin og isDraw föllin úr board klasanum. 

Board:
Board klasinn sér um alla lógík í forritinu. Board klasinn byrjar að kalla á initBoard fallið sem upphafstillir tóma millu. addToCell fallið athugar hvort reiturinn sem er umbeðið sé 
innan millunar, ef svo er þá bætir hann því tákni sem við á í þann reit. getCellMark 

Cell:

Player:


## Það sem á að koma fram

	*  Document describing the initial design.


![Classdiagram](https://github.com/resorver-dogs/TicTacToe/blob/master/images/classDiagram.png)
