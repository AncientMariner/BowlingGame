package org.xander.bowling;

import org.apache.log4j.Logger;

public class Frame {

    private static final Logger logger = Logger.getLogger(Frame.class);

    public static int bonusForFirstRoll;
    public static int bonusForSecondRoll;
    public static int strikesPerGameNumber;
    public static int currentFrameNumber;
    public static int gameTotalScore;
    public static boolean consecutiveStrike;
    private static final int MAX_KNOCKED_DOWN_PINS = 10;

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
            tenthFrameRoll(firstRollKnockedDownPins, secondRollKnockedDownPins, getThirdExtraRollInTenthFrameKnockedDownPins());
        } else {
            ordinaryRollFromFirstToNinthFrame(firstRollKnockedDownPins, secondRollKnockedDownPins);
        }
    }

    private void ordinaryRollFromFirstToNinthFrame(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {

        verifyPointsAreInGameRulesRangeForNonTenthFrame(firstRollKnockedDownPins + secondRollKnockedDownPins);

        if (firstRollKnockedDownPins + secondRollKnockedDownPins < MAX_KNOCKED_DOWN_PINS) {
            openFrameRoll(firstRollKnockedDownPins, secondRollKnockedDownPins);
        } else {
            frameRollWithBonus(firstRollKnockedDownPins, secondRollKnockedDownPins);
        }
    }

    private void frameRollWithBonus(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {
        if (firstRollKnockedDownPins == MAX_KNOCKED_DOWN_PINS) {
            strike();
        } else {
            spare(firstRollKnockedDownPins, secondRollKnockedDownPins);
        }
    }

    private void openFrameRoll(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {

        calculateScore(firstRollKnockedDownPins, secondRollKnockedDownPins);

        bonusForFirstRoll = 1;
        bonusForSecondRoll = 1;

        consecutiveStrike = false;
    }

    private void spare(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {

        calculateScore(firstRollKnockedDownPins, secondRollKnockedDownPins);

        bonusForFirstRoll = 2;
        bonusForSecondRoll = 1;

        consecutiveStrike = false;
    }

    private void strike() {
        strikesPerGameNumber++;

        calculateScore(MAX_KNOCKED_DOWN_PINS, 0);

        if (bonusForFirstRoll == 2 || bonusForSecondRoll == 2) {
            consecutiveStrike = true;
        }

        bonusForFirstRoll = 2;
        bonusForSecondRoll = 2;

        if (strikesPerGameNumber == 9) {
            gameTotalScore = 270;
        }
    }

    private void calculateScore(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {
        if (    consecutiveStrike == true) {
            bonusForFirstRoll = 3;
        }

        setCurrentFrameScore(firstRollKnockedDownPins * bonusForFirstRoll + secondRollKnockedDownPins * bonusForSecondRoll);
        gameTotalScore += getCurrentFrameScore();
    }

    private void tenthFrameRoll(int firstRollKnockedDownPins, int secondRollKnockedDownPins, int thirdExtraRollInTenthFrameKnockedDownPins) {
        if (firstRollKnockedDownPins == MAX_KNOCKED_DOWN_PINS) {
            strikeInLastFrame(secondRollKnockedDownPins, thirdExtraRollInTenthFrameKnockedDownPins);
        } else {
            spareInLastFrame(firstRollKnockedDownPins, secondRollKnockedDownPins, thirdExtraRollInTenthFrameKnockedDownPins);
        }
    }

    private void strikeInLastFrame(int secondRollKnockedDownPins, int thirdExtraRollInTenthFrameKnockedDownPins) {
        gameTotalScore += MAX_KNOCKED_DOWN_PINS;
        strikesPerGameNumber++;

        extraThirdStrikeRoll(secondRollKnockedDownPins, thirdExtraRollInTenthFrameKnockedDownPins);
    }

    private void extraThirdStrikeRoll(int secondRollKnockedDownPins, int thirdExtraRollInTenthFrameKnockedDownPins) {
        if (strikesPerGameNumber == 10 && secondRollKnockedDownPins == MAX_KNOCKED_DOWN_PINS && thirdExtraRollInTenthFrameKnockedDownPins == MAX_KNOCKED_DOWN_PINS) {
            gameTotalScore += MAX_KNOCKED_DOWN_PINS + MAX_KNOCKED_DOWN_PINS;
            strikesPerGameNumber += 2;
        } else {
            verifyPointsAreInGameRulesRangeForTenthFrame(secondRollKnockedDownPins, thirdExtraRollInTenthFrameKnockedDownPins);
            gameTotalScore += secondRollKnockedDownPins;
            gameTotalScore += thirdExtraRollInTenthFrameKnockedDownPins;
        }
    }

    private void spareInLastFrame(int firstRollKnockedDownPins, int secondRollKnockedDownPins, int thirdExtraRollInTenthFrameKnockedDownPins) {
        verifyPointsAreInGameRulesRangeForNonTenthFrame(firstRollKnockedDownPins + secondRollKnockedDownPins + thirdExtraRollInTenthFrameKnockedDownPins);
        gameTotalScore += firstRollKnockedDownPins + secondRollKnockedDownPins;

        if ((firstRollKnockedDownPins + secondRollKnockedDownPins) < MAX_KNOCKED_DOWN_PINS) {
            gameTotalScore += thirdExtraRollInTenthFrameKnockedDownPins;
        }
    }

    private void verifyPointsAreInGameRulesRangeForNonTenthFrame(int sumOfPointsForTwoRollsPerFrame) {
        if (sumOfPointsForTwoRollsPerFrame > MAX_KNOCKED_DOWN_PINS || sumOfPointsForTwoRollsPerFrame < 0) {
            System.out.println("There is something wrong with your bowling, please contact your local bowling dealer");
            logger.error("Wrong entered number of knocked down pins");

            throw new RuntimeException();
        }
    }

    private void verifyPointsAreInGameRulesRangeForTenthFrame(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {
        if ((firstRollKnockedDownPins > MAX_KNOCKED_DOWN_PINS || firstRollKnockedDownPins < 0) && (secondRollKnockedDownPins > MAX_KNOCKED_DOWN_PINS || secondRollKnockedDownPins < 0)) {
            System.out.println("There is something wrong with your bowling, please contact your local bowling dealer");
            logger.error("Wrong entered number of knocked down pins");

            throw new RuntimeException();
        }
    }
}
