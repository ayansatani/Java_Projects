
/**
 * 
 * CET - CS Academic Level 3
 * This class represents a Fruit item, extending the FoodItem class
 * Student Name: Ayan Satani
 * Student Number: 041089567      
 * Section #:   312
 * Course: CST8130 - Data Structures
 * Professor: George Kriger. 
 * 
 */

import java.util.Formatter;
import java.util.Scanner;

public class Fruit extends FoodItem {
	private String orchardName;

	/**
	 * Constructs a Fruit item with the given attributes.
	 *
	 * @param itemCode            The item code.
	 * @param itemName            The item name.
	 * @param itemPrice           The item price.
	 * @param itemQuantityInStock The item quantity in stock.
	 * @param itemCost            The item cost.
	 * @param orchardName         The orchard name for the fruit.
	 */
	public Fruit(int itemCode, String itemName, float itemPrice, int itemQuantityInStock, float itemCost,
			String orchardName) {
		super(itemCode, itemName, itemPrice, itemQuantityInStock, itemCost);
		this.orchardName = orchardName;
	}

	/**
	 * Overrides the toString method to include orchard supplier information.
	 *
	 * @return String representation of the Fruit item.
	 */

	@Override
	public String toString() {
		return super.toString() + ", orchard supplier: " + orchardName;
	}

	/**
	 * Adds a food item to the inventory based on user input. If reading from a
	 * file, orchardName is not prompted.
	 *
	 * @param scanner  The Scanner object to read user input.
	 * @param fromFile True if reading from a file, false if adding a new item
	 *                 interactively.
	 * @return True if the item was successfully added, false otherwise.
	 */

	@Override
	public boolean addItem(Scanner scanner, boolean fromFile) {
		// Call the super class's addItem method
		boolean success = super.addItem(scanner, fromFile);

		if (!fromFile) {
			System.out.print("Enter the orchard name for the fruit: ");
			this.orchardName = scanner.nextLine();
		}
		return success;
	}

	/**
	 * Outputs a formatted representation of a fruit item to the provided Formatter
	 * object. The format includes the item code, item name, quantity in stock,
	 * price, cost, and orchard name.
	 *
	 * @param writer The Formatter object to output the formatted data.
	 */

	@Override
	public void outputItem(Formatter writer) {
		writer.format("f%n"); // 'f' for Fruit
		super.outputItem(writer);
		writer.format("%s%n", orchardName);
	}

	/**
	 * Gets the orchard name for the fruit item.
	 *
	 * @return The orchard name for the fruit item.
	 */
	public String getOrchardName() {
		return orchardName;
	}

	/**
	 * Sets the orchard name for the fruit item.
	 *
	 * @param orchardName The orchard name to set for the fruit item.
	 */
	public void setOrchardName(String orchardName) {
		this.orchardName = orchardName;
	}

}
