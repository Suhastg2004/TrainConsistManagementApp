// author @ Suhas T G
// version 16

package com.trainconsistmanagementapp;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================================");
        System.out.println("UC16 - Sort Passenger Bogies by Capacity (Bubble Sort)");
        System.out.println("==========================================================");

        // Passenger bogie capacities (unsorted)
        int[] capacities = {72, 24, 56, 108, 48, 80};

        System.out.print("\nBefore Sorting: ");
        printArray(capacities);

        // Bubble Sort (ascending)
        int n = capacities.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    // swap adjacent elements
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                    swapped = true;
                }
            }

            // optimization: stop early if already sorted
            if (!swapped) {
                break;
            }
        }

        System.out.print("After Sorting : ");
        printArray(capacities);

        System.out.println("\nUC16 bubble sort completed successfully...");
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}