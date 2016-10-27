package com.reservoir.TicTacToe;

import java.util.Scanner;

public class Game {

	private Board board;
	private Player player1;
	private Player player2;
	private Scanner sc;

	//constructor
	public Game(){
		sc = new Scanner(System.in);
		player1 = new Player('X', inputName(1));
		player2 = new Player('O', inputName(2));
		
		board = new Board();
	}

	private String inputName(int i) {
		if(i == 1) {
			System.out.println("Enter name for player X: ");
		}
		else if(i == 2) {
			System.out.println("Enter name for player O: ");
		}
		else {
			throw new IllegalArgumentException("Error: Illegal Mark!"); 
		}
		
		return sc.nextLine();
	}

	public void runGame()
	{
		board.printBoard();
		int row;
		int col;
		while(true)
		{
			//player 1
			while(true)
			{
				System.out.format("Player %s, place your %c for row and column  \n" , player1.getName(), player1.getMark());
	        	System.out.println("Row (0-2): ");  
				while (sc.hasNext()) {
					if (!sc.hasNextInt()) {
    					System.out.println("Characters not allowed! Try again...");
						sc.next();
    				}
    				else {
    					row = sc.nextInt();
    					break;
    				}
    			}
				System.out.println("Col (0-2): ");
				while (sc.hasNext()) {
					if (!sc.hasNextInt()) {
    					System.out.println("Characters not allowed! Try again...");
						sc.next();
    				}
    				else {
    					col = sc.nextInt();
    					break;
    				}
    			}
				
				try
				{	
					board.addToCell(player1.getMark(), row, col);
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
				break;
			}
			board.printBoard();
			
			if(gameShouldEnd(1))
			{
				break;
			}

			//player 2 
			while(true)
			{				
				System.out.format("Player %s, place your %c for row and column \n" , player2.getName(), player2.getMark());
	        	System.out.println("Row (0-2): ");  
				row = sc.nextInt();
				System.out.println("Col (0-2): ");
				col = sc.nextInt();
				
				try
				{	
					board.addToCell(player2.getMark(), row, col);
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
				break;
			}

			board.printBoard();
			
			if(gameShouldEnd(2))
			{
				break;
			}
		}
	}

	boolean gameShouldEnd(int player) {
		String name = "";
		if(player == 1) 
		{
			name = player1.getName();
		}
		else if (player == 2) 
		{
			name = player2.getName();
		}
		
		if(board.checkForWin())
		{
			System.out.format("Congratulations! %s you won! \n" , name);
			System.out.println("Another game (y/n)?");
			if(sc.nextLine() == "y" || sc.nextLine() == "Y")
			{
				board = new Board();
				return false;
			}
			else
			{
				System.out.println("Thanks for playing!");
				return true;
			}
		}
		
		if(board.isDraw())
		{
			System.out.println("Draw!");
			System.out.println("Another game (y/n)?");
			if(sc.nextLine() == "y" || sc.nextLine() == "Y")
			{
				board = new Board();
			}
			else
			{
				System.out.println("Thanks for playing!");
				return true;
			}
		}
		return false;
	}
}