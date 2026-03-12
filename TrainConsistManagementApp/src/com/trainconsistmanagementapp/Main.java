// author @ Suhas T G
// version 14

package com.trainconsistmanagementapp;

import java.util.ArrayList;
import java.util.List;

// Custom checked exception
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

public class Main {

    static class PassengerBogie {
        private String name;
        private int capacity;

        // Constructor enforces fail-fast validation
        public PassengerBogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException(
                    "Invalid capacity for bogie '" + name + "': " + capacity + ". Capacity must be > 0."
                );
            }
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("UC14 - Handle Invalid Bogie Capacity (Custom Exception)");
        System.out.println("==============================================");

        List<PassengerBogie> trainConsist = new ArrayList<>();

        // Try creating bogies (both valid and invalid)
        try {
            trainConsist.add(new PassengerBogie("Sleeper", 72));
            System.out.println("Added: Sleeper");
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            trainConsist.add(new PassengerBogie("AC Chair", 0)); // invalid
            System.out.println("Added: AC Chair");
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            trainConsist.add(new PassengerBogie("First Class", -10)); // invalid
            System.out.println("Added: First Class");
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            trainConsist.add(new PassengerBogie("Second Sitting", 108));
            System.out.println("Added: Second Sitting");
        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nFinal Valid Train Consist:");
        trainConsist.forEach(System.out::println);

        System.out.println("\nUC14 validation completed...");
    }
}