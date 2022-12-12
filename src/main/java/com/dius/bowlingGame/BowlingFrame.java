package com.dius.bowlingGame;

import java.util.ArrayList;
import java.util.List;

public class BowlingFrame {
    public static final int MAX_PIN_IN_FRAME = 10;
    private List<Integer> knockedPins = new ArrayList<>();
    public void roll(int pinCount) {
        this.knockedPins.add(pinCount);
    }

    public int score(){
        int totalScore= 0;
        for (int i = 0; i < this.knockedPins.size(); i++) {
            totalScore += this.knockedPins.get(i);
        }
        return totalScore;
    }
    public boolean hasStrike(){
        return this.knockedPins.size() >= 1 && knockedPins.get(0) == MAX_PIN_IN_FRAME;
    }
    public boolean hasSpare(){
        return this.knockedPins.size() == 2 && (knockedPins.get(0) + knockedPins.get(1) == MAX_PIN_IN_FRAME) && knockedPins.get(0)!=  MAX_PIN_IN_FRAME;
    }

}
