package org.xander.bowling;

import org.apache.log4j.Logger;

public class Frame {
    protected static final Logger logger = Logger.getLogger(Frame.class);

    static int bonusForFirstRoll;
    static int bonusForSecondRoll;
    static int strikesPerGameNumber;
    static int currentFrameNumber;
    static int gameTotalScore;

    private int currentFrameScore;
    private int thirdExtraRollInTenthFrameKnockedDownPins;

    private final TenthFrame tenthFrame = new TenthFrame();
    private final Roll roll = new Roll(this);

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
        setCurrentFrameScore(firstRollKnockedDownPins * bonusForFirstRoll +
                                                                      secondRollKnockedDownPins * bonusForSecondRoll);
        gameTotalScore += getCurrentFrameScore();
    }
}