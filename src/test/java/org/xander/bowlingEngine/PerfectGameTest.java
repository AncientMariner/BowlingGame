package org.xander.bowlingEngine;

import utils.ClearScoreBeforeNextGame;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class PerfectGameTest {

    @Before
    public void setUp() {
        ClearScoreBeforeNextGame clear = new ClearScoreBeforeNextGame();
        clear.clear();
    }

    @Test
    public void testPerfectGame() {
        int firstRollKnockedDownPins = 10;
        int secondRollKnockedDownPins = 0;
        int extra10thFirstStrike = 10;
        int extra10thSecondStrike = 10;
        int numberOfStrikesInPerfectGame = 12;
        int maximumPointsInBowlingGame = 300;

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
        frame10.setThirdRollInTenthFrame(extra10thSecondStrike);
        frame10.roll(extra10thFirstStrike, extra10thSecondStrike);

        Assert.assertEquals(numberOfStrikesInPerfectGame, Frame.strikesPerGameNumber);
        Assert.assertEquals(maximumPointsInBowlingGame, Frame.getGameTotalScore());
    }
}