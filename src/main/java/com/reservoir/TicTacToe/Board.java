package com.reservoir.TicTacToe;

public class Board {

    private char[][] board;

    public Board() {
        this.board = new char[3][3];

    }
    public char[][] getBoard() {
        return this.board;
    }
    
}
