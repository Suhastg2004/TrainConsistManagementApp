// author @ Suhas T G
// version 18

package com.trainconsistmanagementapp;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("UC18 - Linear Search for Bogie ID");
        System.out.println("==============================================");

        // Unsorted bogie IDs
        String[] bogieIds = {"BG104", "BG101", "BG109", "BG102", "BG107"};

        // Search key (you can change this value)
        String searchKey = "BG102";

        boolean found = false;
        int foundIndex = -1;

        // Linear Search
        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(searchKey)) {
                found = true;
                foundIndex = i;
                break; // Early termination
            }
        }

        System.out.print("\nBogie IDs: [");
        for (int i = 0; i < bogieIds.length; i++) {
            System.out.print(bogieIds[i]);
            if (i < bogieIds.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        System.out.println("Search Key: " + searchKey);

        if (found) {
            System.out.println("Result: Bogie ID found at index " + foundIndex + ".");
        } else {
            System.out.println("Result: Bogie ID not found.");
        }

        System.out.println("\nUC18 linear search completed successfully...");
    }
}