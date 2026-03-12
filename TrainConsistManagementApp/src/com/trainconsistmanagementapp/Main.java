// author @ Suhas T G
// version 11.0

package com.trainconsistmanagementapp;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        System.out.println("===================================================");
        System.out.println("UC11 - Validate Train ID and Cargo Code");
        System.out.println("===================================================\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine().trim();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine().trim();

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

        System.out.println("\nUC11 validation completed...");
    }
}