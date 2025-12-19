import java.util.Scanner;

public class Inventory {

    private static String[] itemNames = new String[50];
    private static String[] itemCategories = new String[50];
    private static int[] itemQuantities = new int[50];
    private static String[] itemStatuses = new String[50];
    private static int itemCount = 0;

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        printWelcome();
        boolean running = true;

        while (running) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    addItem();
                    break;

                case "2":
                    viewItems();
                    break;

                case "3":
                    searchItems();
                    break;

                case "4":
                    updateItemStatus();
                    break;

                case "5":
                    running = false;
                    System.out.println("Exiting Inventory System. Goodbye!");
                    break;

                default:
                    System.out.println("\nInvalid choice! Please enter 1–5.\n");
            }
        }
        scanner.close();
    }

    private static void printWelcome() {
        System.out.println("Welcome to Inventory Management System");
        System.out.println();
    }

    private static void displayMenu() {
        System.out.println("INVENTORY MENU");
        System.out.println("1. Add Item");
        System.out.println("2. View Items");
        System.out.println("3. Search Items");
        System.out.println("4. Update Item Status");
        System.out.println("5. Exit");
        System.out.println("=================");
    }

    private static void addItem() {
        if (itemCount >= 50) {
            System.out.println("Inventory is full!");
            return;
        }

        System.out.print("Enter item name: ");
        itemNames[itemCount] = scanner.nextLine();

        System.out.print("Enter item category: ");
        itemCategories[itemCount] = scanner.nextLine();

        System.out.print("Enter item quantity: ");
        itemQuantities[itemCount] = Integer.parseInt(scanner.nextLine());

        itemStatuses[itemCount] = "Available";
        itemCount++;

        System.out.println("\nItem added successfully!\n");
    }

    private static void viewItems() {
        System.out.println("\n--- Inventory Items ---");

        if (itemCount == 0) {
            System.out.println("No items available.\n");
            return;
        }

        for (int i = 0; i < itemCount; i++) {
            System.out.println(
                (i + 1) + ". [" + itemStatuses[i] + "] " +
                itemNames[i] + " | Category: " + itemCategories[i] +
                " | Qty: " + itemQuantities[i]
            );
        }
        System.out.println();
    }

    private static void searchItems() {
        System.out.print("\nEnter search keyword: ");
        String keyword = scanner.nextLine().toLowerCase();

        int found = 0;
        System.out.println("\nSearch results:");

        for (int i = 0; i < itemCount; i++) {
            if (itemNames[i].toLowerCase().contains(keyword) ||
                itemCategories[i].toLowerCase().contains(keyword)) {

                System.out.println(
                    (i + 1) + ". [" + itemStatuses[i] + "] " +
                    itemNames[i] + " | Qty: " + itemQuantities[i]
                );
                found++;
            }
        }

        if (found == 0) {
            System.out.println("No items found.");
        } else {
            System.out.println("\nFound " + found + " item(s).");
        }
        System.out.println();
    }

    private static void updateItemStatus() {
        System.out.println("\nUpdate Item Status");

        if (itemCount == 0) {
            System.out.println("No items to update.");
            return;
        }

        viewItems();
        System.out.print("Enter item number to update: ");
        int itemNum = Integer.parseInt(scanner.nextLine());

        if (itemNum < 1 || itemNum > itemCount) {
            System.out.println("Invalid item number!");
            return;
        }

        System.out.println("Select new status:");
        System.out.println("1. Available");
        System.out.println("2. Out of Stock");
        System.out.println("3. Discontinued");
        System.out.print("Enter choice: ");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                itemStatuses[itemNum - 1] = "Available";
                break;
            case "2":
                itemStatuses[itemNum - 1] = "Out of Stock";
                break;
            case "3":
                itemStatuses[itemNum - 1] = "Discontinued";
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }

        System.out.println("Item status updated successfully!");
    }
}
