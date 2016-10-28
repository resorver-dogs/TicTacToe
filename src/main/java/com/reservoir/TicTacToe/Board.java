package com.reservoir.TicTacToe;

public class Board {

    private Cell[][] board;

    public Board() {
        board = new Cell[3][3];
        initBoard();
    }

    private void initBoard() {
        // Add '-' to every cell
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col ++) {
                board[row][col] = new Cell();
                board[row][col].setToken('-');
            }
        }
    }

    public void addToCell(char mark, int row, int col) {
        if(row > 2 || row < 0 || col > 2 || col < 0) {
            // Column and/or row parameters illegal, should be between 0-2 - Error
            throw new IllegalArgumentException("Error: Trying to add a mark outside of the board boundaries (col: 0-2, row: 0-2)"); 
        }
        if(board[row][col].getToken() != '-') {
            // Trying to add to cell that has already been taken - Error
            throw new RuntimeException("Error: Cell (" + row + "," + col + ") already marked! Please add to another cell...");
        }
        // Add the mark to the cell
        board[row][col].setToken(mark);
    }

    
    public char getCellMark(int row, int col) {
        if(row > 2 || row < 0 || col > 2 || col < 0) {
            // Column and/or row parameters illegal, should be between 0-2 - Error
            throw new IllegalArgumentException("Error: Trying to reach out of board boundaries (col: 0-2, row: 0-2)"); 
        }
        return board[row][col].getToken();
    }

    public Cell[][] getBoard() {
        return board;
    }

    public void printBoard() {
        System.out.println();
        System.out.println("          -------------");
        for(int i = 0; i < 3; i++) {
            System.out.print("          | ");
            for(int j = 0; j < 3; j++) {
                System.out.print(board[i][j].getToken() + " | ");
            }
            System.out.println();
            System.out.println("          -------------");
        }
        System.out.println();
        System.out.println();
    }

    public boolean checkForWin() {
        return checkForRowsWin() || checkForColsWin() || checkForDiagWin();
    }
    
    private boolean checkForRowsWin() {
        for(int i = 0; i < 3; i++) {
            if(board[i][0].getToken() != '-' && board[i][0].getToken() == board[i][1].getToken() && board[i][1].getToken() == board[i][2].getToken()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkForColsWin() {
        for(int i = 0; i < 3; i++) {
            if(board[0][i].getToken() != '-' && board[0][i].getToken() == board[1][i].getToken() && board[1][i].getToken() == board[2][i].getToken()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkForDiagWin() {
        if(board[0][0].getToken() != '-' && board[0][0].getToken() == board[1][1].getToken() && board[1][1].getToken() == board[2][2].getToken()) {
            return true;
        }
        if(board[0][2].getToken() != '-' && board[0][2].getToken() == board[1][1].getToken() && board[1][1].getToken() == board[2][0].getToken()) {
            return true;
        }        
        return false;
    }

    public boolean boardIsFull() {
        // Returns true if the board is fully completed 
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j].getToken() == '-') {
                    return false;
                }
            }
        }
        return true;
    }    
    public boolean isDraw() {
        return boardIsFull() && !checkForWin();
    }

    
}
