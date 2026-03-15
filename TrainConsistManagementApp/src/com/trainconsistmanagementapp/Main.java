// author @ Suhas T G
// version 17

package com.trainconsistmanagementapp;


import java.util.Arrays;

public class Main{
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("UC17 - Sort Bogie Names Using Arrays.sort()");
        System.out.println("==============================================");

        // Unsorted bogie type names
        String[] bogieTypes = {"Sleeper", "Cargo", "First Class", "AC Chair", "Guard"};

        System.out.println("\nBefore Sorting:");
        System.out.println(Arrays.toString(bogieTypes));

        // Built-in optimized sorting (alphabetical)
        Arrays.sort(bogieTypes);

        System.out.println("\nAfter Sorting (Alphabetical):");
        System.out.println(Arrays.toString(bogieTypes));

        System.out.println("\nUC17 sorting completed successfully...");
    }
}