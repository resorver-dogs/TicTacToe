package com.reservoir.TicTacToe;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CellTest {

    @Test
    public void testGetMove() {
        Cell cell = new Cell();
        assertEquals(' ', cell.getToken()); 
    }

}
