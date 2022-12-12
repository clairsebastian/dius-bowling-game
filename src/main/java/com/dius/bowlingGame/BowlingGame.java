package com.dius.bowlingGame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private List<BowlingFrame> frames = new ArrayList<>();
    public BowlingGame(){
        this.frames.add(new BowlingFrame());
    }

    public void roll(int pinCount){}

    public int score() {
        return 0;
    }
}
