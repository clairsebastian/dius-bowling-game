package com.dius.bowlingGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    @Test
    public void testGameScoreIsZeroAtStart(){
        BowlingGame b = new BowlingGame();
        assertEquals(0, b.score());
    }
}
