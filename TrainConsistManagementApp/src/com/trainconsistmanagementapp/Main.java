// author @ Suhas T G
// version 10.0

package com.trainconsistmanagementapp;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    // ======== Model & Helpers ========
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

        Map<String, Integer> capacityMap = new HashMap<>();
        capacityMap.put("First Class", 24);
        capacityMap.put("Cargo", 120);
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 56);

        System.out.println("Bogie Capacity Details:");
        for (Map.Entry<String, Integer> e : capacityMap.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
        System.out.println();
        System.out.println("UC6 bogie-capacity mapping completed...\n");

        // ========================= UC7 =========================
        System.out.println("===================================================");
        System.out.println("UC7 - Sort Bogies by Capacity (Comparator)");
        System.out.println("===================================================\n");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        List<Bogie> bogiesForFilter = new ArrayList<>(bogies);

        System.out.println("Before Sorting:");
        printBogies(bogies);
        System.out.println();

        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("After Sorting by Capacity:");
        printBogies(bogies);
        System.out.println();
        System.out.println("UC7 sorting completed...\n");

        // ========================= UC8 =========================
        System.out.println("===================================================");
        System.out.println("UC8 - Filter Passenger Bogies Using Streams");
        System.out.println("===================================================\n");

        System.out.println("All Bogies:");
        printBogies(bogiesForFilter);
        System.out.println();

        final int CAPACITY_THRESHOLD = 60;
        List<Bogie> filtered =
                bogiesForFilter.stream()
                               .filter(b -> b.getCapacity() > CAPACITY_THRESHOLD)
                               .collect(Collectors.toList()); // use .toList() on JDK 16+

        System.out.println("Filtered Bogies (Capacity > " + CAPACITY_THRESHOLD + "):");
        printBogies(filtered);
        System.out.println();
        System.out.println("UC8 filtering completed...\n");

        // ========================= UC9 =========================
        System.out.println("===================================================");
        System.out.println("UC9 - Group Bogies by Type");
        System.out.println("===================================================\n");

        List<Bogie> bogiesForGrouping = new ArrayList<>();
        bogiesForGrouping.add(new Bogie("Sleeper", 72));
        bogiesForGrouping.add(new Bogie("AC Chair", 56));
        bogiesForGrouping.add(new Bogie("First Class", 24));
        bogiesForGrouping.add(new Bogie("Sleeper", 70));
        bogiesForGrouping.add(new Bogie("AC Chair", 60));

        System.out.println("ALL Bogies:");
        printBogies(bogiesForGrouping);
        System.out.println();

        Map<String, List<Bogie>> groupedBogies =
                bogiesForGrouping.stream()
                                 .collect(Collectors.groupingBy(
                                         Bogie::getName,
                                         LinkedHashMap::new,
                                         Collectors.toList()));

        System.out.println("Grouped Bogies:");

        List<String> displayOrder = Arrays.asList("First Class", "Sleeper", "AC Chair");
        Set<String> printed = new HashSet<>();

        for (String type : displayOrder) {
            List<Bogie> list = groupedBogies.get(type);
            if (list != null) {
                System.out.println();
                System.out.println("Bogie Type: " + type);
                for (Bogie b : list) {
                    System.out.println("  Capacity -> " + b.getCapacity());
                }
                printed.add(type);
            }
        }

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            if (printed.contains(entry.getKey())) continue;
            System.out.println();
            System.out.println("Bogie Type: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println("  Capacity -> " + b.getCapacity());
            }
        }

        System.out.println();
        System.out.println("UC9 grouping completed...\n");

        // ========================= UC10 =========================
        System.out.println("===================================================");
        System.out.println("UC10 - Count Total Seats in Train");
        System.out.println("===================================================\n");

        List<Bogie> bogiesForTotal = new ArrayList<>();
        bogiesForTotal.add(new Bogie("Sleeper", 72));
        bogiesForTotal.add(new Bogie("AC Chair", 56));
        bogiesForTotal.add(new Bogie("First Class", 24));
        bogiesForTotal.add(new Bogie("Sleeper", 70));

        System.out.println("Bogies in Train:");
        printBogies(bogiesForTotal);
        System.out.println();

        int totalCapacity = bogiesForTotal.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);

        // Alternative:
        // int totalCapacity = bogiesForTotal.stream().mapToInt(Bogie::getCapacity).sum();

        System.out.println("Total Seating Capacity of Train: " + totalCapacity + "\n");
        System.out.println("UC10 aggregation completed...");
    }
}