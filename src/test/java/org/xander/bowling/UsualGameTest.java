package org.xander.bowling;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class UsualGameTest {

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
    public void testGame() {
        int firstRollKnockedDownPins = 1;
        int secondRollKnockedDownPins = 4;

        int thirdExtraRollDueToSpare = 0;

        Frame frame1 = new Frame();
        frame1.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        firstRollKnockedDownPins = 4;
        secondRollKnockedDownPins = 5;

        Frame frame2 = new Frame();
        frame2.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        firstRollKnockedDownPins = 6;
        secondRollKnockedDownPins = 4;

        Frame frame3 = new Frame();
        frame3.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        firstRollKnockedDownPins = 5;
        secondRollKnockedDownPins = 5;

        Frame frame4 = new Frame();
        frame4.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        firstRollKnockedDownPins = 10;
        secondRollKnockedDownPins = 0;

        Frame frame5 = new Frame();
        frame5.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        firstRollKnockedDownPins = 0;
        secondRollKnockedDownPins = 1;

        Frame frame6 = new Frame();
        frame6.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        firstRollKnockedDownPins = 7;
        secondRollKnockedDownPins = 3;

        Frame frame7 = new Frame();
        frame7.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        firstRollKnockedDownPins = 6;
        secondRollKnockedDownPins = 4;

        Frame frame8 = new Frame();
        frame8.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        firstRollKnockedDownPins = 10;
        secondRollKnockedDownPins = 0;

        Frame frame9 = new Frame();
        frame9.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        firstRollKnockedDownPins = 2;
        secondRollKnockedDownPins = 8;

        Frame frame10 = new Frame();

        frame10.setThirdExtraRollInTenthFrameKnockedDownPins(thirdExtraRollDueToSpare);
        frame10.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Assert.assertEquals(117, Frame.gameTotalScore);
    }
}