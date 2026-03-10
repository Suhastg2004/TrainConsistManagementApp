// author @ Suhas T G
// version 4.0

package com.trainconsistmanagementapp;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // ========================= UC4 =========================
        System.out.println("===================================================");
        System.out.println("UC4 - Maintain Ordered Bogie Consist");
        System.out.println("===================================================\n");

        // Create a LinkedList
        // LinkedList maintains insertion order and allows fast inserts/removals
        LinkedList<String> orderedConsist = new LinkedList<>();

        // Build initial train sequence (head .. tail)
        orderedConsist.addLast("Engine");
        orderedConsist.addLast("Sleeper");
        orderedConsist.addLast("AC");
        orderedConsist.addLast("Cargo");
        orderedConsist.addLast("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(orderedConsist + "\n");

        // Insert "Pantry Car" at position 2 (0-based: Engine=0, Sleeper=1)
        orderedConsist.add(2, "Pantry Car");

        System.out.println("After Inserting 'Pantry Car' at position 2:");
        System.out.println(orderedConsist + "\n");

        // Remove from head and tail
        orderedConsist.removeFirst(); // remove Engine
        orderedConsist.removeLast();  // remove Guard

        System.out.println("After Removing First and Last Bogie:");
        System.out.println(orderedConsist + "\n");

        System.out.println("UC4 ordered consist operations completed...");
    }
}
