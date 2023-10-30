
/**
 * 
 * CET - CS Academic Level 3
 * This class represents an inventory management system for food items.
 * Student Name: Ayan Satani
 * Student Number: 041089567      
 * Section #:   312
 * Course: CST8130 - Data Structures
 * Professor: George Kriger. 
 * 
 */


import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Assign2 {

	/**
	 * Main method to run the inventory management system.
	 *
	 * @param args The command-line arguments
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Inventory inventory = new Inventory();


		while (true) {
			try {
				System.out.println("Please select one of the following:");
				System.out.println("1: Add Item to Inventory");
				System.out.println("2: Display Current Inventory");
				System.out.println("3: Buy Item(s)");
				System.out.println("4: Sell Item(s)");
				System.out.println("5: Search for Item");
				System.out.println("6: Save Inventory to File");
				System.out.println("7: Read Inventory from File");
				System.out.println("8: To Exit");
				System.out.print(">");

				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {
				case 1:
					inventory.addItem(scanner, false); // Add an item to the inventory
					break;
				
				case 2:
					Collections.sort(inventory.getInventory(), Comparator.comparingInt(FoodItem::getItemCode));
					System.out.println(inventory); // Display current inventory
					break;
				case 3:
					if (inventory.getNumItems() == 0) {
						System.out.println("Error...could not buy item"); // Display error if inventory is empty
						break;
					}

					System.out.print("Enter the item code to buy: ");
					int buyItemCode = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Enter the quantity to buy: ");
					int buyQuantity = scanner.nextInt();
					scanner.nextLine();
					inventory.updateQuantity(scanner, buyItemCode, buyQuantity, true);
					break;

				case 4:
					if (inventory.getNumItems() == 0) {
						System.out.println("Error...could not sell item"); // Display error if inventory is empty
						break;
					}

					System.out.print("Enter the item code to sell: ");
					int sellItemCode = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Enter the quantity to sell: ");
					int sellQuantity = scanner.nextInt();
					scanner.nextLine();
					inventory.updateQuantity(scanner, sellItemCode, sellQuantity, false); // Update quantity for selling
					break;

				case 5:
					inventory.searchForItem(scanner);
					break;
				
				case 6:
					inventory.saveToFile(scanner);
					break;
				
				case 7:
					inventory.readFromFile(scanner);
					break;

				case 8:
					scanner.close();
					System.out.println("Exiting...");// Exit the program
					System.exit(0);
				default:

					break;
				}
			} catch (Exception e) {
				System.out.println("...Invalid input, please try again...");
				scanner.nextLine();
			}
		}
	}

}
