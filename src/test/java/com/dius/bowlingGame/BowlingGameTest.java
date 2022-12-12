package com.dius.bowlingGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {

    @Test
    public void testGameScoreIsZeroAtStart(){
        BowlingGame b = new BowlingGame();
        assertEquals(0, b.score());
    }

    @Test
    public void testGameForOneFrameWithNoSpareOrStrike(){
        BowlingGame b = new BowlingGame();
        b.roll(4);
        assertEquals(4, b.score());
        b.roll(4);
        assertEquals(8, b.score());
    }
    @Test
    public void testGameForTwoFrameWithNoSpareOrStrike(){
        BowlingGame b = new BowlingGame();
        b.roll(4);
        b.roll(4);
        assertEquals(8, b.score());
        b.roll(3);
        b.roll(5);
        assertEquals(16, b.score());
    }
    @Test
    public void testGameForOneFrameWithStrike(){
        BowlingGame b = new BowlingGame();
        b.roll(10);
        b.roll(0);
        assertEquals(10, b.score());

    }
    @Test
    public void testGameForOneFrameWithSpare(){
        BowlingGame b = new BowlingGame();
        b.roll(4);
        b.roll(6);
        assertEquals(10, b.score());
    }

    @Test
    public void testGameForTwoFrameWithStrike(){
        BowlingGame b = new BowlingGame();
        b.roll(10);
        assertEquals(10, b.score());
        b.roll(5);
        b.roll(4);
        assertEquals(28, b.score());

    }
    @Test
    public void testGameForTwoFrameWithSpare(){
        BowlingGame b = new BowlingGame();
        b.roll(4);
        b.roll(6);
        assertEquals(10, b.score());
        b.roll(5);
        b.roll(0);
        assertEquals(20, b.score());
    }
}
