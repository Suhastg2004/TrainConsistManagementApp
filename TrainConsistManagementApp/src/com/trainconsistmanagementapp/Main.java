// author @ Suhas T G
// version 19

package com.trainconsistmanagementapp;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("UC19 - Binary Search for Bogie ID");
        System.out.println("==============================================");

        // Sorted bogie IDs (precondition for binary search)
        String[] bogieIds = {"BG101", "BG102", "BG104", "BG107", "BG109", "BG115", "BG120"};

        // Optional safety sort (keeps code robust if input changes)
        Arrays.sort(bogieIds);

        String searchKey = "BG107";

        int low = 0;
        int high = bogieIds.length - 1;
        int foundIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int cmp = searchKey.compareTo(bogieIds[mid]);

            if (cmp == 0) {
                foundIndex = mid;   // Found
                break;
            } else if (cmp > 0) {
                low = mid + 1;      // Search right half
            } else {
                high = mid - 1;     // Search left half
            }
        }

        System.out.println("\nSorted Bogie IDs: " + Arrays.toString(bogieIds));
        System.out.println("Search Key: " + searchKey);

        if (foundIndex != -1) {
            System.out.println("Result: Bogie ID found at index " + foundIndex + ".");
        } else {
            System.out.println("Result: Bogie ID not found.");
        }

        System.out.println("\nUC19 binary search completed successfully...");
    }
}