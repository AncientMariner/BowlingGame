package org.xander.bowling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.exit;

public class RealGame {

    public static void main( String[] args )
    {
        System.out.println( "Welcome, this is Bowling\n" +
                "Please enter your roll points for each frame and you will get the final score" );


        InputStreamReader converter = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(converter);



        for(int i = 0; i < 10; i++) {

            int firstRoll = 0;
            int secondRoll = 0;
            System.out.println("\nFrame # " + (i+1));
            Game frame = new Game();
            System.out.println("\n### Your current score is: " + Game.totalScore + " ###");

            try {

                System.out.println("\nRoll 1: ");
                firstRoll =  Integer.parseInt(in.readLine());

                if (firstRoll < 0 || firstRoll > 10) {
                    System.out.println("You entered something wrong, please try again.");
                    exit(0);
                }

                if (firstRoll == 10 ) {
                    frame.roll(firstRoll, secondRoll);
                    System.out.println("Strike !");

                    continue;
                }

                System.out.println("\nRoll 2: ");
                secondRoll =  Integer.parseInt(in.readLine());

                if (secondRoll < 0 || secondRoll > 10 || (firstRoll + secondRoll > 10)) {
                    System.out.println("You entered something wrong, please try again.");
                    exit(0);
                }

                if (secondRoll == 10) {
                    frame.roll(firstRoll, secondRoll);
                    System.out.println("Strike !");

                    continue;
                }

                if(i == 9 && firstRoll + secondRoll == 10) {
                    System.out.println("There is an ability of the extra roll, " +
                            "due to spare roll in the 10th frame, please roll...");

                    System.out.println("\nRoll 3: ");
                    int thirdRoll =  Integer.parseInt(in.readLine());
                    frame.setThirdExtraRollDueToSpare(thirdRoll);

                    frame.roll(firstRoll, secondRoll);

                    continue;
                }

                frame.roll(firstRoll, secondRoll);


            } catch (IOException e){
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
                                    "Your final score is: " + Game.totalScore);
    }
}
