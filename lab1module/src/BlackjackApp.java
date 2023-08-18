// D:\Dropbox\[]-RDP Courses 2023\CPRO 1221 Programming Java SE\Instructor Material\
// MurachsJava_6E_forInstructors\java\instructors\case_studies\eclipse\blackjack_sec1a_sol
import java.util.Scanner;

public class BlackjackApp {

    public static void main(String[] args) {
        System.out.println("BLACKJACK!");
        System.out.println("Blackjack payout is 3:2");

        Scanner sc = new Scanner(System.in);
        double totalMoney = 0.0;
        double min = 5.0;
        double maxBet = 1_000.0;
        double maxMoney = 10_000.0;

        // get starting totalMoney amount
        while(true) {
            System.out.print("\nStarting money: ");
            totalMoney = Double.parseDouble(sc.nextLine());

            if(totalMoney < min || totalMoney > maxMoney) {
                System.out.printf(
                        "Starting money must be between $%,.2f and $%,.2f%n", min, maxMoney);
            } else {
                break;   // end loop
            }
        }

        // play
        String choice = "y";
        while(choice.equalsIgnoreCase("y") && totalMoney > min) {
            System.out.print("\nBet amount: ");
            double bet = Double.parseDouble(sc.nextLine());

            if(bet < min || bet > maxBet || bet > totalMoney) {
                String msg = "Bet must be between $%,.2f and $%,.2f%n";
                if (maxBet > totalMoney) {
                    System.out.printf(msg, min, totalMoney);
                } else {
                    System.out.printf(msg, min, maxBet);
                }
            } else {
                //get random number and decide what happens
                int randInt = (int)(Math.random() * 100);
                if(randInt < 49) {
                    System.out.println("You lost.");
                    totalMoney -= bet;
                    if (totalMoney < min) {
                        System.out.printf(
                                "Dang! You're below the minumum bet of $%.2f!%n", min);
                    }
                } else if(randInt < 86) {
                    System.out.println("You won.");
                    totalMoney += bet;
                } else if(randInt < 95) {
                    System.out.println("You pushed.");
                } else {
                    System.out.println("You got a Blackjack!");
                    totalMoney += (bet * 1.5);
                }
                System.out.printf("Total money: $%,.2f%n%n", totalMoney);

                if (totalMoney > min) {
                    System.out.print("Play again? (y/n): ");
                    choice = sc.nextLine();
                }
            }  // end of if statement
        }  // end of while loop

        System.out.println("\nBye!");
    }
}

