import java.util.Scanner;

public class StackCalculatorApp {

    static Scanner sc = new Scanner(System.in);
    static StackCalculator calc = new StackCalculator();

    public static void main(String[] args) {

        System.out.println("Welcome to the Stack Calculator.\n");
        System.out.println("Commands: push n, add, sub, mult, div, clear, or quit.");

        String command;
        String input;
        double value;

        // process the user's commands until done
        displayPrompt();
        while (true) {
            input = sc.nextLine();
            command = input.split(" ")[0];

            if (command.equalsIgnoreCase("push")) {
                try {
                    value = Double.parseDouble(input.split(" ")[1]);
                    calc.push(value);
                } catch(Exception e) {
                    System.out.println("Missing or invalid push value");
                    displayPrompt();
                }
                listValues();
                displayPrompt();
            } else if (command.equalsIgnoreCase("add") ||
                    command.equalsIgnoreCase("sub") ||
                    command.equalsIgnoreCase("mult") ||
                    command.equalsIgnoreCase("div")) {
                performCalculation(command);
            } else if (command.equalsIgnoreCase("clear")) {
                calc.clear();
                listValues();
                displayPrompt();
            } else if (command.equalsIgnoreCase("quit")) {
                break;
            } else {
                System.out.println("Unrecognized command.\n");
                displayPrompt();
            }
        }
        System.out.println("\nThanks for using the Stack Calculator.\n");
    }

    public static void displayPrompt() {
        System.out.print("\nstack> ");
    }

    public static void listValues() {
        Double[] values = calc.getValues();
        if (calc.size() > 0) {
            for (Double d : values) {
                System.out.println(d);
            }
        } else {
            System.out.println("empty");
        }
    }

    public static void performCalculation(String command) {
        if (calc.size() < 2) {
            System.out.println("Not enough data on the stack");
            listValues();
        } else {
            if (command.equals("add")) {
                calc.add();
            } else if (command.equals("sub")) {
                calc.subtract();
            } else if (command.equals("mult")) {
                calc.multiply();
            } else if (command.equals("div")) {
                calc.divide();
            }
            listValues();
        }
        displayPrompt();
    }
}