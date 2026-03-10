//author @ Suhas T G
//version 1.0

package com.trainconsistmanagementapp;

import java.util.*; 

public class Main {
	public static void main(String[] args) {
		
		//			-- UC1--
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

	}
}
