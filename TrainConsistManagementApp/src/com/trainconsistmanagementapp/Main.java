//author @ Suhas T G
//version 2.0

package com.trainconsistmanagementapp;

import java.util.*; 

public class Main {
	public static void main(String[] args) {
	
		// UC1
	    System.out.println("===================================================");
	    System.out.println(" === Train Consist Management App === ");
	    System.out.println("===================================================\n");

	    // Create a dynamic list to store train bogies
	    List<String> trainConsist = new ArrayList<>();
		
	    // Display initial consist information
	    System.out.println("Train initialized successfully...");
	    System.out.println("Initial Bogie Count : " + trainConsist.size());
	    System.out.println("Current Train Consist : " + trainConsist);
	    System.out.println("\nSystem ready for operations...");
	    
	    // UC2
	    // Banner
         System.out.println("===================================================");
         System.out.println("UC2 - Add Passenger Bogies to Train");
         System.out.println("===================================================\n");

         // Create an ArrayList to hold passenger bogies
         List<String> passengerBogies = new ArrayList<>();


         // add() attaches a new bogie to the train
         passengerBogies.add("Sleeper");
         passengerBogies.add("AC Chair");
         passengerBogies.add("First Class");

         System.out.println("After Adding Bogies:");
         System.out.println("Passenger Bogies : " + passengerBogies + "\n");

         // remove(Object) removes the first matching element if present
         System.out.println("After Removing 'AC Chair':");
         passengerBogies.remove("AC Chair");
         System.out.println("Passenger Bogies : " + passengerBogies + "\n");

         // contains() returns true if the element exists in the list
         System.out.println("Checking if 'Sleeper' exists:");
         System.out.println("Contains Sleeper? : " + passengerBogies.contains("Sleeper") + "\n");

         System.out.println("Final Train Passenger Consist:");
         System.out.println(passengerBogies + "\n");
         

         System.out.println("===================================================");
         System.out.println("UC3 - Track Unique Bogie IDs");
         System.out.println("===================================================\n");

         // HashSet stores only unique values (duplicates are ignored)
         Set<String> bogies = new HashSet<>();

         // add() inserts bogie IDs; duplicates will be ignored
         bogies.add("BG101");
         bogies.add("BG102");
         bogies.add("BG103");
         bogies.add("BG101"); // Duplicate entry
         bogies.add("BG102"); // Duplicate entry
         bogies.add("BG104");

         System.out.println("Bogie IDs After Insertion:");
         System.out.println(bogies + "\n");

         System.out.println("Note:");
         System.out.println("Duplicates are automatically ignored by HashSet.\n");

	}
}
