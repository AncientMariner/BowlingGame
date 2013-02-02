package org.xander.bowlingEngine;

import utils.VerifyPointsAreInGameRulesRange;

public class TenthFrame {
    private final VerifyPointsAreInGameRulesRange verifyPointsAreInGameRulesRange =
                                                                                new VerifyPointsAreInGameRulesRange();

    private int thirdExtraRollInTenthFrameKnockedDownPins;

    public int getThirdExtraRollInTenthFrameKnockedDownPins() {
        return thirdExtraRollInTenthFrameKnockedDownPins;
    }

    public void setThirdExtraRollInTenthFrameKnockedDownPins(int thirdExtraRollInTenthFrameKnockedDownPins) {
        this.thirdExtraRollInTenthFrameKnockedDownPins = thirdExtraRollInTenthFrameKnockedDownPins;
    }

    protected void tenthFrameRoll(int firstRollKnockedDownPins,
                                  int secondRollKnockedDownPins,
                                  int thirdExtraRollInTenthFrameKnockedDownPins) {
        if (firstRollKnockedDownPins == Roll.MAX_KNOCKED_DOWN_PINS) {
            strikeInLastFrame(secondRollKnockedDownPins, thirdExtraRollInTenthFrameKnockedDownPins);
        } else {
            spareInLastFrame(firstRollKnockedDownPins,
                             secondRollKnockedDownPins,
                             thirdExtraRollInTenthFrameKnockedDownPins);
        }
    }

    private void strikeInLastFrame(int secondRollKnockedDownPins,
                                   int thirdExtraRollInTenthFrameKnockedDownPins) {
        Frame.setGameTotalScore(Frame.getGameTotalScore() + Roll.MAX_KNOCKED_DOWN_PINS);
        Frame.strikesPerGameNumber++;

        extraThirdStrikeRoll(secondRollKnockedDownPins, thirdExtraRollInTenthFrameKnockedDownPins);
    }

    private void extraThirdStrikeRoll(int secondRollKnockedDownPins,
                                      int thirdExtraRollInTenthFrameKnockedDownPins) {
        if (Frame.strikesPerGameNumber == 10 && secondRollKnockedDownPins == Roll.MAX_KNOCKED_DOWN_PINS &&
                                    thirdExtraRollInTenthFrameKnockedDownPins == Roll.MAX_KNOCKED_DOWN_PINS) {
            Frame.setGameTotalScore(Frame.getGameTotalScore() + Roll.MAX_KNOCKED_DOWN_PINS + Roll.MAX_KNOCKED_DOWN_PINS);
            Frame.strikesPerGameNumber += 2;
        } else {
            verifyPointsAreInGameRulesRange.verifyPointsAreInGameRulesRangeForTenthFrame(secondRollKnockedDownPins,
                                                                            thirdExtraRollInTenthFrameKnockedDownPins);
            Frame.setGameTotalScore(Frame.getGameTotalScore() + secondRollKnockedDownPins + thirdExtraRollInTenthFrameKnockedDownPins);
        }
    }

    private void spareInLastFrame(int firstRollKnockedDownPins,
                                  int secondRollKnockedDownPins,
                                  int thirdExtraRollInTenthFrameKnockedDownPins) {
        verifyPointsAreInGameRulesRange.verifyPointsAreInGameRulesRangeForNonTenthFrame(
                                                                          firstRollKnockedDownPins +
                                                                          secondRollKnockedDownPins +
                                                                          thirdExtraRollInTenthFrameKnockedDownPins);
        Frame.setGameTotalScore(Frame.getGameTotalScore() + firstRollKnockedDownPins + secondRollKnockedDownPins);

        if ((firstRollKnockedDownPins + secondRollKnockedDownPins) < Roll.MAX_KNOCKED_DOWN_PINS) {
            Frame.setGameTotalScore(Frame.getGameTotalScore() + thirdExtraRollInTenthFrameKnockedDownPins);
        }
    }
}