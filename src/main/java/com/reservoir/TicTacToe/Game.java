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
			throw new IllegalArgumentException("Error: Illegal number for players choose 1 or 2!"); 
		}
		
		return sc.nextLine();
	}

	public void runGame()
	{
		int row;
		int col;
		while(true)
		{
			//player 1
			while(true)
			{
				System.out.format("Player %s, place your %c for row and column  \n" , player1.getName(), player1.getMark());
	        	System.out.println("Row (0-2): ");  
				row = sc.nextInt();
				System.out.println("Col (0-2): ");
				col = sc.nextInt();
				
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
			
			if(gameShouldEnd(player1.getName()))
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
			
			if(gameShouldEnd(player2.getName()))
			{
				break;
			}
		}
	}

	boolean gameShouldEnd(String playerName) {
		
		if(board.checkForWin())
		{
			System.out.format("Congratulations! %s you won! \n" , playerName);
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