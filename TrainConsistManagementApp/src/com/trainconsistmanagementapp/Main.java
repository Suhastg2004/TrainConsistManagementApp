// author @ Suhas T G
// version 6.0

package com.trainconsistmanagementapp;

import java.util.*;

public class Main {
	public static void main(String[] args) {

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

		System.out.println("UC6 bogie-capacity mapping completed...");

	}
}
