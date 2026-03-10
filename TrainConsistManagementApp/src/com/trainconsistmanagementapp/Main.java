// author @ Suhas T G
// version 7.0

package com.trainconsistmanagementapp;

import java.util.*;

public class Main {

	//Helpers for UC7 (inside the same class)
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

		System.out.println("UC7 sorting completed...");
	}
}