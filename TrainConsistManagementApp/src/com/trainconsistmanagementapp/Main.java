// author @ Suhas T G
// version 8.0

package com.trainconsistmanagementapp;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    // ======== Helpers / Model ========

    // Simple model for a passenger bogie
    static class Bogie {
        private final String name;
        private final int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() { return name; }
        public int getCapacity() { return capacity; }
    }

    // Pretty printer for the bogie list
    static void printBogies(List<Bogie> list) {
        for (Bogie b : list) {
            System.out.println(b.getName() + " -> " + b.getCapacity());
        }
    }

    public static void main(String[] args) {

        // ========================= UC6 =========================
        System.out.println("===================================================");
        System.out.println("UC6 - Map Bogie to Capacity (HashMap)");
        System.out.println("===================================================\n");

        // HashMap stores data in key -> value format (bogie -> capacity)
        Map<String, Integer> capacityMap = new HashMap<>();

        // ---- Insert bogie capacities ----
        capacityMap.put("First Class", 24);
        capacityMap.put("Cargo", 120);
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 56);

        // ---- Iterate using entrySet() and display ----
        System.out.println("Bogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();

        System.out.println("UC6 bogie-capacity mapping completed...\n");

        // ========================= UC7 =========================
        System.out.println("===================================================");
        System.out.println("UC7 - Sort Bogies by Capacity (Comparator)");
        System.out.println("===================================================\n");

        // Create list of passenger bogies (objects with name + capacity)
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        // Keep a copy in original insertion order for UC8's "All Bogies" view
        List<Bogie> bogiesForFilter = new ArrayList<>(bogies);

        // ---- Before sorting ----
        System.out.println("Before Sorting:");
        printBogies(bogies);
        System.out.println();

        // ---- Sort by capacity (ascending) using Comparator ----
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        // ---- After sorting ----
        System.out.println("After Sorting by Capacity:");
        printBogies(bogies);
        System.out.println();

        System.out.println("UC7 sorting completed...\n");

        // ========================= UC8 =========================
        System.out.println("===================================================");
        System.out.println("UC8 - Filter Passenger Bogies Using Streams");
        System.out.println("===================================================\n");

        // Show all bogies (original insertion order from UC7)
        System.out.println("All Bogies:");
        printBogies(bogiesForFilter);
        System.out.println();

        // ---- Stream filter: capacity > 60 ----
        final int CAPACITY_THRESHOLD = 60;

        // Convert to stream, filter, and collect to a new list
        List<Bogie> filtered =
            bogiesForFilter.stream()
                           .filter(b -> b.getCapacity() > CAPACITY_THRESHOLD)
                           .collect(Collectors.toList()); // use toList() if you're on JDK 16+

        System.out.println("Filtered Bogies (Capacity > " + CAPACITY_THRESHOLD + "):");
        printBogies(filtered);
        System.out.println();

        System.out.println("UC8 filtering completed...");
    }
}