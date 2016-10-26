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

    public char[][] getBoard() {
        return board;
    }
    
}
