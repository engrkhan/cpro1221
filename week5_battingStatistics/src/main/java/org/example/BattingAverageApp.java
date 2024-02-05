package org.example;

import java.text.NumberFormat;

public class BattingAverageApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the Batting Average Calculator\n");

        String anotherPlayer = "y";
        while (anotherPlayer.equals("y")) {

            int atBats = Console.getInt("Enter number of times at bat: ",
                    0, 21);
            System.out.println();

            System.out.println("0 = out, 1 = single, 2 = double, 3 = triple, 4 = home run");

            int[] results = new int[atBats];    // create the results array
            for (int i = 0; i < atBats; i++) {
                int atBat = i + 1;
                results[i] = Console.getInt("Result for at-bat " +
                        atBat + ": ", -1, 5);
            }
            System.out.println();

            // process results
            int successfulAtBats = 0;
            int totalBases = 0;
            for (int result : results) {
                if (result > 0) {
                    successfulAtBats++;
                }
                totalBases += result;
            }

            // calcualte averages
            // NOTE: cast one operand to double to avoid integer result
            double battingAverage = successfulAtBats / (double) atBats;
            double sluggingPercent = totalBases / (double) atBats;

            // format results
            NumberFormat number = NumberFormat.getNumberInstance();
            number.setMinimumFractionDigits(3);
            number.setMaximumFractionDigits(3);
            System.out.println("Batting average: " +
                    number.format(battingAverage));
            System.out.println("Slugging percent: " +
                    number.format(sluggingPercent) + "\n");

            anotherPlayer = Console.getString("Another player? (y/n): ");

            System.out.println();
        }
        System.out.println("Bye!");
    }
}