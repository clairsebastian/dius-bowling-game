package com.dius.bowlingGame;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
    public static final int FRAMES_IN_A_MATCH = 10;
    public static final int ONE_BALL = 1;
    public static final int TWO_BALL = 2;
    public static final int MAX_TRIES_IN_FRAME = 2;
    private List<BowlingFrame> frames = new ArrayList<>();

    public BowlingGame(){
        this.frames.add(new BowlingFrame(MAX_TRIES_IN_FRAME));
    }

    public void roll(int pinCount){
        BowlingFrame currentFrame = frames.get(frames.size() - 1);
        currentFrame.roll(pinCount);
        if(currentFrame.hasTriesFinished() && frames.size() < FRAMES_IN_A_MATCH){
            frames.add(new BowlingFrame(MAX_TRIES_IN_FRAME));
        }
    }

    public int score() {
        int totalScore=0;

        for (int i=0; i < this.frames.size(); i++) {
            BowlingFrame bowlingFrame = this.frames.get(i);
            totalScore =  totalScore + bowlingFrame.score();

            if(bowlingFrame.hasSpare() && this.frames.size() > i+1){
                totalScore = totalScore + this.frames.get(i+1).getScoreForBowls(ONE_BALL);
            }

            if(bowlingFrame.hasStrike() && this.frames.size() > i+1){
                totalScore = totalScore + this.frames.get(i+1).getScoreForBowls(TWO_BALL);
            }
        }

        return totalScore;
    }
}
