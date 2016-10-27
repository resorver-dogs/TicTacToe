// Code
package com.reservoir.TicTacToe;

public class Player {
 	
  	private String name;
  	private int highScore;
  	private char mark;
  
    public Player(char mark, String name){
        this.name = name;
      	this.mark = mark;
  	}
  
    public String getName() {
     	return name;
    }
  
	public char getMark() {
     	return mark;
    }
  
}