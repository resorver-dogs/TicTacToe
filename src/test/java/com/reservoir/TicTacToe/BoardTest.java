package com.reservoir.TicTacToe;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class BoardTest {
        
        @Test
        public void boardCorrectlyBuilt() {
            Board board = new Board();
            char[][] charBoard = new char[3][3];
            for(int row = 0; row < 3; row++) {
                for(int col = 0; col < 3; col ++) {
                    charBoard[row][col] = '-';
                }
            }
            assertArrayEquals(board.getBoard(), charBoard);        
        }

        @Test 
        public void addMarksToCell() {
            Board board = new Board();
            board.addToCell('X', 0, 0);
            board.addToCell('O', 1, 1);
            board.addToCell('X', 2, 2);
            assertEquals('X', board.getBoard()[0][0]);
            assertEquals('-', board.getBoard()[0][1]);
            assertEquals('-', board.getBoard()[1][0]);
            assertEquals('O', board.getBoard()[1][1]);
            assertEquals('-', board.getBoard()[1][2]);
            assertEquals('-', board.getBoard()[2][0]);
            assertEquals('-', board.getBoard()[2][1]);
            assertEquals('X', board.getBoard()[2][2]);
        }

}