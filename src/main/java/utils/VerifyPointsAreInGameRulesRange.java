package utils;

import org.xander.bowlingEngine.Frame;
import org.xander.bowlingEngine.Roll;

public class VerifyPointsAreInGameRulesRange {

    public void verifyPointsAreInGameRulesRangeForNonTenthFrame(int sumOfPointsForTwoRollsPerFrame) {
        if (sumOfPointsForTwoRollsPerFrame > Roll.MAX_KNOCKED_DOWN_PINS || sumOfPointsForTwoRollsPerFrame < 0) {
            System.out.println("There is something wrong with your bowlingEngine, please contact your local bowlingEngine dealer");
            Frame.logger.error("Wrong entered number of knocked down pins");

            throw new RuntimeException();
        }
    }

    public void verifyPointsAreInGameRulesRangeForTenthFrame(int firstRollKnockedDownPins,
                                                                int secondRollKnockedDownPins) {
        if ((firstRollKnockedDownPins > Roll.MAX_KNOCKED_DOWN_PINS || firstRollKnockedDownPins < 0) &&
            (secondRollKnockedDownPins > Roll.MAX_KNOCKED_DOWN_PINS || secondRollKnockedDownPins < 0)) {
            System.out.println("There is something wrong with your bowlingEngine, please contact your local bowlingEngine dealer");
            Frame.logger.error("Wrong entered number of knocked down pins");

            throw new RuntimeException();
        }
    }
}