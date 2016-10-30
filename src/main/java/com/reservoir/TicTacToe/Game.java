package com.reservoir.TicTacToe;

import java.util.Scanner;

public class Game 
{
	private Board board;
	private Player player1;
	private Player player2;
	private Scanner sc;
	private boolean isRunning = true;

	public Game()
	//constructor for the Game class
	{
		sc = new Scanner(System.in);		
		clearScreenAndPrintHeader();
		player1 = new Player('X', inputName(1));
		player2 = new Player('O', inputName(2));		
		board = new Board();
	}

	public void runGame()
	// Runs the TicTacToe game and keeps track of which player's turn it is
	{
		clearScreenAndPrintHeader();
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
		printResults(player1, player2);
	}

	private void clearScreenAndPrintHeader() 
	// Used to refresh window each time and print out header lines
	{
		System.out.print("\033[H\033[2J");
		System.out.flush();		
		System.out.println("=================================");
		System.out.println();
		System.out.println("=========== TicTacToe ===========");
		System.out.println();
		System.out.println("=================================");
		System.out.println();
	}

	
	private String inputName(int i) 
	// Takes in the players' names from console 
		{
		if(i == 1) 
		{
			System.out.println("Enter name for player X: ");
		}
		else if(i == 2) 
		{
			System.out.println("Enter name for player O: ");
		}
		else 
		{
			throw new IllegalArgumentException("Error: Illegal number for players choose 1 or 2!"); 
		}
		
		return sc.nextLine();
	}


	private void playerPlays(Player player) 
	// Player's turn, the player tries to add his mark to a specific cell in the board from console input 
	{

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
				System.out.println("\n" + ex.getMessage() + "\n");
				continue;
			}
			catch(RuntimeException runTime)
			{
				System.out.println("\n" + runTime.getMessage() + "\n");
				continue;
			}

			clearScreenAndPrintHeader();
			System.out.format("\n%c added to cell (" + row + "," + col + ") \n\n", player.getMark());
			break;
		}
		board.printBoard();

	}

	private int validateIntInput() 
	// Checks whether the console input is valid for rows and columns (0, 1 or 2)
	{
		while (sc.hasNext()) 
		{
			if (!sc.hasNextInt()) 
			{
				System.out.println("Characters not allowed! Try again...");
				sc.next();
			}
			else 
			{
				int nextInt = sc.nextInt();
				if(nextInt > 2 || nextInt < 0) 
				{
					System.out.println("Integer out of bounds (0-2)! Try again...");
				}
				else return nextInt;
			}
		}
		return 0;
	} 

	private boolean gameShouldEnd(Player player) 
	// Checks if the round is finished (the player has won or there is a draw)
	{
		if(board.checkForWin())
		{
			System.out.format("Congratulations! %s you won! \n" , player.getName());
			player.hasWon();
			return quitGame();
		}
		
		if(board.isDraw())
		{
			System.out.println("Draw! Nobody wins...:(");
			return quitGame();
		}
		return false;
	}

	private void printResults(Player player1, Player player2) 
	// Prints the total results (nr. of wins) when the quitting
	{
		System.out.println("=================================");
		System.out.println();
		System.out.println("Final Results:");
		System.out.println();
		System.out.println(player1.getName() + " (" + player1.getMark() + "): " + player1.getWins() + " wins");
		System.out.println(player2.getName() + " (" + player2.getMark() + "): " + player2.getWins() + " wins");
	}

	private boolean quitGame() 
	// Used to start a new TicTacToe round or quit the game (when isRunning = false)
	{
		System.out.println("Another game (y/n)?");
		while(sc.hasNextLine()) 
		{
			String nextLine = sc.nextLine();
			if(nextLine.equals("")) continue;			
			if(nextLine.equals("y") || nextLine.equals("Y"))
			{
				board = new Board();
				clearScreenAndPrintHeader();
				board.printBoard();
				return true;
			}
			else if(nextLine.equals("n") || nextLine.equals("N"))
			{
				System.out.println("\nThanks for playing!");
				isRunning = false;
				return true;
			}
			else {
				System.out.println("Please choose (y/n):");
				continue;
			}
		}
		return true;
	}
}