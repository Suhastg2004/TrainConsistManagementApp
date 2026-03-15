// author @ Suhas T G
// version 15

package com.trainconsistmanagementapp;

public class Main {

    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) { super(message); }
    }

    // ---- Goods Bogie model ----
    static class GoodsBogie {
        private final String shape; // e.g., Cylindrical, Rectangular
        private String cargo;       // e.g., Petroleum, Coal, Grain

        GoodsBogie(String shape) { this.shape = shape; }

        public String getShape() { return shape; }
        public String getCargo() { return cargo; }

        void assignCargo(String cargo) {
            if ("Cylindrical".equalsIgnoreCase(shape)) {
                if (!"Petroleum".equalsIgnoreCase(cargo)) {
                    throw new CargoSafetyException("Cylindrical bogie can carry only Petroleum.");
                }
            } else if ("Rectangular".equalsIgnoreCase(shape)) {
                if ("Petroleum".equalsIgnoreCase(cargo)) {
                    throw new CargoSafetyException("Rectangular bogie cannot carry Petroleum.");
                }
            }
            this.cargo = cargo; // assignment happens only if rules pass
        }
    }

    public static void main(String[] args) {

        System.out.println("===================================================");
        System.out.println("UC15 - Safe Cargo Assignment");
        System.out.println("===================================================\n");

        // ---- Case 1: Valid assignment (Cylindrical -> Petroleum) ----
        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        try {
            cylindrical.assignCargo("Petroleum"); // valid
            System.out.println("Cargo assigned successfully -> " + cylindrical.getCargo());
        } catch (CargoSafetyException ex) {
            System.out.println("Error: Unsafe cargo assignment!");
        } finally {
            System.out.println("Cargo validation completed for " + cylindrical.getShape() + " bogie\n");
        }

        // ---- Case 2: Invalid assignment (Rectangular -> Petroleum) ----
        GoodsBogie rectangular = new GoodsBogie("Rectangular");
        try {
            rectangular.assignCargo("Petroleum"); // invalid to trigger the error
            System.out.println("Cargo assigned successfully -> " + rectangular.getCargo());
        } catch (CargoSafetyException ex) {
            System.out.println("Error: Unsafe cargo assignment!");
        } finally {
            System.out.println("Cargo validation completed for " + rectangular.getShape() + " bogie\n");
        }

        System.out.println("UC15 runtime handling completed...");
    }
}
