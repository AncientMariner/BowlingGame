package org.xander.bowling;

public class Roll {
    protected static final int MAX_KNOCKED_DOWN_PINS = 10;
    private static final int singleBonus = 1;
    private static final int doubleBonus = 2;
    private static final int tripleBonus = 3;

    static boolean consecutiveStrike;

    private final Frame frame;
    private final VerifyPointsAreInGameRulesRange verifyPointsAreInGameRulesRange =
                                                                              new VerifyPointsAreInGameRulesRange();

    public Roll(Frame frame) {
        this.frame = frame;
    }

    void ordinaryRollFromFirstToNinthFrame(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {
        verifyPointsAreInGameRulesRange.verifyPointsAreInGameRulesRangeForNonTenthFrame(firstRollKnockedDownPins
                                                                                      + secondRollKnockedDownPins);
        if (consecutiveStrike == true) {
            Frame.bonusForFirstRoll = tripleBonus;
        }

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
        frame.calculateScore(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Frame.bonusForFirstRoll = singleBonus;
        Frame.bonusForSecondRoll = singleBonus;

        consecutiveStrike = false;
    }

    private void spare(int firstRollKnockedDownPins, int secondRollKnockedDownPins) {
        frame.calculateScore(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Frame.bonusForFirstRoll = doubleBonus;
        Frame.bonusForSecondRoll = singleBonus;

        consecutiveStrike = false;
    }

    private void strike() {
        Frame.strikesPerGameNumber++;

        frame.calculateScore(MAX_KNOCKED_DOWN_PINS, 0);

        if (Frame.bonusForFirstRoll == doubleBonus || Frame.bonusForSecondRoll == doubleBonus) {
            consecutiveStrike = true;
        }

        Frame.bonusForFirstRoll = doubleBonus;
        Frame.bonusForSecondRoll = doubleBonus;

        if (Frame.strikesPerGameNumber == 9) {
            Frame.gameTotalScore = 270;
        }
    }
}