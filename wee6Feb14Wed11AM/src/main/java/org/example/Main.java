package org.example;

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws java.io.IOException {
        java.io.File file = new java.io.File("C:\\Users\\Tufail\\IdeaProjects\\cpro1221Winter2024\\wee6Feb14Wed11AM\\src\\main\\java\\org\\example\\scoresthree.txt");
        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(0);
        }
        // Code from Hint 1
        try (PrintWriter output = new PrintWriter(file)) {
            // Generate and write student data
            Random random = new Random();
            for (int i = 1; i <= 10; i++) {
                String studentName = "Student " + i;
                int grade = random.nextInt(101); // Grades from 0 to 100
                output.printf("%s, %d%%\n", studentName, grade);
            }
            // Close the file
            output.close();
        }


        // Code from Hint 2
        List<Integer> grades = new ArrayList<>();
        try (Scanner input = new Scanner(new File("C:\\Users\\Tufail\\IdeaProjects\\cpro1221Winter2024\\wee6Feb14Wed11AM\\src\\main\\java\\org\\example\\scoresthree.txt"))) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] parts = line.split(", ");
                int grade = Integer.parseInt(parts[1].replace("%", ""));
                grades.add(grade);
            }
            // Close the file
            input.close();
        }

        Collections.sort(grades); // Sort for median calculation

        double average = calculateAverage(grades);

        System.out.println("Average is: "+average);
    }
    // Implement calculation methods here
    public static double calculateAverage(List<Integer> grades) {
        if (grades.isEmpty()) return 0.0;
        double sum = 0;
        for (Integer grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}
