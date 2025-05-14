package CafeOrderSystem;
import java.time.LocalDate;

public class MilkShake {	/*Chapter 7: Defining and using classes – MilkShake class*/
    private String flavor, size, customerName; /*chapter 3: Primitive data types and Chapter 13: Strings*/
    private int cups;
    private boolean extraCream;
    private double unitPrice;

    private static final String[] validFlavors = {"vanilla", "chocolate", "strawberry", "peach", "pumpkin"};
    private static final String[] validSizes = {"medium", "large"};

    /* Chapter 5: Constructor – validation and exception handling */
    public MilkShake(String flavor, String size, int cups, String customerName, boolean extraCream) {
        try {
            this.flavor = getValidFlavor(flavor);
            this.size = getValidSize(size);
            this.cups = cups;
            this.customerName = customerName;
            this.extraCream = extraCream;
            this.unitPrice = calculateBasePrice();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /*Chapter 5: Methods – computing base price with extra cream option
     Chapter 4: Control statements – switch*/
    private double calculateBasePrice() {
        double basePrice;
        switch (flavor.toLowerCase()) {
            case "vanilla": basePrice = getSizePrice(3.00, 3.50); break;
            case "chocolate": basePrice = getSizePrice(3.50, 4.00); break;
            case "strawberry": basePrice = getSizePrice(3.75, 4.25); break;
            case "peach": basePrice = getSizePrice(4.00, 4.50); break;
            case "pumpkin": basePrice = getSizePrice(4.50, 5.00); break;
            default: basePrice = 0.0;
        }
        return extraCream ? basePrice + 0.50 : basePrice;
    }

    /* Chapter 5: Methods – helper for size-based pricing (Chapter 4: switch) */
    private double getSizePrice(double medium, double large) {
        switch (size.toLowerCase()) {
            case "medium": return medium;
            case "large": return large;
            default: return 0.0;
        }
    }

    private String getValidFlavor(String input) {
        for (String validFlavor : validFlavors) {
            if (input.trim().equalsIgnoreCase(validFlavor)) {
                return validFlavor;
            }
        }
        throw new IllegalArgumentException("Invalid flavor type.");
    }

    private String getValidSize(String input) {
        for (String validSize : validSizes) {
            if (input.trim().equalsIgnoreCase(validSize)) {
                return validSize;
            }
        }
        throw new IllegalArgumentException("Invalid size for milkshake.");
    }

    /* Chapter 5: Methods – displaying the milkshake order
     Chapter 11: Arrays (price breakdown)
     Chapter 14: Dates and times */
    public void displayOrder(LocalDate date) {
        double[] prices = CafeOrderSystem.calculatePricing(unitPrice, cups, date);
        System.out.println("Order Receipt for " + customerName);
        System.out.println(flavor + " milkshake with size " + size + " x " + cups + " cups");
        System.out.println("Extra cream: " + (extraCream ? "Yes" : "No"));
        System.out.printf("Total price: $%.2f%n", prices[0]);
        System.out.printf("Seasonal discount: -$%.2f%n", prices[1]);
        System.out.printf("Discount price: -$%.2f%n", prices[2]);
        System.out.printf("Final price = Total - discount - seasonal discount + tax: $%.2f%n", prices[3]);
    }
}
