package org.example;

import java.io.PrintWriter;
import java.util.Random;

public class WriteDataWithAutoClose {
    public static void main(String[] args) throws Exception {
        java.io.File file = new java.io.File("C:\\Users\\Tufail\\IdeaProjects\\cpro1221Winter2024\\week6_fileio_grades\\src\\main\\java\\org\\example\\numbercruncher.txt");
        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(0);
        }

        try (PrintWriter output = new PrintWriter(file)) {
            // Generate and write student data
            Random random = new Random();
            for (int i = 1; i <= 10; i++) {
                String studentName = "Student " + i;
                int grade = random.nextInt(101); // Grades from 0 to 100
                output.printf("%s, %d%%\n", studentName, grade);
            }
        }
    }
}