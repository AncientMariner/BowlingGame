package utils;

import org.xander.bowlingEngine.Frame;
import org.xander.bowlingEngine.Roll;

import static org.xander.bowlingEngine.Frame.clearTotalScore;

public class ClearScoreBeforeNextGame {

    public void clear() {
        clearTotalScore();
        Frame.currentFrameNumber = 0;
        Frame.strikesPerGameNumber = 0;
        Roll.consecutiveStrike = false;
        Frame.bonusForFirstRoll = 1;
        Frame.bonusForSecondRoll = 1;
    }
}