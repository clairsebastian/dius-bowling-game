package com.dius.bowlingGame;

import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingFrameTest {

    @Test
    public void testScoreWhenNotAllPinsAreKnockedDown(){
        BowlingFrame f = new BowlingFrame();
        f.roll(4);
        assertEquals(4, f.score());
        f.roll(4);
        assertEquals(8, f.score());
        assertFalse(f.hasSpare());
        assertFalse(f.hasStrike());

    }

    @Test
    public void testScoreWhenSpare(){
        BowlingFrame f = new BowlingFrame();
        f.roll(4);
        f.roll(6);
        assertEquals(10, f.score());
        assertTrue(f.hasSpare());
        assertFalse(f.hasStrike());
    }

    @Test
    public void testScoreWhenStrike(){
        BowlingFrame f = new BowlingFrame();
        f.roll(10);
        assertEquals(10, f.score());
        assertTrue(f.hasStrike());
        assertFalse(f.hasSpare());

    }

}