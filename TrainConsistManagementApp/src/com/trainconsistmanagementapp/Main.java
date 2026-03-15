// author @ Suhas T G
// version 20

package com.trainconsistmanagementapp;
import java.util.Arrays;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("UC20 - Exception Handling During Search Operations");
        System.out.println("==================================================");

        List<String> bogieIds = new ArrayList<>(); // intentionally empty
        String searchKey = "BG101";

        try {
            // Fail-fast validation
            if (bogieIds.isEmpty()) {
                throw new IllegalStateException(
                    "Search operation failed: No bogies available in the train. Add bogies before searching."
                );
            }

            // Search logic (will run only if list is not empty)
            boolean found = false;
            for (String id : bogieIds) {
                if (id.equals(searchKey)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println("Bogie " + searchKey + " found.");
            } else {
                System.out.println("Bogie " + searchKey + " not found.");
            }

        } catch (IllegalStateException e) {
            System.out.println("ERROR: " + e.getMessage());
        }

        System.out.println("\nUC20 defensive validation completed...");
    }
}