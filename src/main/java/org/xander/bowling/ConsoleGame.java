package org.xander.bowling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.exit;

public class ConsoleGame {

    public static void main(String[] args) {
        System.out.println("Welcome, this is Bowling\n" +
                                      "Please enter your roll points for each frame and you will get the final score");

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        for (int frameNumber = 0; frameNumber < 10; frameNumber++) {

            int firstRoll = 0;
            int secondRoll = 0;
            int thirdRoll = 0;
            System.out.println("\nFrame # " + (frameNumber + 1));
            Frame frame = new Frame();
            System.out.println("\n### Your current score is: " + Frame.gameTotalScore + " ###");

            try {

                System.out.println("\nRoll 1: ");
                firstRoll = Integer.parseInt(bufferedReader.readLine());

                if (frameNumber == 9) {

                    if (firstRoll == 10) {
                        System.out.println("There is an ability of the extra 2 rolls, " +
                                "due to first strike roll bufferedReader the 10th frame, please roll...");
                        //Frame.gameTotalScore = 270;

                        System.out.println("\nRoll 2: ");
                        secondRoll = Integer.parseInt(bufferedReader.readLine());

                        System.out.println("\nRoll 3: ");
                        thirdRoll = Integer.parseInt(bufferedReader.readLine());

                        frame.setThirdExtraRollInTenthFrameKnockedDownPins(thirdRoll);
                        frame.roll(firstRoll, secondRoll);

                    } else if (((firstRoll + secondRoll) == 10)) {
                        System.out.println("There is an ability of the extra 1 roll, " +
                                "due to spare bufferedReader the 10th frame, please roll...");

                        System.out.println("\nRoll 2: ");
                        secondRoll = Integer.parseInt(bufferedReader.readLine());

                        if (((firstRoll + secondRoll) < 10)) {
                            System.out.println("There is an extra third roll...");

                            frame.setThirdExtraRollInTenthFrameKnockedDownPins(thirdRoll);
                        }
                        frame.roll(firstRoll, secondRoll);
                    }
                } else {

                    if (firstRoll == 10) {
                        frame.roll(firstRoll, secondRoll);
                        System.out.println("Strike !");

                        continue;
                    }

                    System.out.println("\nRoll 2: ");
                    secondRoll = Integer.parseInt(bufferedReader.readLine());

                    if (secondRoll < 0 || secondRoll > 10 || (firstRoll + secondRoll > 10)) {
                        System.out.println("You entered something wrong, please try again.");
                        exit(0);
                    }

                    if (secondRoll == 10) {
                        frame.roll(firstRoll, secondRoll);
                        System.out.println("Strike !");

                        continue;
                    }


                    frame.roll(firstRoll, secondRoll);
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
        System.out.println("\nCongratulations, you finished the game.\n" +
                "Your final score is: " + Frame.gameTotalScore);
    }
}
