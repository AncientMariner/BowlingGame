package org.xander.bowlingEngine;

import utils.ClearScoreBeforeNextGame;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class TenStrikesGameTest {

    @Before
    public void setUp() {
        ClearScoreBeforeNextGame clear = new ClearScoreBeforeNextGame();
        clear.clear();
    }

    @Test
    public void testTenStrikesGame() {
        int firstRollKnockedDownPins = 10;
        int secondRollKnockedDownPins = 0;
        int extra10thFirstSrike = 10;

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

        Assert.assertEquals(270, Frame.getGameTotalScore());

        Frame frame10 = new Frame();
        frame10.setThirdRollInTenthFrame(0);
        frame10.roll(extra10thFirstSrike, 0);

        Assert.assertEquals(10, Frame.strikesPerGameNumber);
        Assert.assertEquals(280, Frame.getGameTotalScore());
    }
}