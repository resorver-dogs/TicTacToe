package com.reservoir.TicTacToe;

public class Game {

	private Board board;
	
	private char currPlayer;
	
	//constructor
	public Game(){
		board = new Board();
		currPlayer = 'X';
	}
	public char getCurrPlayer(){
		return currPlayer;
	}

	public static void main(String[] args){

	}
}
