// author @ Suhas T G
// version 12.0

package com.trainconsistmanagementapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    // ========================= UC12 MODEL & HELPERS =========================
    static class GoodsBogie {
        private final String type;   // e.g., Cylindrical, Open, Box
        private final String cargo;  // e.g., Petroleum, Coal, Grain

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
        

        public String getType()  { return type; }
        public String getCargo() { return cargo; }

        @Override
        public String toString() { return type + " -> " + cargo; }
    }

    private static void printGoodsBogies(List<GoodsBogie> list) {
        for (GoodsBogie b : list) {
            System.out.println(b);
        }
    }

    public static void main(String[] args) {

        // ========================= UC11 =========================
        System.out.println("===================================================");
        System.out.println("UC11 - Validate Train ID and Cargo Code");
        System.out.println("===================================================\n");

        Scanner scanner = new Scanner(System.in);

        // ---- Accept input ----
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine().trim();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine().trim();

        // ---- Define Regex Rules ----
        // Train ID: TRN- followed by exactly 4 digits
        Pattern trainIdPattern = Pattern.compile("^TRN-\\d{4}$");

        // Cargo Code: PET- followed by exactly 2 uppercase letters
        Pattern cargoCodePattern = Pattern.compile("^PET-[A-Z]{2}$");

        // ---- Create Matchers and Validate ----
        Matcher trainMatcher = trainIdPattern.matcher(trainId);
        boolean isTrainIdValid = trainMatcher.matches();

        // Normalize cargo to uppercase for case-insensitive user typing
        Matcher cargoMatcher = cargoCodePattern.matcher(cargoCode.toUpperCase());
        boolean isCargoValid = cargoMatcher.matches();

        // ---- Display Results ----
        System.out.println("\nValidation Results:");
        System.out.println("Train ID Entered : " + trainId);
        System.out.println("Cargo Code Entered: " + cargoCode);
        System.out.println("Train ID Valid    : " + isTrainIdValid);
        System.out.println("Cargo Code Valid  : " + isCargoValid);
        System.out.println();

        if (!isTrainIdValid) {
            System.out.println("Hint: Train ID must match 'TRN-1234' (TRN- and exactly 4 digits).");
        }
        if (!isCargoValid) {
            System.out.println("Hint: Cargo Code must match 'PET-AB' (PET- and exactly 2 uppercase letters).");
        }

        System.out.println("\nUC11 validation completed...\n");

        // ========================= UC12 =========================
        System.out.println("===================================================");
        System.out.println("UC12 - Safety Compliance Check for Goods Bogies");
        System.out.println("===================================================\n");

        // Sample data containing one violation to demonstrate rule behavior
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum")); // valid
        goodsBogies.add(new GoodsBogie("Open",        "Coal"));      // allowed
        goodsBogies.add(new GoodsBogie("Box",         "Grain"));     // allowed
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal"));      // INVALID per rule

        System.out.println("Goods Bogies in Train:");
        printGoodsBogies(goodsBogies);
        System.out.println();

        // ---- Safety Rule as a Predicate ----
        // Business rule: Cylindrical -> only Petroleum allowed; others allowed.
        Predicate<GoodsBogie> safetyRule = b -> {
            boolean isCylindrical = "Cylindrical".equalsIgnoreCase(b.getType());
            return !isCylindrical || "Petroleum".equalsIgnoreCase(b.getCargo());
        };

        // ---- Validate with Streams (allMatch short-circuits on first failure) ----
        boolean isSafe = goodsBogies.stream().allMatch(safetyRule);

        // ---- Result ----
        System.out.println("Safety Compliance Status: " + isSafe);
        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
            // Optional: list violations for clarity / debugging
            // goodsBogies.stream()
            //           .filter(safetyRule.negate())
            //           .forEach(b -> System.out.println("Violation -> " + b));
        }

        System.out.println("\nUC12 safety validation completed...");

        scanner.close();
    }
}