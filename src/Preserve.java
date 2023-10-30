
/**
 * 
 * CET - CS Academic Level 3
 * This class represents a Preserve item, extending the FoodItem class.
 * Student Name: Ayan Satani
 * Student Number: 041089567      
 * Section #:   312
 * Course: CST8130 - Data Structures
 * Professor: George Kriger. 
 * 
 */


import java.util.Formatter;
import java.util.Scanner;

public class Preserve extends FoodItem {

    private String jarSize;

    /**
     * Constructs a Preserve item with the given attributes.
     *
     * @param itemCode            The item code.
     * @param itemName            The item name.
     * @param itemPrice           The item price.
     * @param itemQuantityInStock The item quantity in stock.
     * @param itemCost            The item cost.
     * @param jarSize             The jar size for the preserve.
     */
    public Preserve(int itemCode, String itemName, float itemPrice, int itemQuantityInStock, float itemCost,
                    String jarSize) {
        super(itemCode, itemName, itemPrice, itemQuantityInStock, itemCost);
        this.jarSize = jarSize;
    }

    /**
     * Overrides the toString method to include jar size information.
     *
     * @return String representation of the Preserve item.
     */
    @Override
    public String toString() {
        return super.toString() + ", size: " + jarSize + "ml";
    }

    /**
     * Adds a new preserve item to the inventory. Overrides the method in the superclass (FoodItem).
     *
     * @param scanner   Scanner object for user input.
     * @param fromFile  True if adding from a file, false if adding manually.
     * @return True if the item was successfully added, false otherwise.
     */
    @Override
    public boolean addItem(Scanner scanner, boolean fromFile) {
        // Call the super class's addItem method
        boolean success = super.addItem(scanner, fromFile);

        if (!fromFile) {
            System.out.print("Enter the jar size for the preserve (in ml): ");
            this.jarSize = scanner.nextLine();
        }
        return success;
    }
    
    /**
     * Outputs the preserve item details to a Formatter object.
     *
     * @param writer Formatter object to write the details to.
     */

    @Override
    public void outputItem(Formatter writer) {
        writer.format("p%n");  // 'p' for Preserve
        super.outputItem(writer);
        writer.format("%s%n", jarSize);
    }

    /**
     * Gets the jar size of the preserve item.
     *
     * @return The jar size in milliliters.
     */
    public String getJarSize() {
        return jarSize;
    }

    /**
     * Sets the jar size of the preserve item.
     *
     * @param jarSize The jar size to set in milliliters.
     */
    public void setJarSize(String jarSize) {
        this.jarSize = jarSize;
    }

}

