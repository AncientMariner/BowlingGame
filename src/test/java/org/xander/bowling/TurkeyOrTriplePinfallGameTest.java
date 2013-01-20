package org.xander.bowling;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class TurkeyOrTriplePinfallGameTest {

    @Before
    public void setUp() {
        Frame.gameTotalScore = 0;
        Frame.currentFrameNumber = 0;
        Frame.strikesPerGameNumber = 0;
        Roll.consecutiveStrike = false;
        Frame.bonusForFirstRoll = 1;
        Frame.bonusForSecondRoll = 1;
    }

    @Test
    public void testTurkeyOrTriplePinFallGame() {
        int firstRollKnockedDownPins = 10;
        int secondRollKnockedDownPins = 0;

        Frame frame1 = new Frame();
        frame1.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        firstRollKnockedDownPins = 10;
        secondRollKnockedDownPins = 0;

        Frame frame2 = new Frame();
        frame2.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);


        firstRollKnockedDownPins = 10;
        secondRollKnockedDownPins = 0;

        Frame frame3 = new Frame();
        frame3.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);


        firstRollKnockedDownPins = 0;
        secondRollKnockedDownPins = 9;

        Frame frame4 = new Frame();
        frame4.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Assert.assertEquals(78, Frame.gameTotalScore);
    }
}