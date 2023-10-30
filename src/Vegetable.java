
/**
 * 
 * CET - CS Academic Level 3
 * This class represents a Vegetable item, extending the FoodItem class
 * Student Name: Ayan Satani
 * Student Number: 041089567      
 * Section #:   312
 * Course: CST8130 - Data Structures
 * Professor: George Kriger. 
 * 
 */

import java.util.Formatter;
import java.util.Scanner;

public class Vegetable extends FoodItem {

    private String farmName;

    /**
     * Constructs a Vegetable item with the given attributes.
     *
     * @param itemCode           The item code.
     * @param itemName           The item name.
     * @param itemPrice          The item price.
     * @param itemQuantityInStock The item quantity in stock.
     * @param itemCost           The item cost.
     * @param farmName           The farm name for the vegetable.
     */
    public Vegetable(int itemCode, String itemName, float itemPrice, int itemQuantityInStock, float itemCost, String farmName) {
        super(itemCode, itemName, itemPrice, itemQuantityInStock, itemCost);
        this.farmName = farmName;
    }

    /**
     * Overrides the toString method to include farm supplier information.
     *
     * @return String representation of the Vegetable item.
     */
    @Override
    public String toString() {
        return super.toString() + ", farm supplier: " + farmName;
    }

    /**
     * Adds a new vegetable item to the inventory, taking input from the user or a file.
     *
     * @param scanner   The Scanner object for input.
     * @param fromFile  A boolean indicating whether the input is from a file.
     * @return True if the addition was successful, false otherwise.
     */
    @Override
    public boolean addItem(Scanner scanner, boolean fromFile) {
        // Call the super class's addItem method
        boolean success = super.addItem(scanner, fromFile);

        if (!fromFile) {
            System.out.print("Enter the farm name for the vegetable: ");
            this.farmName = scanner.nextLine();
        }
        return success;
    }

    /**
     * Outputs the vegetable item details to a Formatter, including farm name.
     *
     * @param writer The Formatter object for writing.
     */
    @Override
    public void outputItem(Formatter writer) {
        writer.format("v%n");  // 'v' for Vegetable
        super.outputItem(writer);
        writer.format("%s%n", farmName);
    }

    /**
     * Gets the farm name associated with the vegetable.
     *
     * @return The farm name.
     */
    public String getFarmName() {
        return farmName;
    }

    /**
     * Sets the farm name for the vegetable.
     *
     * @param farmName The farm name to set.
     */
    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

}
