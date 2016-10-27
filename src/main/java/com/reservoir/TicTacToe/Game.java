package com.reservoir.TicTacToe;

import java.util.Scanner;

public class Game {

	private Board board;
	private Player player1;
	private Player player2;
	private Scanner sc;

	//constructor
	public Game(){
		System.out.println("Enter name for player X: ");
		sc = new Scanner(System.in);
		String name = sc.nextLine();
		player1 = new Player('X', name);
		System.out.println("Enter name for player O: ");
		name = sc.nextLine();
		player2 = new Player('O', name);
		board = new Board();
	}

	public void runGame()
	{
		while(true)
		{
			int row = 0;
			int col = 0;
			
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
			
			if(board.checkForWin())
			{
				System.out.format("Congratulations! %s you won! \n" , player1.getName());
				System.out.println("Another game (y/n)?");
				if(sc.nextLine() == "y" || sc.nextLine() == "Y")
				{
					board = new Board();
				}
				else
				{
					System.out.println("Thanks for playing!");
					break;
				}
			}
			
			//player 2 
			while(true)
			{
				System.out.format("Player %s, place your %c for row and column \n" , player2.getName(), player2.getMark());
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
			
			if(board.checkForWin())
			{
				System.out.format("Congratulations! %s you won! \n" , player2.getName());
				System.out.println("Another game (y/n)?");
				if(sc.nextLine() == "y" || sc.nextLine() == "Y")
				{
					board = new Board();
				}
				else
				{
					System.out.println("Thanks for playing!");
					break;
				}
			}
			
			if(board.boardIsFull())
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
					break;
				}
				break;
			}
		}
	}
}
