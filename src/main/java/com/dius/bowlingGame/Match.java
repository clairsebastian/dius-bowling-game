package com.dius.bowlingGame;

import java.util.ArrayList;
import java.util.List;

import static com.dius.bowlingGame.Frame.*;

public class Match {
    public static final int FRAMES_IN_A_MATCH = 10;
    public static final int ONE_BALL = 1;
    public static final int TWO_BALL = 2;
    private List<Frame> frames = new ArrayList<>();

    public Match(){
        this.frames.add(new Frame(MAX_TRIES_IN_FRAME));
    }

    public void roll(int pinCount){
        Frame currentFrame = this.frames.get(this.frames.size() - 1);
        currentFrame.roll(pinCount);
        if (isLastFrame()){
            if (currentFrame.hasSpare())
                this.frames.add(new Frame(ONE_BALL));
            if (currentFrame.hasStrike())
                this.frames.add(new Frame(TWO_BALL));
        }else{
            if(currentFrame.hasTriesFinished()){
                this.frames.add(new Frame(MAX_TRIES_IN_FRAME));
            }
        }
    }

    private boolean isLastFrame() {
        return this.frames.size() < FRAMES_IN_A_MATCH;
    }

    public int score() {
        int totalScore=0;

        for (int i=0; i < Math.min(this.frames.size(), FRAMES_IN_A_MATCH); i++) {
            Frame frame = this.frames.get(i);
            totalScore +=  frame.score();

            if(frame.hasSpare()){
                totalScore +=  this.getScoreForFrameAt(i+1, ONE_BALL);
            }

            if(frame.hasStrike() && this.frames.size() > i+1){
                if(this.frames.get(i+1).hasStrike()) {
                    totalScore +=  this.getScoreForFrameAt(i+1, ONE_BALL);
                    totalScore +=  this.getScoreForFrameAt(i+2, ONE_BALL);
                }else{
                    totalScore += this.getScoreForFrameAt(i+1, TWO_BALL);
                }
            }
        }
        return totalScore;
    }

    private int getScoreForFrameAt(int pos, int noOfBalls){
       return this.frames.size() > pos ? this.frames.get(pos).getScoreForBowls(noOfBalls) : 0;
    }
}
