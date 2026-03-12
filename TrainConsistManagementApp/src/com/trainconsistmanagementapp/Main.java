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

		// ========================= UC9 =========================
		System.out.println("===================================================");
		System.out.println("UC9 - Group Bogies by Type");
		System.out.println("===================================================\n");

		// Create list of bogies (reuse Bogie model from UC7/UC8)
		// This list includes multiple entries of the same type with different capacities
		List<Bogie> bogiesForGrouping = new ArrayList<>();
		bogiesForGrouping.add(new Bogie("Sleeper", 72));
		bogiesForGrouping.add(new Bogie("AC Chair", 56));
		bogiesForGrouping.add(new Bogie("First Class", 24));
		bogiesForGrouping.add(new Bogie("Sleeper", 70));
		bogiesForGrouping.add(new Bogie("AC Chair", 60));

		// Display input list
		System.out.println("ALL Bogies:");
		printBogies(bogiesForGrouping);
		System.out.println();

		// ---- GROUP USING COLLECTORS.GROUPINGBY ----
		// Use LinkedHashMap to preserve encounter order of keys (by first appearance)
		Map<String, List<Bogie>> groupedBogies =
				bogiesForGrouping.stream()
				.collect(Collectors.groupingBy(
						Bogie::getName,                 // classification function
						LinkedHashMap::new,             // map type to preserve order of keys
						Collectors.toList()));          // downstream collector

		// Display grouped structure
		System.out.println("Grouped Bogies:");

		// If you want to force a specific print order (to match a screenshot), define it here:
		List<String> displayOrder = Arrays.asList("First Class", "Sleeper", "AC Chair");

		// Print in preferred order if present; otherwise, fall back to map iteration order
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

		// Print any remaining groups not in preferred order list
		for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
			if (printed.contains(entry.getKey())) continue;
			System.out.println();
			System.out.println("Bogie Type: " + entry.getKey());
			for (Bogie b : entry.getValue()) {
				System.out.println("  Capacity -> " + b.getCapacity());
			}
		}

		System.out.println();
		System.out.println("UC9 grouping completed...");
	}
}