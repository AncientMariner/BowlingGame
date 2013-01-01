package org.xander.bowling;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class TheGameTest {

    @Test
    public void testGame() {

        Game.totalScore = 0;
        int firstRollKnockedDownPins = 1;
        int secondRollKnockedDownPins = 4;
        int thirdExtraRollDueToSpare = 0;

        Game frame1 = new Game();
        frame1.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        firstRollKnockedDownPins = 4;
        secondRollKnockedDownPins = 5;

        Game frame2 = new Game();
        frame2.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        firstRollKnockedDownPins = 6;
        secondRollKnockedDownPins = 4;

        Game frame3 = new Game();
        frame3.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        firstRollKnockedDownPins = 5;
        secondRollKnockedDownPins = 5;

        Game frame4 = new Game();
        frame4.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        firstRollKnockedDownPins = 10;
        secondRollKnockedDownPins = 0;

        Game frame5 = new Game();
        frame5.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        firstRollKnockedDownPins = 0;
        secondRollKnockedDownPins = 1;

        Game frame6 = new Game();
        frame6.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        firstRollKnockedDownPins = 7;
        secondRollKnockedDownPins = 3;

        Game frame7 = new Game();
        frame7.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        firstRollKnockedDownPins = 6;
        secondRollKnockedDownPins = 4;

        Game frame8 = new Game();
        frame8.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        firstRollKnockedDownPins = 10;
        secondRollKnockedDownPins = 0;

        Game frame9 = new Game();
        frame9.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        firstRollKnockedDownPins = 2;
        secondRollKnockedDownPins = 8;

        Game frame10 = new Game();

        frame10.setThirdExtraRoll(thirdExtraRollDueToSpare);
        frame10.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        assertEquals(117, Game.totalScore);
    }

    @Test
    public void testPerfectGame() {

        Game.totalScore = 0;
        int firstRollKnockedDownPins = 10;
        int secondRollKnockedDownPins = 0;
        int extra10thFirstSrike = 10;
        int extra10thSecondStrike = 10;

        Game frame1 = new Game();
        frame1.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Game frame2 = new Game();
        frame2.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Game frame3 = new Game();
        frame3.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Game frame4 = new Game();
        frame4.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Game frame5 = new Game();
        frame5.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Game frame6 = new Game();
        frame6.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Game frame7 = new Game();
        frame7.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Game frame8 = new Game();
        frame8.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Game frame9 = new Game();
        frame9.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);


        Game frame10 = new Game();
        frame10.setThirdExtraRoll(extra10thSecondStrike);
        frame10.roll(extra10thFirstSrike, extra10thSecondStrike);

        assertEquals(300, Game.totalScore);
    }

    @Test
    public void test10StrikesGame() {

        Game.totalScore = 0;
        int firstRollKnockedDownPins = 10;
        int secondRollKnockedDownPins = 0;
        int extra10thFirstSrike = 10;
        int extra10thSecondStrike = 0;

        Game frame1 = new Game();
        frame1.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Game frame2 = new Game();
        frame2.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Game frame3 = new Game();
        frame3.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Game frame4 = new Game();
        frame4.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Game frame5 = new Game();
        frame5.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Game frame6 = new Game();
        frame6.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Game frame7 = new Game();
        frame7.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Game frame8 = new Game();
        frame8.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Game frame9 = new Game();
        frame9.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        Game frame10 = new Game();
        frame10.setThirdExtraRoll(extra10thSecondStrike);
        frame10.roll(extra10thFirstSrike, extra10thSecondStrike);

        assertEquals(270, Game.totalScore);
    }

    @Test
    public void testTurkeyOrTriplePinFallGame() {

        Game.totalScore = 0;
        int firstRollKnockedDownPins = 10;
        int secondRollKnockedDownPins = 0;

        Game frame1 = new Game();
        frame1.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        firstRollKnockedDownPins = 10;
        secondRollKnockedDownPins = 0;

        Game frame2 = new Game();
        frame2.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);


        firstRollKnockedDownPins = 10;
        secondRollKnockedDownPins = 0;

        Game frame3 = new Game();
        frame3.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);


        firstRollKnockedDownPins = 0;
        secondRollKnockedDownPins = 9;

        Game frame4 = new Game();
        frame4.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        assertEquals(78, Game.totalScore);
    }


    @Test
    public void testRandomGame() {

        Game.totalScore = 0;
        int firstRollKnockedDownPins = 10;
        int secondRollKnockedDownPins = 0;

        Game frame1 = new Game();
        frame1.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        firstRollKnockedDownPins = 10;
        secondRollKnockedDownPins = 0;

        Game frame2 = new Game();
        frame2.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);


        firstRollKnockedDownPins = 4;
        secondRollKnockedDownPins = 2;

        Game frame3 = new Game();
        frame3.roll(firstRollKnockedDownPins, secondRollKnockedDownPins);

        assertEquals(46, Game.totalScore);
    }
}
