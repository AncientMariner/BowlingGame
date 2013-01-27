package org.xander.bowlingEngine;

import org.apache.log4j.Logger;

public class Frame {
    public static final Logger logger = Logger.getLogger(Frame.class);

    public static int bonusForFirstRoll;
    public static int bonusForSecondRoll;
    public static int strikesPerGameNumber;
    public static int currentFrameNumber;

    protected static int gameTotalScore;

    private int currentFrameScore;
    private int thirdExtraRollInTenthFrameKnockedDownPins;

    private final Roll roll = new Roll(this);
    private final TenthFrame tenthFrame = new TenthFrame();

    public static void clearTotalScore(){
        gameTotalScore = 0;
    }

    public static int getGameTotalScore(){
        return gameTotalScore;
    }

    public int getThirdExtraRollInTenthFrameKnockedDownPins() {
        return thirdExtraRollInTenthFrameKnockedDownPins;
    }

    public void setThirdExtraRollInTenthFrameKnockedDownPins(int thirdExtraRollInTenthFrameKnockedDownPins) {
        this.thirdExtraRollInTenthFrameKnockedDownPins = thirdExtraRollInTenthFrameKnockedDownPins;
    }

    public int getCurrentFrameScore() {
        return currentFrameScore;
    }

    public void setCurrentFrameScore(int currentFrameScore) {
        this.currentFrameScore = currentFrameScore;
    }

    public void roll(int firstRollKnockedDownPins,
                     int secondRollKnockedDownPins) {
        currentFrameNumber++;

        if (currentFrameNumber == 10) {
            tenthFrame.tenthFrameRoll(firstRollKnockedDownPins,
                                      secondRollKnockedDownPins,
                                      getThirdExtraRollInTenthFrameKnockedDownPins());
        } else {
            roll.ordinaryRollFromFirstToNinthFrame(firstRollKnockedDownPins, secondRollKnockedDownPins);
        }
    }

    protected void calculateScore(int firstRollKnockedDownPins,
                                  int secondRollKnockedDownPins) {
        calculateCurrentFrameScore(firstRollKnockedDownPins, secondRollKnockedDownPins);
        calculateTotalScore();
    }

    private void calculateCurrentFrameScore(int firstRollKnockedDownPins,
                                            int secondRollKnockedDownPins) {
        setCurrentFrameScore(firstRollKnockedDownPins * bonusForFirstRoll +
                secondRollKnockedDownPins * bonusForSecondRoll);
    }

    private void calculateTotalScore() {
        gameTotalScore += getCurrentFrameScore();
    }
}