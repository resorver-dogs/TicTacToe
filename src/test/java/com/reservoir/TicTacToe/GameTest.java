package com.reservoir.TicTacToe;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GameTest {

    @Test
    public void testGetCurrPlayer()
    {
    	Game game = new Game();
    	assertEquals('X', game.getCurrPlayer());
    }    
}
