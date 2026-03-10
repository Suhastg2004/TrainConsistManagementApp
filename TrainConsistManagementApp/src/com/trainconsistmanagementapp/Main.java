// author @ Suhas T G
// version 5.0

package com.trainconsistmanagementapp;

import java.util.*;

public class Main {
	public static void main(String[] args) {


		// ========================= UC5 =========================
		System.out.println("===================================================");
		System.out.println("UC5 - Preserve Insertion Order of Bogies");
		System.out.println("===================================================\n");

		Set<String> formation = new LinkedHashSet<>();
		formation.add("Engine");
		formation.add("Sleeper");
		formation.add("Cargo");
		formation.add("Guard");
		formation.add("Sleeper"); // duplicate; ignored

		System.out.println("Final Train Formation:");
		System.out.println(formation + "\n");

		System.out.println("Note:");
		System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.\n");

	}
}
