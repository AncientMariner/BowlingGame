package org.xander.bowling;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class PerfectGameTest {

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
    public void testPerfectGame() {
        int firstRollKnockedDownPins = 10;
        int secondRollKnockedDownPins = 0;
        int extra10thFirstSrike = 10;
        int extra10thSecondStrike = 10;

        Frame frame1 = new Frame();
        frame1.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Frame frame2 = new Frame();
        frame2.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Frame frame3 = new Frame();
        frame3.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Frame frame4 = new Frame();
        frame4.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Frame frame5 = new Frame();
        frame5.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Frame frame6 = new Frame();
        frame6.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Frame frame7 = new Frame();
        frame7.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Frame frame8 = new Frame();
        frame8.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Frame frame9 = new Frame();
        frame9.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Frame frame10 = new Frame();
        frame10.setThirdExtraRollInTenthFrameKnockedDownPins(extra10thSecondStrike);
        frame10.roll(extra10thFirstSrike, extra10thSecondStrike);

        Assert.assertEquals(300, Frame.gameTotalScore);
    }
}