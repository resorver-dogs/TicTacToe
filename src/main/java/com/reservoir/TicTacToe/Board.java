package com.reservoir.TicTacToe;

public class Board 
{
    private Cell[][] board;

    public Board() 
    {
        // Constructor for the Board class
        board = new Cell[3][3];
        initBoard();
    }

    private void initBoard() 
    {
        // Add '-' to every cell in the beginning
        for(int row = 0; row < 3; row++) 
        {
            for(int col = 0; col < 3; col ++) 
            {
                board[row][col] = new Cell();
                board[row][col].setMark('-');
            }
        }
    }

    public void addToCell(char mark, int row, int col) 
    {
        // Adds a char mark to a cell specified by row and col

        if(row > 2 || row < 0 || col > 2 || col < 0)
        {
            // Column and/or row parameters illegal, should be between 0-2 - Error
            throw new IllegalArgumentException("Error: Trying to add a mark outside of the board boundaries (col: 0-2, row: 0-2)"); 
        }
        if(board[row][col].getMark() != '-') {
            // Trying to add to cell that has already been taken - Error
            throw new RuntimeException("Error: Cell (" + row + "," + col + ") already marked! Please add to another cell...");
        }
        // Add the mark to the cell
        board[row][col].setMark(mark);
    }

    
    public char getCellMark(int row, int col) 
    {
        // Returns the mark from the specific cell
        if(row > 2 || row < 0 || col > 2 || col < 0) 
        {
            // Column and/or row parameters illegal, should be between 0-2 - Error
            throw new IllegalArgumentException("Error: Trying to reach out of board boundaries (col: 0-2, row: 0-2)"); 
        }
        return board[row][col].getMark();
    }

    public Cell[][] getBoard() 
    {
        // Returns the board itself
        return board;
    }

    public void printBoard() 
    {
        // Used to print the board
        System.out.println();
        System.out.println("          -------------");
        for(int i = 0; i < 3; i++) 
        {
            System.out.print("          | ");
            for(int j = 0; j < 3; j++) {
                System.out.print(board[i][j].getMark() + " | ");
            }
            System.out.println();
            System.out.println("          -------------");
        }
        System.out.println();
        System.out.println();
    }

    public boolean checkForWin() 
    {
        // Checks if the game has been won
        return checkForRowsWin() || checkForColsWin() || checkForDiagWin();
    }
    
    private boolean checkForRowsWin() 
    {
        // Checks if there are three adjacent cells in a row with the same mark
        for(int i = 0; i < 3; i++) 
        {
            if(board[i][0].getMark() != '-' && board[i][0].getMark() == board[i][1].getMark() && board[i][1].getMark() == board[i][2].getMark()) 
            {
                return true;
            }
        }
        return false;
    }

    private boolean checkForColsWin() 
    {
        // Checks if there are three adjacent cells in a column with the same mark
        for(int i = 0; i < 3; i++) 
        {
            if(board[0][i].getMark() != '-' && board[0][i].getMark() == board[1][i].getMark() && board[1][i].getMark() == board[2][i].getMark()) 
            {
                return true;
            }
        }
        return false;
    }

    private boolean checkForDiagWin() {
        // Checks if the diagonal cells have the same mark
        if(board[0][0].getMark() != '-' && board[0][0].getMark() == board[1][1].getMark() && board[1][1].getMark() == board[2][2].getMark()) 
        {
            return true;
        }
        if(board[0][2].getMark() != '-' && board[0][2].getMark() == board[1][1].getMark() && board[1][1].getMark() == board[2][0].getMark()) 
        {
            return true;
        }        
        return false;
    }

    public boolean boardIsFull() 
    {
        // Checks if each cell in the board has been marked 
        for(int i = 0; i < 3; i++) 
        {
            for(int j = 0; j < 3; j++) 
            {
                if(board[i][j].getMark() == '-') 
                {
                    return false;
                }
            }
        }
        return true;
    }    

    public boolean isDraw() 
    {
        // Checks if there is a draw
        return boardIsFull() && !checkForWin();
    }    
}
