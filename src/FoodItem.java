
/**
 * 
 * CET - CS Academic Level 3
 * This class represents a food item with its code, name, price, quantity in stock, and cost.
 * Student Name: Ayan Satani
 * Student Number: 041089567      
 * Section #:   312
 * Course: CST8130 - Data Structures
 * Professor: George Kriger. 
 * 
 */

import java.util.Formatter;
import java.util.Scanner;

public class FoodItem implements Comparable<FoodItem> {

	// Fields representing properties of a food item
	private int itemCode;
	private String itemName;
	private float itemPrice;
	private int itemQuantityInStock;
	private float itemCost;

	/**
	 * Constructor to initialize a FoodItem instance.
	 *
	 * @param itemCode            The code of the food item.
	 * @param itemName            The name of the food item.
	 * @param itemPrice           The price of the food item.
	 * @param itemQuantityInStock The quantity of the food item in stock.
	 * @param itemCost            The cost of the food item.
	 */

	public FoodItem(int itemCode, String itemName, float itemPrice, int itemQuantityInStock, float itemCost) {
		this.itemCode = itemCode;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantityInStock = itemQuantityInStock;
		this.itemCost = itemCost;
	}

	public FoodItem() {
	}

	/**
	 * Returns a string representation of the FoodItem.
	 *
	 * @return String representation of the FoodItem.
	 */
	@Override
	public String toString() {
		return "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock + " price: $"
				+ String.format("%.2f", itemPrice) + ", Cost: $" + String.format("%.2f", itemCost);
	}

	/**
	 * Adds a food item to the inventory based on user input.
	 *
	 * @param scanner  The Scanner object to read user input.
	 * @param fromFile A boolean indicating if the input is from a file.
	 * @return True if the item was successfully added, false otherwise.
	 */

	public boolean addItem(Scanner scanner, boolean fromFile) {
		if (!fromFile) {
			System.out.print("Enter item code: ");
			if (scanner.hasNextInt()) {
				this.itemCode = scanner.nextInt();
				scanner.nextLine(); // Consume newline character
			} else {
				scanner.nextLine(); // Consume invalid input
				return false;
			}
		}

		System.out.print("Enter item name: ");
		this.itemName = scanner.nextLine();

		System.out.print("Enter item quantity in stock: ");
		if (scanner.hasNextInt()) {
			this.itemQuantityInStock = scanner.nextInt();
			scanner.nextLine(); // Consume newline character
		} else {
			scanner.nextLine(); // Consume invalid input
			return false;
		}

		System.out.print("Enter item price: ");
		if (scanner.hasNextFloat()) {
			this.itemPrice = scanner.nextFloat();
			scanner.nextLine(); // Consume newline character
		} else {
			scanner.nextLine(); // Consume invalid input
			return false;
		}

		System.out.print("Enter item cost: ");
		if (scanner.hasNextFloat()) {
			this.itemCost = scanner.nextFloat();
			scanner.nextLine(); // Consume newline character
		} else {
			scanner.nextLine(); // Consume invalid input
			return false;
		}

		return true;
	}

	/**
	 * Updates the quantity of the item.
	 *
	 * @param amount The amount to add or subtract from the item's quantity.
	 * @return True if the item quantity was updated successfully, false otherwise.
	 */
	public boolean updateItem(int amount) {

		// Check if the amount is negative (indicating a sell operation)
		if (amount < 0 && this.itemQuantityInStock + amount < 0) {
			System.out.println("Error: Cannot sell more than the available quantity.");
			return false;
		}
		// Check if the updated quantity doesn't go negative
		else if (this.itemQuantityInStock + amount >= 0) {
			this.itemQuantityInStock += amount;
			return true;
		}

		if (this.itemQuantityInStock + amount <= 0) {
			System.out.println("Item quantity can't be negative.");
			return false;
		}
		// Return false for any other cases
		return false;
	}

	/**
	 * Returns true if the itemCode of this FoodItem matches the itemCode of another
	 * FoodItem.
	 *
	 * @param other The FoodItem to compare with.
	 * @return True if the itemCode matches, false otherwise.
	 */
	public boolean isEqual(FoodItem other) {
		return this.itemCode == other.getItemCode();
	}

	/**
	 * Reads and validates an item code from the user using the provided Scanner.
	 *
	 * @param scanner  The Scanner object to read user input.
	 * @param fromFile A boolean indicating if the input is from a file.
	 * @return True if a valid item code was entered, false otherwise.
	 */

	public boolean inputCode(Scanner scanner, boolean fromFile) {
		if (!fromFile) {
			System.out.print("Enter item code: "); // Prompt for item code if not reading from file
		}

		if (scanner.hasNextInt()) {
			scanner.nextLine();
			return true; // Return true if a valid integer (item code) was entered
		} else {
			scanner.nextLine();
			return false; // Return false if input is not a valid integer (item code)
		}
	}

	/**
	 * Returns true if the itemCode of this FoodItem matches the given itemCode.
	 *
	 * @param itemCode The item code to compare with.
	 * @return True if the itemCode matches, false otherwise.
	 */
	public boolean isEqual(int itemCode) {
		return this.itemCode == itemCode;
	}

	/**
	 * Gets the item code.
	 *
	 * @return The item code.
	 */
	public int getItemCode() {
		return itemCode;
	}

	/**
	 * Sets the item code.
	 *
	 * @param itemCode The item code to set.
	 */
	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}

	/**
	 * Gets the item name.
	 *
	 * @return The item name.
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * Sets the item name.
	 *
	 * @param itemName The item name to set.
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * Gets the item price.
	 *
	 * @return The item price.
	 */
	public float getItemPrice() {
		return itemPrice;
	}

	/**
	 * Sets the item price.
	 *
	 * @param itemPrice The item price to set.
	 */
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	 * Gets the item quantity in stock.
	 *
	 * @return The item quantity in stock.
	 */
	public int getItemQuantityInStock() {
		return itemQuantityInStock;
	}

	/**
	 * Sets the item quantity in stock.
	 *
	 * @param itemQuantityInStock The item quantity in stock to set.
	 */
	public void setItemQuantityInStock(int itemQuantityInStock) {
		this.itemQuantityInStock = itemQuantityInStock;
	}

	/**
	 * Gets the item cost.
	 *
	 * @return The item cost.
	 */
	public float getItemCost() {
		return itemCost;
	}

	/**
	 * Sets the item cost.
	 *
	 * @param itemCost The item cost to set.
	 */
	public void setItemCost(float itemCost) {
		this.itemCost = itemCost;
	}

	/**
	 * Outputs the item details in a formatted manner to the provided formatter.
	 *
	 * @param writer The formatter to write the item details to.
	 */

	public void outputItem(Formatter writer) {
		writer.format("%d %s %d %.2f %.2fn", itemCode, itemName, itemQuantityInStock, itemPrice, itemCost);
	}

	/**
	 * Compares this FoodItem with another FoodItem based on their item codes.
	 *
	 * @param otherFoodItem The FoodItem to compare against.
	 * @return A negative integer, zero, or a positive integer as this object is
	 *         less than, equal to, or greater than the specified object.
	 */

	@Override
	public int compareTo(FoodItem otherFoodItem) {
		return Integer.compare(this.itemCode, otherFoodItem.itemCode);
	}
}
