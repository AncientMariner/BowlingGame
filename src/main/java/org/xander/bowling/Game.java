package org.xander.bowling;

import org.apache.log4j.Logger;

public class Game {

    private Logger logger = Logger.getLogger(getClass());

    private static int bonusFactorForFirstRoll = 1;
    private static int bonusFactorForSecondRoll = 1;
    public static int totalScore;
    public static int numberOfStrikes;
    public static int frameNumber;
    private static boolean consecutiveStrike;

    private int frameScore;
    private int thirdExtraRoll;

    public int getThirdExtraRoll() {
        return thirdExtraRoll;
    }

    public void setThirdExtraRoll(int thirdExtraRoll) {
        this.thirdExtraRoll = thirdExtraRoll;
    }

    public int getFrameScore() {
        return frameScore;
    }

    public void setFrameScore(int frameScore) {
        this.frameScore = frameScore;
    }

    public void roll(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {
        frameNumber++;

        if (frameNumber == 10 ) {

            TenthFrameRoll(firstRollKnockedDownPins, secondRollKnockedDownPins, getThirdExtraRoll());
        } else {
            validatePoints(firstRollKnockedDownPins, secondRollKnockedDownPins);
            if (firstRollKnockedDownPins + secondRollKnockedDownPins < 10) {
                usualRoll(firstRollKnockedDownPins, secondRollKnockedDownPins);
            } else {
                if (firstRollKnockedDownPins == 10 ) {
                    strikeRoll(firstRollKnockedDownPins, secondRollKnockedDownPins);
                } else {
                    spareRoll(firstRollKnockedDownPins, secondRollKnockedDownPins);
                }
            }
        }
    }

    private void usualRoll(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {

        if (consecutiveStrike == true){
            bonusFactorForFirstRoll = 3;
        }

        countPoints(firstRollKnockedDownPins, secondRollKnockedDownPins);

        bonusFactorForFirstRoll = 1;
        bonusFactorForSecondRoll = 1;

        consecutiveStrike = false;
    }

    private void spareRoll(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {

        if (consecutiveStrike == true){
            bonusFactorForFirstRoll = 3;
        }

        countPoints(firstRollKnockedDownPins, secondRollKnockedDownPins);

        bonusFactorForFirstRoll = 2;
        bonusFactorForSecondRoll = 1;

        consecutiveStrike = false;
    }

    private void strikeRoll(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {
        numberOfStrikes++;

        if (consecutiveStrike == true){
            bonusFactorForFirstRoll = 3;
        }

        countPoints(firstRollKnockedDownPins, secondRollKnockedDownPins);

        if (bonusFactorForFirstRoll == 2 || bonusFactorForSecondRoll == 2) {
            consecutiveStrike = true;
        }

        bonusFactorForFirstRoll = 2;
        bonusFactorForSecondRoll = 2;
    }

    private void countPoints(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {
        setFrameScore(firstRollKnockedDownPins * bonusFactorForFirstRoll + secondRollKnockedDownPins * bonusFactorForSecondRoll);
        totalScore += getFrameScore();
    }

    private void TenthFrameRoll(int firstRollKnockedDownPins, int secondRollKnockedDownPins, int thirdExtraRoll) {
        if (firstRollKnockedDownPins == 10){
            lastFrameWithStrikeRoll(firstRollKnockedDownPins, secondRollKnockedDownPins, thirdExtraRoll);
        } else if ((firstRollKnockedDownPins + secondRollKnockedDownPins) == 10) {
            lastFrameWithSpareRoll(firstRollKnockedDownPins, secondRollKnockedDownPins, thirdExtraRoll);
        }
    }

    private void lastFrameWithStrikeRoll(int firstRollKnockedDownPins, int secondRollKnockedDownPins, int thirdExtraRoll) {
        if( numberOfStrikes == 9) {
            totalScore = 270;
        } else {
            totalScore += firstRollKnockedDownPins;
        }

        if (secondRollKnockedDownPins == 10 && thirdExtraRoll == 10 && numberOfStrikes == 9){
            totalScore = 300;
        } else {
            totalScore += secondRollKnockedDownPins;
            totalScore += thirdExtraRoll;
        }
    }

    private void lastFrameWithSpareRoll(int firstRollKnockedDownPins, int secondRollKnockedDownPins, int thirdExtraRoll) {
        totalScore += firstRollKnockedDownPins;
        totalScore += secondRollKnockedDownPins;

        if ((firstRollKnockedDownPins + secondRollKnockedDownPins) < 10) {
            validatePoints(firstRollKnockedDownPins + secondRollKnockedDownPins, thirdExtraRoll);
            totalScore += thirdExtraRoll;
        }
    }

    private void validatePoints(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {
        int sumOfPoints = firstRollKnockedDownPins + secondRollKnockedDownPins;

        if (sumOfPoints > 10 || sumOfPoints < 0) {
            logger.error("There is something wrong with your bowling, please contact your" +
                    " local bowling dealer");
            throw new RuntimeException();
        }
    }
}