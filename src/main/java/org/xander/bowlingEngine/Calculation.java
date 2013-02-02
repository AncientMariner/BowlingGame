package org.xander.bowlingEngine;

public class Calculation {
    private final Frame frame;

    public Calculation(Frame frame) {
        this.frame = frame;
    }

    protected void calculateScore(int firstRollKnockedDownPins,
                                  int secondRollKnockedDownPins) {
        calculateCurrentFrameScore(firstRollKnockedDownPins, secondRollKnockedDownPins);
        calculateTotalScore();
    }

    void calculateCurrentFrameScore(int firstRollKnockedDownPins,
                                    int secondRollKnockedDownPins) {
        frame.setCurrentFrameScore(firstRollKnockedDownPins * Frame.bonusForFirstRoll +
                secondRollKnockedDownPins * Frame.bonusForSecondRoll);
    }

    void calculateTotalScore() {
        Frame.setGameTotalScore(Frame.getGameTotalScore() + frame.getCurrentFrameScore());
    }
}