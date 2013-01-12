package org.xander.bowling;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RandomGameTest {

    @Before
    public void setUp() {
        Frame.gameTotalScore = 0;
        Frame.currentFrameNumber = 0;
        Frame.strikesPerGameNumber = 0;
        Frame.consecutiveStrike = false;
        Frame.bonusFactorForFirstRoll = 1;
        Frame.bonusFactorForSecondRoll = 1;
    }

    @Test
    public void testRandomGame() {
        int firstRollKnockedDownPins = 10;
        int secondRollKnockedDownPins = 0;

        Frame frame1 = new Frame();
        frame1.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        firstRollKnockedDownPins = 10;
        secondRollKnockedDownPins = 0;

        Frame frame2 = new Frame();
        frame2.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);


        firstRollKnockedDownPins = 4;
        secondRollKnockedDownPins = 2;

        Frame frame3 = new Frame();
        frame3.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        assertEquals(46, Frame.gameTotalScore);
    }
}
