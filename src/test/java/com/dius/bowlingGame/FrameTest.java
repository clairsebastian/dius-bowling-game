package com.dius.bowlingGame;

import org.junit.Test;

import static org.junit.Assert.*;

public class FrameTest {

    @Test
    public void testScoreWhenNotAllPinsAreKnockedDown(){
        Frame f = new Frame(Match.TWO_BALL);
        f.roll(4);
        assertEquals(4, f.score());
        assertFalse(f.hasTriesFinished());
        f.roll(4);
        assertEquals(8, f.score());
        assertFalse(f.hasSpare());
        assertFalse(f.hasStrike());
        assertTrue(f.hasTriesFinished());

    }

    @Test
    public void testScoreWhenSpare(){
        Frame f = new Frame(Match.TWO_BALL);
        f.roll(4);
        f.roll(6);
        assertEquals(10, f.score());
        assertTrue(f.hasSpare());
        assertFalse(f.hasStrike());
    }

    @Test
    public void testScoreWhenStrike(){
        Frame f = new Frame(Match.TWO_BALL);
        f.roll(10);
        assertEquals(10, f.score());
        assertTrue(f.hasStrike());
        assertFalse(f.hasSpare());
    }
    @Test
    public void testGetScoreForBowlWhenOneRollExists(){
        Frame f = new Frame(Match.TWO_BALL);
        f.roll(5);
        assertEquals(5, f.getScoreForBowls(1));
        assertEquals(5, f.getScoreForBowls(2));
    }
    @Test
    public void testGetScoreForBowlWhenTwoRollExists(){
        Frame f = new Frame(Match.TWO_BALL);
        f.roll(5);
        f.roll(4);
        assertEquals(5, f.getScoreForBowls(1));
        assertEquals(9, f.getScoreForBowls(2));
    }

}