package com.dius.bowlingGame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private List<BowlingFrame> frames = new ArrayList<>();
    public BowlingGame(){
        this.frames.add(new BowlingFrame());
    }

    public void roll(int pinCount){
        BowlingFrame currentFrame = frames.get(frames.size() - 1);
        currentFrame.roll(pinCount);
    }

    public int score() {
        int totalScore = 0;
        for (int i = 0; i < this.frames.size(); i++) {
            totalScore = totalScore + this.frames.get(i).score();
        }
        return totalScore;
    }
}
