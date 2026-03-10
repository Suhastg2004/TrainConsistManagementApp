//author @ Suhas T G
<<<<<<< HEAD
//version 1.0
=======
//version 2.0
>>>>>>> feature/UC2-AddPassengerBogie

package com.trainconsistmanagementapp;

import java.util.*; 

public class Main {
	public static void main(String[] args) {
<<<<<<< HEAD
		
		//			-- UC1--
=======
	
		// UC1
>>>>>>> feature/UC2-AddPassengerBogie
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
<<<<<<< HEAD

=======
	    
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
>>>>>>> feature/UC2-AddPassengerBogie
	}
}
