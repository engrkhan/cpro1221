package org.example;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws java.io.IOException {
        java.io.File file = new java.io.File("C:\\Users\\Tufail\\IdeaProjects\\cpro1221Winter2024\\week6_fileio_writeData\\src\\main\\java\\org\\example\\scorestwo.txt");
        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(0);
        }

        // Create a file
        java.io.PrintWriter output = new java.io.PrintWriter(file);

        // Write formatted output to the file
        output.print("Abc d efg ");
        output.println(90);

        // Close the file
        output.close();

        // Create a Scanner for the file
        Scanner input = new Scanner(file);

        // Read data from a file
        while (input.hasNext()) {
            String firstName = input.next();
            String mi = input.next();
            String lastName = input.next();
            int score = input.nextInt();
            System.out.println(
                    firstName + " " + mi + " " + lastName + " " + score);
        }

        // Close the file
        input.close();
    }
}