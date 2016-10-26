package com.reservoir.TicTacToe;

public class Board {

    private char[][] board;

    public Board() {
        board = new char[3][3];
        initBoard();
    }

    private void initBoard() {
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col ++) {
                board[row][col] = '-';
            }
        }
    }

    public void addToCell(char mark, int row, int col) {
        if(row > 2 || row < 0 || col > 2 || col < 0) {
            throw new IllegalArgumentException("Error: Trying to add a mark outside of the board boundaries (col: 0-2, row: 0-2)"); 
        }
        board[row][col] = mark;
    }

    public char[][] getBoard() {
        return board;
    }
    
}
