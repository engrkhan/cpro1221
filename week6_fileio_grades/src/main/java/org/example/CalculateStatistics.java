package org.example;

import java.io.*;
import java.util.*;

public class CalculateStatistics {
    public static void main(String[] args) throws Exception {
        List<Integer> grades = new ArrayList<>();
        try (Scanner input = new Scanner(new File("C:\\Users\\Tufail\\IdeaProjects\\cpro1221Winter2024\\week6_fileio_grades\\src\\main\\java\\org\\example\\numbercruncher.txt"))) {
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] parts = line.split(", ");
                int grade = Integer.parseInt(parts[1].replace("%", ""));
                grades.add(grade);
            }
        }

        Collections.sort(grades); // Sort for median calculation

        double average = calculateAverage(grades);
        double median = calculateMedian(grades);
        int mode = calculateMode(grades);
        double stdDeviation = calculateStandardDeviation(grades, average);

        // Write statistics to another file
        try (PrintWriter output = new PrintWriter(new File("C:\\Users\\Tufail\\IdeaProjects\\cpro1221Winter2024\\week6_fileio_grades\\src\\main\\java\\org\\example\\statistics.txt"))) {
            output.println("Average: " + average);
            output.println("Median: " + median);
            output.println("Mode: " + mode);
            output.println("Standard Deviation: " + stdDeviation);
        }
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

    public static double calculateMedian(List<Integer> grades) {
        if (grades.isEmpty()) return 0.0;
        int middle = grades.size() / 2;
        if (grades.size() % 2 == 1) {
            return grades.get(middle);
        } else {
            return (grades.get(middle - 1) + grades.get(middle)) / 2.0;
        }
    }

    public static int calculateMode(List<Integer> grades) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer grade : grades) {
            frequencyMap.put(grade, frequencyMap.getOrDefault(grade, 0) + 1);
        }

        int maxFrequency = Collections.max(frequencyMap.values());
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                return entry.getKey();
            }
        }
        return -1; // In case there's no mode
    }

    public static double calculateStandardDeviation(List<Integer> grades, double average) {
        double sumDiffsSquared = 0.0;
        for (Integer grade : grades) {
            double diff = grade - average;
            sumDiffsSquared += diff * diff;
        }
        double variance = sumDiffsSquared / grades.size();
        return Math.sqrt(variance);
    }

}
