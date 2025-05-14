package CafeOrderSystem;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class CafeOrderSystem {		
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        LocalDate today = LocalDate.now();			
        DayOfWeek dayOfWeek = today.getDayOfWeek();

        System.out.println("Date: " + today);
        if (dayOfWeek == DayOfWeek.THURSDAY) {     /* Chapter 4: Control statements – if/else */   
            System.out.println("Sorry, we are closed on Thursday's.");
            return;
        } else {
            System.out.println("Welcome to the Vamsi Cafe!\n");
            System.out.println("We are open from 8am to 9:30pm.\n");
        }

        String[] drinkTypes = {"coffee", "milkshake", "tea"};  /* Chapter 11: Working with arrays for menu options */
        String[] sizes = {"small", "medium", "large"};
        String[] foamTypes = {"light foam", "heavy foam", "no foam"};
        String[] milkTypes = {"2% milk", "whole milk", "soy", "coconut", "oat milk"};
        String[] flavors = {"vanilla", "chocolate", "strawberry", "peach", "pumpkin"};
        String[] teaTypes = {"ginger", "cardamom", "special"};
        String[] addons = {"honey", "sugar", "no sugar"};

        try {
            System.out.print("Enter drink type (coffee/milkshake/tea): ");   /* Chapter 5: try and catch */
            String drinkType = getValidInput(scanner, drinkTypes);

            switch (drinkType.toLowerCase()) {
                case "coffee":
                    System.out.print("Enter type (Espresso/Latte/Cappuccino/Americano): ");
                    String coffeeType = getValidInput(scanner, new String[]{"espresso", "latte", "cappuccino", "americano"});
                    System.out.print("Enter size (small/medium/large): ");
                    String size = getValidInput(scanner, sizes);
                    System.out.print("Enter foam type (light foam/heavy foam/no foam): ");
                    String foam = getValidInput(scanner, foamTypes);
                    System.out.print("Enter Milk Type (2% milk, whole milk, soy, coconut, oat milk): ");
                    String milk = getValidInput(scanner, milkTypes);

                    System.out.print("How many cups do you need? ");
                    int coffeeCups = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter the customer name: ");
                    String coffeeName = scanner.nextLine();

                    Coffee coffee = new Coffee(coffeeType, size, foam, milk, coffeeCups, coffeeName);
                    coffee.displayOrder(today);
                    break;

                case "milkshake":
                    System.out.print("Enter flavor (vanilla/chocolate/strawberry/peach/pumpkin): ");
                    String flavor = getValidInput(scanner, flavors);
                    System.out.print("Enter size (Medium/Large): ");
                    String shakeSize = getValidInput(scanner, new String[]{"medium", "large"});

                    System.out.print("Do You Like to Add Extra Cream (Yes/No): ");
                    boolean extraCream = scanner.nextLine().equalsIgnoreCase("Yes");

                    System.out.print("How many cups do you need? ");
                    int shakeCups = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter the customer name: ");
                    String shakeName = scanner.nextLine();

                    MilkShake milkShake = new MilkShake(flavor, shakeSize, shakeCups, shakeName, extraCream);
                    milkShake.displayOrder(today);
                    break;

                case "tea":
                    System.out.print("Enter type (ginger/cardamom/special): ");
                    String teaType = getValidInput(scanner, teaTypes);
                    System.out.print("Enter Size (Small/Medium): ");
                    String teaSize = getValidInput(scanner, new String[]{"small", "medium"});
                    System.out.print("What Do You Like to Add (honey/sugar/no sugar): ");
                    String teaAddon = getValidInput(scanner, addons);

                    System.out.print("How many cups do you need? ");
                    int teaCups = Integer.parseInt(scanner.nextLine());

                    System.out.print("Enter the customer name: ");
                    String teaName = scanner.nextLine();

                    Tea tea = new Tea(teaType, teaSize, teaAddon, teaCups, teaName);
                    tea.displayOrder(today);
                    break;

                default:
                    System.out.println("Invalid drink type.");
            }
        } catch (NumberFormatException e) {  /* Chapter 5: Exception handling */
            System.out.println("Invalid number entered for cups. Please enter an integer.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static String getValidInput(Scanner scanner, String[] validOptions) {
        String input;
        while (true) {
            input = scanner.nextLine().trim().toLowerCase();
            boolean valid = false;
            for (String option : validOptions) {		/* Chapter 4: Control statements*/
                if (input.equals(option.toLowerCase())) {
                    valid = true;
                    break;
                }
            }
            if (valid) {
                break;
            } else {
                System.out.print("Invalid entry. Please enter a valid option: ");
            }
        }
        return input;
    }

    public static double[] calculatePricing(double unitPrice, int cups, LocalDate date) {  /* chapter 3: Working with primitive data types (double, int) */
        double total = unitPrice * cups;
        double discount = (total > 15) ? total * 0.15 : 0;
        boolean inSeason = !date.isBefore(LocalDate.of(2025, 5, 4)) &&
                           !date.isAfter(LocalDate.of(2025, 5, 24));
        double seasonalDiscount = inSeason ? total * 0.30 : 0;	/*Chapter 14: Working with dates and times (seasonal logic)*/
        double tax = (total - discount - seasonalDiscount) * 0.08;
        double finalPrice = total - discount - seasonalDiscount + tax;

        return new double[]{total, seasonalDiscount, discount, finalPrice};	/*Chapter 11: Working with arrays (returning a double[])*/
    }
}
