package com.reservoir.TicTacToe;

public class Board {

    private char[][] board;

    public Board() {
        board = new char[3][3];
        initBoard();
    }

    private void initBoard() {
        // Add '-' to every cell
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col ++) {
                board[row][col] = '-';
            }
        }
    }

    public void addToCell(char mark, int row, int col) {
        if(row > 2 || row < 0 || col > 2 || col < 0) {
            // Column and/or row parameters illegal, should be between 0-2 - Error
            throw new IllegalArgumentException("Error: Trying to add a mark outside of the board boundaries (col: 0-2, row: 0-2)"); 
        }
        if(board[row][col] != '-') {
            // Trying to add to cell that has already been taken - Error
            throw new RuntimeException("Error: Cell already marked! Please add to another cell...");
        }
        // Add the mark to the cell
        board[row][col] = mark;
    }

    public char[][] getBoard() {
        return board;
    }

    public boolean checkForWin() {
        return checkForRowsWin();
    }
    
    private boolean checkForRowsWin() {
        for(int i = 0; i < 3; i++) {
            if(board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }
        return false;
    }
    
}
