package CafeOrderSystem;
import java.time.LocalDate;

public class Tea {	/*Chapter 7: Defining and using classes – Tea class*/
    private String type, size, addon, customerName; /*Chapter 3: Primitive data types and Chapter 13: Strings*/
    private int cups;
    private double unitPrice;

    private static final String[] validTypes = {"ginger", "cardamom", "special"};
    private static final String[] validSizes = {"small", "medium"};
    private static final String[] validAddons = {"honey", "sugar", "no sugar"};

    /* Chapter 5: Constructor – validation and exception handling */
    public Tea(String type, String size, String addon, int cups, String customerName) {
        try {
            this.type = getValidType(type);
            this.size = getValidSize(size);
            this.addon = getValidAddon(addon);
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
            case "ginger": return getSizePrice(2.00, 2.50);
            case "cardamom": return getSizePrice(2.50, 3.00);
            case "special": return getSizePrice(3.00, 3.50);
            default: return 0.0;
        }
    }

    /*Chapter 5: Methods – helper for size-based pricing (Chapter 4: switch) */
    private double getSizePrice(double small, double medium) {
        switch (size.toLowerCase()) {
            case "small": return small;
            case "medium": return medium;
            default: return 0.0;
        }
    }

    private String getValidType(String input) {
        for (String validType : validTypes) {
            if (input.trim().equalsIgnoreCase(validType)) {
                return validType;
            }
        }
        throw new IllegalArgumentException("Invalid tea type.");
    }

    private String getValidSize(String input) {
        for (String validSize : validSizes) {
            if (input.trim().equalsIgnoreCase(validSize)) {
                return validSize;
            }
        }
        throw new IllegalArgumentException("Invalid size for tea.");
    }

    private String getValidAddon(String input) {
        for (String validAddon : validAddons) {
            if (input.trim().equalsIgnoreCase(validAddon)) {
                return validAddon;
            }
        }
        throw new IllegalArgumentException("Invalid addon.");
    }

    /*Chapter 5: Methods – displaying the tea order
     Chapter 11: Arrays (price breakdown)
      Chapter 14: Dates and times*/
    public void displayOrder(LocalDate date) {
        double[] prices = CafeOrderSystem.calculatePricing(unitPrice, cups, date);
        System.out.println("Order Receipt for " + customerName);
        System.out.println(type + " tea with size " + size + " x " + cups + " cups");
        System.out.println("Addon: " + addon);
        System.out.printf("Total price: $%.2f%n", prices[0]);
        System.out.printf("Seasonal discount: -$%.2f%n", prices[1]);
        System.out.printf("Discount price: -$%.2f%n", prices[2]);
        System.out.printf("Final price = Total - discount - seasonal discount + tax: $%.2f%n", prices[3]);
    }
}
