package com.dius.bowlingGame;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatchTest {

    @Test
    public void testGameScoreIsZeroAtStart(){
        Match match = new Match();
        assertEquals(0, match.score());
    }

    @Test
    public void testGameForOneFrameWithNoSpareOrStrike(){
        Match match = new Match();
        match.roll(4);
        assertEquals(4, match.score());
        match.roll(4);
        assertEquals(8, match.score());
    }
    @Test
    public void testGameForTwoFrameWithNoSpareOrStrike(){
        Match match = new Match();
        match.roll(4);
        match.roll(4);
        assertEquals(8, match.score());
        match.roll(3);
        match.roll(5);
        assertEquals(16, match.score());
    }
    @Test
    public void testGameForOneFrameWithStrike(){
        Match match = new Match();
        match.roll(10);
        match.roll(0);
        assertEquals(10, match.score());

    }
    @Test
    public void testGameForOneFrameWithSpare(){
        Match match = new Match();
        match.roll(4);
        match.roll(6);
        assertEquals(10, match.score());
    }

    @Test
    public void testGameForTwoFrameWithStrike(){
        Match match = new Match();
        match.roll(10);
        assertEquals(10, match.score());
        match.roll(5);
        match.roll(4);
        assertEquals(28, match.score());

    }
    @Test
    public void testGameForTwoFrameWithSpare(){
        Match match = new Match();
        match.roll(4);
        match.roll(6);
        assertEquals(10, match.score());
        match.roll(5);
        match.roll(0);
        assertEquals(20, match.score());
    }
}
