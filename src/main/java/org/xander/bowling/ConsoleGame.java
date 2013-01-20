package org.xander.bowling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.exit;

public class ConsoleGame {

    public static void main(String[] args) {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.println("Welcome, this is Bowling\n" +
                "Please enter your roll points for each frame and you will get the final score");

        for (int frameNumber = 0; frameNumber < 10; frameNumber++) {
            System.out.println("\nFrame # " + (frameNumber + 1));

            Frame frame = new Frame();

            System.out.println("\n*** Your current score is: " + Frame.gameTotalScore + " ***");

            role(bufferedReader, frameNumber, frame);
        }

        System.out.println("\nCongratulations, you finished the game.\n" +
                "Your final score is: " + Frame.gameTotalScore);
    }

    private static void role(BufferedReader bufferedReader,
                             int frameNumber,
                             Frame frame) {
        int firstRoll;
        try {
            System.out.println("\nRoll 1: ");
            firstRoll = Integer.parseInt(bufferedReader.readLine());

            if (frameNumber == 9) {
                tenthFrameRoll(bufferedReader, firstRoll, frame);
            } else {
                if ( ordinaryRollFromFirstToNinthFrame(bufferedReader, firstRoll, frame) )
                    return;
            }
        } catch (IOException e) {
            System.out.println("You entered something wrong, please try again.\n");
            e.printStackTrace();
            exit(0);
        } catch (NumberFormatException e) {
            System.out.println("You entered something wrong, please try again.\n");
            e.printStackTrace();
            exit(0);
        }
    }

    private static boolean ordinaryRollFromFirstToNinthFrame(BufferedReader bufferedReader,
                                                             int firstRoll,
                                                             Frame frame) throws IOException {
        int secondRoll;

        if (firstRoll == 10) {
            frame.roll(firstRoll, 0);
            System.out.println("Strike !");

            return true;
        }

        System.out.println("\nRoll 2: ");
        secondRoll = Integer.parseInt(bufferedReader.readLine());

        if (secondRoll == 10) {
            frame.roll(firstRoll, secondRoll);
            System.out.println("Spare !");

            return true;
        }

        frame.roll(firstRoll, secondRoll);
        return false;
    }

    private static void tenthFrameRoll(BufferedReader bufferedReader,
                                       int firstRoll,
                                       Frame frame) throws IOException {
        if (firstRoll == 10) {
            strikeInLastFrame(bufferedReader, firstRoll, frame);
        } else {
            spareInLastFrame(bufferedReader, firstRoll, frame);
        }
    }

    private static void strikeInLastFrame(BufferedReader bufferedReader,
                                          int firstRoll,
                                          Frame frame) throws IOException {
        int secondRoll;
        int thirdRoll;
        System.out.println("There is an ability of the extra 2 rolls, " +
                "due to first strike in 10th frame, please roll...");

        System.out.println("\nRoll 2: ");
        secondRoll = Integer.parseInt(bufferedReader.readLine());

        System.out.println("\nRoll 3: ");
        thirdRoll = Integer.parseInt(bufferedReader.readLine());

        frame.setThirdExtraRollInTenthFrameKnockedDownPins(thirdRoll);
        frame.roll(firstRoll, secondRoll);
    }

    private static void spareInLastFrame(BufferedReader bufferedReader,
                                         int firstRoll,
                                         Frame frame) throws IOException {
        int secondRoll;
        int thirdRoll;

        System.out.println("\nRoll 2: ");
        secondRoll = Integer.parseInt(bufferedReader.readLine());

        if (((firstRoll + secondRoll) < 10)) {
            System.out.println("There is an ability of the extra 1 roll, " +
                    "due to spare roll in the 10th frame, please roll...");

            System.out.println("\nRoll 3: ");
            thirdRoll = Integer.parseInt(bufferedReader.readLine());

            frame.setThirdExtraRollInTenthFrameKnockedDownPins(thirdRoll);
        }
        frame.roll(firstRoll, secondRoll);
    }
}
