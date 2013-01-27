package utils;

import org.xander.bowlingEngine.Frame;
import org.xander.bowlingEngine.Roll;

public class ClearScoreBeforeNextGame {

    public void clear() {
        Frame.clearTotalScore();
        Frame.currentFrameNumber = 0;
        Frame.strikesPerGameNumber = 0;
        Roll.consecutiveStrike = false;
        Frame.bonusForFirstRoll = 1;
        Frame.bonusForSecondRoll = 1;
    }
}