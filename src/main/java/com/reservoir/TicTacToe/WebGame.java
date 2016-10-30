package com.reservoir.TicTacToe;

public class Game 
{
	private Board board;
	private Player player1;
	private Player player2;
	private boolean gameFinished = false;

	//constructor
	public Game()
	{		
		player1 = new Player('X', "Player 1");
		player2 = new Player('O', "Player 2");
		
		board = new Board();
	}

	public boolean isGameFinished() {
		return gameFinished;
	}

	private void playerPlays(Player player, int row, int col) 
	{
		board.addToCell(player.getMark(), row, col);
		checkIfGameShouldEnd();
	}

	private void checkIfGameShouldEnd() 
	{
		if(board.checkForWin() || board.isDraw())
		{
			gameFinished = true;
		}
	}
}