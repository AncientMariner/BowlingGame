package org.xander.bowling;

import org.apache.log4j.Logger;

public class Frame {

    private Logger logger = Logger.getLogger(getClass());

    public static int bonusFactorForFirstRoll;
    public static int bonusFactorForSecondRoll;
    public static int strikesPerGameNumber;
    public static int currentFrameNumber;
    public static int gameTotalScore;
    public static boolean consecutiveStrike;
    private final int MAX_KNOCKED_DOWN_PINS = 10;

    private int currentFrameScore;
    private int thirdExtraRollInTenthFrameKnockedDownPins;

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

    public void roll(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {
        currentFrameNumber++;

        if (currentFrameNumber == 10) {
            tenthFrameExtraRoll(firstRollKnockedDownPins, secondRollKnockedDownPins, getThirdExtraRollInTenthFrameKnockedDownPins());
        } else {
            verifyPointsAreInGameRulesRange(firstRollKnockedDownPins, secondRollKnockedDownPins);
            if (firstRollKnockedDownPins + secondRollKnockedDownPins < MAX_KNOCKED_DOWN_PINS) {
                usualRoll(firstRollKnockedDownPins, secondRollKnockedDownPins);
            } else {
                if (firstRollKnockedDownPins == MAX_KNOCKED_DOWN_PINS) {
                    strikeRoll(firstRollKnockedDownPins, secondRollKnockedDownPins);
                } else {
                    spareRoll(firstRollKnockedDownPins, secondRollKnockedDownPins);
                }
            }
        }
    }

    private void usualRoll(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {

        calculateScore(firstRollKnockedDownPins, secondRollKnockedDownPins);

        bonusFactorForFirstRoll = 1;
        bonusFactorForSecondRoll = 1;

        consecutiveStrike = false;
    }

    private void spareRoll(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {

        calculateScore(firstRollKnockedDownPins, secondRollKnockedDownPins);

        bonusFactorForFirstRoll = 2;
        bonusFactorForSecondRoll = 1;

        consecutiveStrike = false;
    }

    private void strikeRoll(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {
        strikesPerGameNumber++;

        calculateScore(firstRollKnockedDownPins, secondRollKnockedDownPins);

        if (bonusFactorForFirstRoll == 2 || bonusFactorForSecondRoll == 2) {
            consecutiveStrike = true;
        }

        bonusFactorForFirstRoll = 2;
        bonusFactorForSecondRoll = 2;
    }

    private void calculateScore(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {
        if (consecutiveStrike == true) {
            bonusFactorForFirstRoll = 3;
        }

        setCurrentFrameScore(firstRollKnockedDownPins * bonusFactorForFirstRoll + secondRollKnockedDownPins * bonusFactorForSecondRoll);
        gameTotalScore += getCurrentFrameScore();
    }

    private void tenthFrameExtraRoll(int firstRollKnockedDownPins, int secondRollKnockedDownPins, int thirdExtraRollInTenthFrameKnockedDownPins) {
        if (firstRollKnockedDownPins == MAX_KNOCKED_DOWN_PINS) {
            strikeRollInLastFrame(firstRollKnockedDownPins, secondRollKnockedDownPins, thirdExtraRollInTenthFrameKnockedDownPins);
        } else if ((firstRollKnockedDownPins + secondRollKnockedDownPins) == MAX_KNOCKED_DOWN_PINS) {
            spareRollInLastFrame(firstRollKnockedDownPins, secondRollKnockedDownPins, thirdExtraRollInTenthFrameKnockedDownPins);
        }
    }

    private void strikeRollInLastFrame(int firstRollKnockedDownPins, int secondRollKnockedDownPins, int thirdExtraRollInTenthFrameKnockedDownPins) {
        if (strikesPerGameNumber == 9) {
            gameTotalScore = 270;
        } else {
            gameTotalScore += firstRollKnockedDownPins;
        }

        if (secondRollKnockedDownPins == MAX_KNOCKED_DOWN_PINS && thirdExtraRollInTenthFrameKnockedDownPins == MAX_KNOCKED_DOWN_PINS && strikesPerGameNumber == 9) {
            gameTotalScore = 300;
        } else {
            gameTotalScore += secondRollKnockedDownPins;
            gameTotalScore += thirdExtraRollInTenthFrameKnockedDownPins;
        }
    }

    private void spareRollInLastFrame(int firstRollKnockedDownPins, int secondRollKnockedDownPins, int thirdExtraRollInTenthFrameKnockedDownPins) {
        gameTotalScore += firstRollKnockedDownPins;
        gameTotalScore += secondRollKnockedDownPins;

        if ((firstRollKnockedDownPins + secondRollKnockedDownPins) < MAX_KNOCKED_DOWN_PINS) {
            verifyPointsAreInGameRulesRange(firstRollKnockedDownPins + secondRollKnockedDownPins, thirdExtraRollInTenthFrameKnockedDownPins);
            gameTotalScore += thirdExtraRollInTenthFrameKnockedDownPins;
        }
    }

    private void verifyPointsAreInGameRulesRange(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {
        int sumOfPointsForTwoRollsPerFrame = firstRollKnockedDownPins + secondRollKnockedDownPins;

        if (sumOfPointsForTwoRollsPerFrame > MAX_KNOCKED_DOWN_PINS || sumOfPointsForTwoRollsPerFrame < 0) {
            logger.error("There is something wrong with your bowling, please contact your local bowling dealer");
            throw new RuntimeException();
        }
    }
}