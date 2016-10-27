package com.reservoir.TicTacToe;

import java.util.Scanner;

public class Game {

	private Board board;
	private Player player1;
	private Player player2;
	private Scanner sc;
	private boolean isRunning = true;

	//constructor
	public Game(){
		sc = new Scanner(System.in);
		player1 = new Player('X', inputName(1));
		player2 = new Player('O', inputName(2));
		
		board = new Board();
	}

	public void runGame()
	{
		board.printBoard();

		while(isRunning) 		
		{
			while(true)
			{
				playerPlays(player1);
				if(gameShouldEnd(player1))	break;
				playerPlays(player2);
				if(gameShouldEnd(player2))	break;
			}
		}		

	}

	
	private String inputName(int i) {
		if(i == 1) {
			System.out.println("Enter name for player X: ");
		}
		else if(i == 2) {
			System.out.println("Enter name for player O: ");
		}
		else {
			throw new IllegalArgumentException("Error: Illegal number for players choose 1 or 2!"); 
		}
		
		return sc.nextLine();
	}


	private void playerPlays(Player player) {

		while(true)
		{
			System.out.format("Player %s, place your %c for row and column  \n" , player.getName(), player.getMark());
			System.out.println("Row (0-2): ");  
			int row = validateIntInput();
			System.out.println("Col (0-2): ");
			int col = validateIntInput();
			
			try
			{	
				board.addToCell(player.getMark(), row, col);
			}
			catch(IllegalArgumentException ex)
			{
				System.out.println(ex.getMessage());
				continue;
			}
			catch(RuntimeException runTime)
			{
				System.out.println(runTime.getMessage());
				continue;
			}
			System.out.format("\n%c added to cell (" + row + "," + col + ") \n\n", player.getMark());
			break;
		}
		board.printBoard();

	}

	private int validateIntInput() {
		while (sc.hasNext()) {
			if (!sc.hasNextInt()) {
				System.out.println("Characters not allowed! Try again...");
				sc.next();
			}
			else {
				int nextInt = sc.nextInt();
				if(nextInt > 2 || nextInt < 0) {
					System.out.println("Integer out of bounds (0-2)! Try again...");
				}
				else {
					return nextInt;
				}
			}
		}
		return 0;
	} 

	private boolean gameShouldEnd(Player player) {
		if(board.checkForWin())
		{
			System.out.format("Congratulations! %s you won! \n" , player.getName());
			return quitGame();
		}
		
		if(board.isDraw())
		{
			System.out.println("Draw! Nobody wins...:(");
			return quitGame();
		}
		return false;
	}

	private boolean quitGame() {
		System.out.println("Another game (y/n)?");
		while(sc.hasNextLine()) {
			String nextLine = sc.nextLine();
			if(nextLine.equals("")) {
				continue;
			}
			if(nextLine.equals("y") || nextLine.equals("Y"))
			{
				board = new Board();
				board.printBoard();
				return true;
			}
			else
			{
				System.out.println("Thanks for playing!");
				isRunning = false;
				return true;
			}
		}
		return true;
	}
}