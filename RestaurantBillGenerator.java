import java.util.Scanner;

public class RestaurantBillGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===== Welcome to Java Restaurant =====");
        System.out.println("1. Burger  - $5.00");
        System.out.println("2. Pizza   - $12.00");
        System.out.println("3. Pasta   - $8.00");
        System.out.println("4. Drinks  - $2.00");
        System.out.println("--------------------------------------");
        
        double total = 0;
        boolean ordering = true;
        
        while (ordering) {
            System.out.print("Enter item choice (1-4) or 0 to finish: ");
            int choice = scanner.nextInt();
            
            if (choice == 0) {
                ordering = false;
                break;
            }
            
            System.out.print("Enter quantity: ");
            int qty = scanner.nextInt();
            
            double price = 0;
            String itemName = "";
            
            switch (choice) {
                case 1: 
                    itemName = "Burger"; 
                    price = 5.00; 
                    break;
                case 2: 
                    itemName = "Pizza"; 
                    price = 12.00; 
                    break;
                case 3: 
                    itemName = "Pasta"; 
                    price = 8.00; 
                    break;
                case 4: 
                    itemName = "Drinks"; 
                    price = 2.00; 
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    continue;
            }
            
            double cost = price * qty;
            total += cost;
            System.out.println("Added: " + qty + " x " + itemName + " = $" + cost);
            System.out.println();
        }
        
        double tax = total * 0.05; // 5% tax
        double finalTotal = total + tax;
        
        System.out.println("\n========= YOUR BILL SUMMARY =========");
        System.out.println("Subtotal      : $" + String.format("%.2f", total));
        System.out.println("Tax (5%)      : $" + String.format("%.2f", tax));
        System.out.println("Total Amount  : $" + String.format("%.2f", finalTotal));
        System.out.println("=====================================");
        System.out.println("   Thank you for dining with us!     ");
        
        scanner.close();
    }
}