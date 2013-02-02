package org.xander.bowlingEngine;

import utils.ClearScoreBeforeNextGame;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class ThreeStrikesInLastFrameTest {

    @Before
    public void setUp() {
        ClearScoreBeforeNextGame clear = new ClearScoreBeforeNextGame();
        clear.clear();
    }

    @Test
    public void threeStrikesInLastFrameTest() {

        int firstRollKnockedDownPins = 1;
        int secondRollKnockedDownPins = 4;

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

        int extra10thFirstSrike = 10;
        int extra10thSecondStrike = 10;

        Frame frame10 = new Frame();
        frame10.setThirdRollInTenthFrame(extra10thSecondStrike);
        frame10.roll(extra10thFirstSrike, extra10thSecondStrike);

        Assert.assertEquals(137, Frame.getGameTotalScore());
    }

}

