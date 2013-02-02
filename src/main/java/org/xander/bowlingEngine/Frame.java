package org.xander.bowlingEngine;

import org.apache.log4j.Logger;

public class Frame {
    public static final Logger logger = Logger.getLogger(Frame.class);

    public static int bonusForFirstRoll;
    public static int bonusForSecondRoll;
    public static int strikesPerGameNumber;
    public static int currentFrameNumber;

    private static int gameTotalScore;

    private int currentFrameScore;

    private final Calculation calculation;
    private final Roll roll;
    private final TenthFrame tenthFrame;

    public Frame() {
        this.calculation = new Calculation(this);
        this.roll = new Roll(this);
        this.tenthFrame = new TenthFrame();
    }

    public Calculation getCalculation() {
        return calculation;
    }

    public void setThirdRollInTenthFrame(int thirdRollInTenthFrame) {
        tenthFrame.setThirdExtraRollInTenthFrameKnockedDownPins(thirdRollInTenthFrame);
    }

    public static void clearTotalScore(){
        gameTotalScore = 0;
    }

    public static int getGameTotalScore(){
        return gameTotalScore;
    }

    public static void setGameTotalScore(int gameTotalScore) {
        Frame.gameTotalScore = gameTotalScore;
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
                                      tenthFrame.getThirdExtraRollInTenthFrameKnockedDownPins());
        } else {
            roll.ordinaryRollFromFirstToNinthFrame(firstRollKnockedDownPins, secondRollKnockedDownPins);
        }
    }
}