// Test
package com.reservoir.TicTacToe;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

    public class PlayerTest {

    public void main(String args[]) {
        org.junit.runner.JUnitCore.main("com.reservoir.TicTacToe.PlayerTest");
    }

    @Test
    public void playerHasName() {
        Player player = new Player('X', "Gisli");
        assertEquals("Gisli", player.getName());
    }

    @Test
    public void playerHasX() {
        Player player = new Player('X', "Gisli");
        assertEquals('X', player.getMark());
    }

    @Test
    public void playerHasWon() {
        Player player = new Player('X', "Gisli");
        player.hasWon();
        assertEquals('X', player.getMark());
        assertEquals("Gisli", player.getName());
        assertEquals(1, player.getWins());
        player.hasWon();
        assertEquals(2, player.getWins());
    }
}


