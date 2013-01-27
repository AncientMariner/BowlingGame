package org.xander.bowlingEngine;

import utils.ClearScoreBeforeNextGame;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RandomGameTest {

    @Before
    public void setUp() {
        ClearScoreBeforeNextGame clear = new ClearScoreBeforeNextGame();
        clear.clear();
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
