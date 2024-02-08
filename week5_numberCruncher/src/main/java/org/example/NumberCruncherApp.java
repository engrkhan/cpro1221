package org.example;

import java.util.Arrays;

public class NumberCruncherApp {
    public static void main(String[] args) {

        var numbers = new int[11];
        int total = 0;
        double median = 0.0;

        for(int i = 0; i< numbers.length; i++){
            numbers[i] = (int)(Math.random()*51);
            total += numbers[i];
        }
        Arrays.sort(numbers);
        printArray(numbers);
        System.out.printf("Total: %d\n",total);
        System.out.printf("Count: %d\n",numbers.length);
        System.out.printf("Average: %d\n",total/numbers.length);
        int count = numbers.length;
        // Median
        for(int i = 0; i< numbers.length; i++){
            if (count % 2 != 0){
                int medianIndex = count/2;
                median = numbers[medianIndex];
            }
        }
        System.out.printf("Median: %f\n",median);

    }
     public static void printArray(int[] x){
        for(int i = 0; i< x.length; i++){
            System.out.printf("Element # %d is %d\n", i, x[i]);
        }
    }
}

