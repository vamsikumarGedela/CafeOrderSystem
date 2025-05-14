/* Vamsi Kumar Gedela  E12705869*/
package CafeOrderSystem;
import java.time.LocalDate;

public class Coffee {		/* Chapter 7: Defining and using classes – Coffee class */
    private String type, size, foamType, milkType, customerName;  /*Chapter 3: Primitive data types and Chapter 13: Strings for fields*/
    private int cups;
    private double unitPrice;

    private static final String[] validTypes = {"espresso", "latte", "cappuccino", "americano"};
    private static final String[] validSizes = {"small", "medium", "large"};
    private static final String[] validFoamTypes = {"light foam", "heavy foam", "no foam"};
    private static final String[] validMilkTypes = {"2% milk", "whole milk", "soy", "coconut", "oat milk"};

    /*Chapter 5: Methods – constructor with validation and exception handling */
    public Coffee(String type, String size, String foamType, String milkType, int cups, String customerName) {
        try {
            this.type = getValidType(type);
            this.size = getValidSize(size);
            this.foamType = getValidFoamType(foamType);
            this.milkType = getValidMilkType(milkType);
            this.cups = cups;
            this.customerName = customerName;
            this.unitPrice = calculateBasePrice();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /*Chapter 5: Methods – computing base price
     Chapter 4: Control statements – switch*/
    private double calculateBasePrice() {
        switch (type.toLowerCase()) {
            case "espresso": return getSizePrice(2.50, 3.00, 3.50);
            case "latte": return getSizePrice(3.00, 3.50, 4.00);
            case "cappuccino": return getSizePrice(3.50, 4.00, 4.50);
            case "americano": return getSizePrice(2.00, 2.50, 3.00);
            default: return 0.0;
        }
    }

    private double getSizePrice(double small, double medium, double large) {
        switch (size.toLowerCase()) {
            case "small": return small;
            case "medium": return medium;
            case "large": return large;
            default: return 0.0;
        }
    }

    /* Chapter 5: Methods – validating a String against allowed values
      Chapter 4: Control statements – loop
      Chapter 13: Working with Strings */
    private String getValidType(String input) {
        for (String validType : validTypes) {
            if (input.trim().equalsIgnoreCase(validType)) {
                return validType;
            }
        }
        throw new IllegalArgumentException("Invalid coffee type.");
    }

    private String getValidSize(String input) {
        for (String validSize : validSizes) {
            if (input.trim().equalsIgnoreCase(validSize)) {
                return validSize;
            }
        }
        throw new IllegalArgumentException("Invalid size.");
    }

    private String getValidFoamType(String input) {
        for (String validFoamType : validFoamTypes) {
            if (input.trim().equalsIgnoreCase(validFoamType)) {
                return validFoamType;
            }
        }
        throw new IllegalArgumentException("Invalid foam type.");
    }

    private String getValidMilkType(String input) {
        for (String validMilkType : validMilkTypes) {
            if (input.trim().equalsIgnoreCase(validMilkType)) {
                return validMilkType;
            }
        }
        throw new IllegalArgumentException("Invalid milk type.");
    }

    /* Chapter 5: Methods – displaying an order
     Chapter 11: Arrays (price breakdown)
      Chapter 14: Dates and times (passing date through) */
    public void displayOrder(LocalDate date) {
        double[] prices = CafeOrderSystem.calculatePricing(unitPrice, cups, date);
        System.out.println("Order Receipt for " + customerName);
        System.out.println(type + " coffee with size " + size + " x " + cups + " cups");
        System.out.println("Foam type: " + foamType);
        System.out.println("Milk type: " + milkType);
        System.out.printf("Total price: $%.2f%n", prices[0]);
        System.out.printf("Seasonal discount: -$%.2f%n", prices[1]);
        System.out.printf("Discount price: -$%.2f%n", prices[2]);
        System.out.printf("Final price = Total - discount - seasonal discount + tax: $%.2f%n", prices[3]);
    }
}
