package org.xander.bowling;

import org.apache.log4j.Logger;

public class Game {

    private Logger logger = Logger.getLogger(getClass());

    private static int bonusFactorForFirstRoll = 1;
    private static int bonusFactorForSecondRoll = 1;
    public static int totalScore;
    public static int numberOfStrikes;
    public static int frameNumber;

    private int frameScore;
    public int thirdExtraRollDueToSpare;

    public int getThirdExtraRollDueToSpare() {
        return thirdExtraRollDueToSpare;
    }

    public void setThirdExtraRollDueToSpare(int thirdExtraRollDueToSpare) {
        this.thirdExtraRollDueToSpare = thirdExtraRollDueToSpare;
    }

    public int getFrameScore() {
        return frameScore;
    }

    public void setFrameScore(int frameScore) {
        this.frameScore = frameScore;
    }

    public void roll(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {
        frameNumber++;

        if (frameNumber == 10 && numberOfStrikes == 9) {
            extraStrikes(firstRollKnockedDownPins, secondRollKnockedDownPins);
        } else {
            pointsChecker(firstRollKnockedDownPins, secondRollKnockedDownPins);

            if (firstRollKnockedDownPins + secondRollKnockedDownPins < 10) {
                usualRoll(firstRollKnockedDownPins, secondRollKnockedDownPins);
            } else {
                if (firstRollKnockedDownPins == 10 || secondRollKnockedDownPins == 10) {
                    strikeRoll(firstRollKnockedDownPins);
                } else {
                    spareRoll(firstRollKnockedDownPins, secondRollKnockedDownPins);
                }
            }
        }
    }

    private void usualRoll(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {
        countPoints(firstRollKnockedDownPins, secondRollKnockedDownPins);
        bonusFactorForFirstRoll = 1;
        bonusFactorForSecondRoll = 1;
    }

    private void spareRoll(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {
        countPoints(firstRollKnockedDownPins, secondRollKnockedDownPins);
        bonusFactorForFirstRoll = 2;
        bonusFactorForSecondRoll = 1;

        if (frameNumber == 10)
            totalScore += getThirdExtraRollDueToSpare();
    }

    private void strikeRoll(int firstRollKnockedDownPins) {
        numberOfStrikes++;
        countPoints(firstRollKnockedDownPins, 0);
        bonusFactorForFirstRoll = 2;
        bonusFactorForSecondRoll = 2;
    }

    private void countPoints(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {
        setFrameScore(firstRollKnockedDownPins * bonusFactorForFirstRoll + secondRollKnockedDownPins * bonusFactorForSecondRoll);
        totalScore += getFrameScore();
    }

    private void extraStrikes(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {
        if (firstRollKnockedDownPins == 10 && secondRollKnockedDownPins == 10 ){
        totalScore = 300;
        } else {
            totalScore += (firstRollKnockedDownPins + secondRollKnockedDownPins) * 2;
        }
    }

    private void pointsChecker(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {
        int sumOfPoints = firstRollKnockedDownPins + secondRollKnockedDownPins;

        if (sumOfPoints > 10 || sumOfPoints < 0) {
            logger.error("There is something wrong with your bowling, please contact your" +
                    " local bowling dealer");
            throw new RuntimeException();
        }
    }
}