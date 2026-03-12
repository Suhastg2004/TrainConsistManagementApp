// author @ Suhas T G
// version 13

package com.trainconsistmanagementapp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    // minimal model
    static class Bogie {
        final int capacity;
        Bogie(int capacity) { this.capacity = capacity; }
        int getCapacity() { return capacity; }
    }

    public static void main(String[] args) {
        System.out.println("===================================================");
        System.out.println("UC13 - Performance Comparison (Loops vs Streams)");
        System.out.println("===================================================\n");

        final int SIZE = 200_000;   // adjust if you want faster/slower runs
        final int THRESHOLD = 60;

        // simple dataset
        List<Bogie> bogies = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            // capacities cycle through 40..99
            bogies.add(new Bogie(40 + (i % 60)));
        }

        // ---- Loop timing ----
        long startLoop = System.nanoTime();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > THRESHOLD) {
                loopFiltered.add(b);
            }
        }
        long loopElapsed = System.nanoTime() - startLoop;

        // ---- Stream timing ----
        long startStream = System.nanoTime();
        List<Bogie> streamFiltered = bogies.stream()
                                           .filter(b -> b.getCapacity() > THRESHOLD)
                                           .collect(Collectors.toList());
        long streamElapsed = System.nanoTime() - startStream;

        // ---- Output (matches your desired format) ----
        System.out.println("Loop Execution Time (ns): " + loopElapsed);
        System.out.println("Stream Execution Time (ns): " + streamElapsed);
        System.out.println();
        System.out.println("UC13 performance benchmarking completed...");
    }
}