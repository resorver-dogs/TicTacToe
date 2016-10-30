package com.reservoir.TicTacToe;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class BoardTest {

    
    @Test
    public void boardCorrectlyBuilt() {
        Board board = new Board();
        Cell[][] newBoard = new Cell[3][3];
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 3; col ++) {
                newBoard[row][col] = new Cell();
                newBoard[row][col].setMark('-');
            }
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                assertEquals(board.getCellMark(i, j), newBoard[i][j].getMark());
            }
        }
       // assertArrayEquals(board.getBoard(), newBoard);        
    }

    @Test 
    public void addMarksToCell() {
        Board board = new Board();
        board.addToCell('X', 0, 0);
        board.addToCell('O', 1, 1);
        board.addToCell('X', 2, 2);
        assertEquals('X', board.getCellMark(0, 0));
        assertEquals('-', board.getCellMark(0, 1));
        assertEquals('-', board.getCellMark(0, 2));
        assertEquals('-', board.getCellMark(1, 0));
        assertEquals('O', board.getCellMark(1, 1));
        assertEquals('-', board.getCellMark(1, 2));
        assertEquals('-', board.getCellMark(2, 0));
        assertEquals('-', board.getCellMark(2, 1));
        assertEquals('X', board.getCellMark(2, 2));
    }

    
    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void TryingToAddMarkOutsideOfTheBoard() {
        Board board = new Board();
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Error: Trying to add a mark outside of the board boundaries (col: 0-2, row: 0-2)");
        board.addToCell('X', -1, 4);
    }
    
    @Test
    public void TryingToReachOutOfTheBoard() {
        Board board = new Board();
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Error: Trying to reach out of board boundaries (col: 0-2, row: 0-2)");
        board.getCellMark(2, 4);
    }

    @Test
    public void MarkAddedTwiceToTheSameCell() {
        Board board = new Board();
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("Error: Cell (0,0) already marked! Please add to another cell...");
        board.addToCell('X', 0, 0);
        board.addToCell('O', 0, 0);
    }

    @Test
    public void CheckForWin_EmptyBoard() {
        Board board = new Board();
        assertFalse(board.checkForWin());
    }

    @Test
    public void CheckForWin_XHasWonRow() {
        Board board = new Board();
        board.addToCell('X', 0, 0);
        board.addToCell('X', 0, 1);
        board.addToCell('X', 0, 2);
        assertTrue(board.checkForWin());
    }

    @Test
    public void CheckForWin_OHasWonRow() {
        Board board = new Board();
        board.addToCell('O', 2, 0);
        board.addToCell('O', 2, 1);
        board.addToCell('O', 2, 2);
        assertTrue(board.checkForWin());
    }

    @Test
    public void CheckForWin_NoWinsDifferentMarks() {
        Board board = new Board();
        board.addToCell('O', 1, 0);
        board.addToCell('X', 1, 1);
        board.addToCell('F', 1, 2);
        assertFalse(board.checkForWin());
    }

    @Test
    public void CheckForWin_XHasWonCol() {
        Board board = new Board();
        board.addToCell('X', 0, 0);
        board.addToCell('X', 1, 0);
        board.addToCell('X', 2, 0);
        assertTrue(board.checkForWin());
    }

    @Test
    public void CheckForWin_OHasWonCol() {
        Board board = new Board();
        board.addToCell('O', 0, 1);
        board.addToCell('O', 1, 1);
        board.addToCell('O', 2, 1);
        assertTrue(board.checkForWin());
    }

    @Test
    public void CheckForWin_NoWinsCol() {
        Board board = new Board();
        board.addToCell('O', 0, 2);
        board.addToCell('X', 1, 2);
        board.addToCell('O', 2, 2);
        assertFalse(board.checkForWin());
    }

    @Test
    public void CheckForWin_XDiagWin() {
        Board board = new Board();
        board.addToCell('X', 0, 0);
        board.addToCell('X', 1, 1);
        board.addToCell('X', 2, 2);
        assertTrue(board.checkForWin());
        assertFalse(board.boardIsFull());
    }       

    @Test
    public void CheckForWin_ODiagWin() {
        Board board = new Board();
        board.addToCell('O', 0, 2);
        board.addToCell('O', 1, 1);
        board.addToCell('O', 2, 0);
        assertTrue(board.checkForWin());
        assertFalse(board.boardIsFull());
    }      

    @Test
    public void CheckForWin_NoDiagWin() {
        Board board = new Board();
        board.addToCell('O', 0, 2);
        board.addToCell('X', 1, 1);
        board.addToCell('O', 2, 0);
        assertFalse(board.checkForWin());
        assertFalse(board.boardIsFull());
    }      

    @Test
    public void CheckIfBoardIsFull_EmptyBoard() {
        Board board = new Board();
        assertFalse(board.boardIsFull());
    } 

    @Test
    public void CheckIfBoardIsFull_BoardFullOWins() {
        Board board = new Board();
        board.addToCell('O', 0, 0);
        board.addToCell('X', 0, 1);
        board.addToCell('O', 0, 2);
        board.addToCell('X', 1, 0);
        board.addToCell('O', 1, 1);
        board.addToCell('X', 1, 2);
        board.addToCell('O', 2, 0);
        board.addToCell('X', 2, 1);
        board.addToCell('O', 2, 2);
        assertTrue(board.checkForWin());
        assertFalse(board.isDraw());
        assertTrue(board.boardIsFull());
    }

    @Test
    public void CheckIfBoardIsFull_Draw() {
        Board board = new Board();
        board.addToCell('X', 0, 0);
        board.addToCell('O', 0, 1);
        board.addToCell('X', 0, 2);
        board.addToCell('X', 1, 0);
        board.addToCell('O', 1, 1);
        board.addToCell('X', 1, 2);
        board.addToCell('O', 2, 0);
        board.addToCell('X', 2, 1);
        board.addToCell('O', 2, 2);
        assertTrue(board.isDraw());
        assertTrue(board.boardIsFull());
    }        
}
