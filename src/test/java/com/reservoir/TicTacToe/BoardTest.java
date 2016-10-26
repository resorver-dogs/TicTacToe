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

}