
/**
 * 
 * CET - CS Academic Level 3
 * This class represents an inventory of food items
 * Student Name: Ayan Satani
 * Student Number: 041089567      
 * Section #:   312
 * Course: CST8130 - Data Structures
 * Professor: George Kriger. 
 * 
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.Scanner;

public class Inventory {
	private ArrayList<FoodItem> inventory;
	private int numItems;

	/**
	 * Constructs an empty inventory with a maximum capacity of 20 items.
	 */
	public Inventory() {
		inventory = new ArrayList<>();
		numItems = 0;
		Collections.sort(inventory);
	}

	/**
	 * Overrides the toString method to provide a string representation of the
	 * inventory.
	 *
	 * @return String representation of the inventory.
	 */

	public String toString() {
		StringBuilder result = new StringBuilder("Inventory:");

		for (FoodItem item : inventory) {
			if (item instanceof Fruit) {
				result.append("\n").append(item.toString());
			} else if (item instanceof Preserve) {
				result.append("\n").append(item.toString());
			} else if (item instanceof Vegetable) {
				result.append("\n").append(item.toString());
			}
		}
		return result.toString();
	}

	/**
	 * Checks if a FoodItem with the given item code already exists in the
	 * inventory.
	 *
	 * @param item The FoodItem to check for existence based on its item code.
	 * @return The index of the FoodItem if it exists; -1 otherwise.
	 */
	public int alreadyExists(FoodItem item) {
		int itemCodeToCheck = item.getItemCode();

		// Iterate through the inventory to find a matching item code
		for (int i = 0; i < numItems; i++) {
			if (inventory.get(i).isEqual(itemCodeToCheck)) {
				return i;// Item with the specified item code found, return its index
			}
		}
		return -1; // Item with the specified item code not found
	}

	/**
	 * Adds a food item to the inventory based on user input.
	 *
	 * @param scanner  The Scanner object to read user input.
	 * @param fromFile To read and save the file
	 */
	public void addItem(Scanner scanner, boolean fromFile) {
		boolean addedItem = false;

		while (!addedItem) {
			System.out.print("Do you wish to add a fruit(f), vegetable(v), or preserve(p)? ");
			String itemType = scanner.nextLine().toLowerCase().trim();

			switch (itemType) {
			case "f":
				while (true) {
					try {
						// User input for Fruit which handles all the exceptions
						System.out.print("Enter the code for the fruit: ");
						int itemCodeFruit = Integer.parseInt(scanner.nextLine());

						System.out.print("Enter the name for the fruit: ");
						String itemNameFruit = scanner.nextLine();

						int itemQuantityFruit;
						do {
							System.out.print("Enter the quantity for the fruit: ");
							try {
								itemQuantityFruit = Integer.parseInt(scanner.nextLine());
								if (itemQuantityFruit < 0)
									throw new NumberFormatException();
								break;
							} catch (NumberFormatException e) {// Catching an exception
								System.out.println("Invalid entry");
							}
						} while (true);

						float itemCostFruit;
						do {
							System.out.print("Enter the cost for the fruit: ");
							try {
								itemCostFruit = Float.parseFloat(scanner.nextLine());
								if (itemCostFruit < 0)
									throw new NumberFormatException();
								break;
							} catch (NumberFormatException e) {
								System.out.println("Invalid entry");
							}
						} while (true);

						float itemPriceFruit;
						do {
							System.out.print("Enter the sales price of the fruit: ");
							try {
								itemPriceFruit = Float.parseFloat(scanner.nextLine());
								if (itemPriceFruit < 0)
									throw new NumberFormatException();
								break;
							} catch (NumberFormatException e) {
								System.out.println("Invalid entry");
							}
						} while (true);

						System.out.print("Enter the name of the orchard supplier: ");
						String orchardNameFruit = scanner.nextLine();

						// Create a Fruit instance and add it to the inventory
						Fruit fruit = new Fruit(itemCodeFruit, itemNameFruit, itemPriceFruit, itemQuantityFruit,
								itemCostFruit, orchardNameFruit);
						inventory.add(fruit);
						numItems++;
						addedItem = true;
						break;
					} catch (NumberFormatException e) {
						System.out.println("Invalid entry");
					}
				}
				break;
			case "v":
				while (true) {
					try {
						// User input for Vegetables which handles all the exceptions
						System.out.print("Enter the code for the vegetable: ");
						int itemCodeVegetable = Integer.parseInt(scanner.nextLine());

						System.out.print("Enter the name for the vegetable: ");
						String itemNameVegetable = scanner.nextLine();

						int itemQuantityVegetable;
						do {
							System.out.print("Enter the quantity for the vegetable: ");
							try {
								itemQuantityVegetable = Integer.parseInt(scanner.nextLine());
								if (itemQuantityVegetable < 0)
									throw new NumberFormatException();
								break;
							} catch (NumberFormatException e) {
								System.out.println("Invalid entry. Please enter a non-negative integer for quantity.");
							}
						} while (true);

						float itemCostVegetable;
						do {
							System.out.print("Enter the cost for the vegetable: ");
							try {
								itemCostVegetable = Float.parseFloat(scanner.nextLine());
								if (itemCostVegetable < 0)
									throw new NumberFormatException();
								break;
							} catch (NumberFormatException e) {
								System.out
										.println("Invalid entry. Please enter a non-negative numeric value for cost.");
							}
						} while (true);

						float itemPriceVegetable;
						do {
							System.out.print("Enter the sales price of the vegetable: ");
							try {
								itemPriceVegetable = Float.parseFloat(scanner.nextLine());
								if (itemPriceVegetable < 0)
									throw new NumberFormatException();
								break;
							} catch (NumberFormatException e) {
								System.out.println(
										"Invalid entry. Please enter a non-negative numeric value for sales price.");
							}
						} while (true);

						System.out.print("Enter the name of the farm supplier: ");
						String farmNameVegetable = scanner.nextLine();

						// Create a Vegetable instance and add it to the inventory
						Vegetable vegetable = new Vegetable(itemCodeVegetable, itemNameVegetable, itemPriceVegetable,
								itemQuantityVegetable, itemCostVegetable, farmNameVegetable);
						inventory.add(vegetable);
						numItems++;
						addedItem = true;
						break;
					} catch (NumberFormatException e) {
						System.out.println("Invalid entry. Please enter a valid numeric value.");
					}
				}
				break;

			case "p":
				while (true) {
					try {
						// User input for Preserve which handles all the exceptions
						System.out.print("Enter the code for the preserve: ");
						int itemCodePreserve = Integer.parseInt(scanner.nextLine());

						System.out.print("Enter the name for the preserve: ");
						String itemNamePreserve = scanner.nextLine();

						int itemQuantityPreserve;
						do {
							System.out.print("Enter the quantity for the preserve: ");
							try {
								itemQuantityPreserve = Integer.parseInt(scanner.nextLine());
								if (itemQuantityPreserve < 0)
									throw new NumberFormatException();
								break;
							} catch (NumberFormatException e) {
								System.out.println("Invalid entry");
							}
						} while (true);

						float itemCostPreserve;
						do {
							System.out.print("Enter the cost for the preserve: ");
							try {
								itemCostPreserve = Float.parseFloat(scanner.nextLine());
								if (itemCostPreserve < 0)
									throw new NumberFormatException();
								break;
							} catch (NumberFormatException e) {
								System.out.println("Invalid entry");
							}
						} while (true);

						float itemPricePreserve;
						do {
							System.out.print("Enter the sales price of the preserve: ");
							try {
								itemPricePreserve = Float.parseFloat(scanner.nextLine());
								if (itemPricePreserve < 0)
									throw new NumberFormatException();
								break;
							} catch (NumberFormatException e) {
								System.out.println("Invalid entry");
							}
						} while (true);

						System.out.print("Enter the size of the jar in milliliters: ");
						String jarSizePreserve = scanner.nextLine();

						// Create a Preserve instance and add it to the inventory
						Preserve preserve = new Preserve(itemCodePreserve, itemNamePreserve, itemPricePreserve,
								itemQuantityPreserve, itemCostPreserve, jarSizePreserve);
						inventory.add(preserve);
						numItems++;
						addedItem = true;
						break;
					} catch (NumberFormatException e) {
						System.out.println("Invalid entry");
					}
				}
				break;

			default:
				System.out.println("Invalid entry. Please enter a valid option (f, v, p).");
				break;
			}
			// Sorting the inventory using collection class
			Collections.sort(inventory, Comparator.comparingInt(FoodItem::getItemCode));
		}
	}

	/**
	 * Updates the quantity of a food item in the inventory.
	 *
	 * @param scanner   The Scanner object to read user input.
	 * @param itemCode  The item code of the item to update.
	 * @param quantity  The quantity to update.
	 * @param buyOrSell True if buying, false if selling.
	 * @return True if the item quantity was successfully updated, false otherwise.
	 */

	public boolean updateQuantity(Scanner scanner, int itemCode, int quantity, boolean buyOrSell) {
		// Check if the inventory is empty
		if (numItems == 0) {
			System.out.println("Inventory is empty. Cannot buy or sell items.");
			return false;
		}

		// Find the index of the item in the inventory based on the item code
		int itemIndex = -1;
		for (int i = 0; i < numItems; i++) {
			if (inventory.get(i).getItemCode() == itemCode) {
				itemIndex = i;
				break;
			}
		}

		// Check if the item was found in the inventory
		if (itemIndex == -1) {
			System.out.println("Item with code " + itemCode + " not found in inventory.");
			return false;
		}

		boolean success;
		// Update the item quantity based on buyOrSell flag
		if (buyOrSell) {
			success = inventory.get(itemIndex).updateItem(quantity); // Buy
		} else {
			success = inventory.get(itemIndex).updateItem(-quantity); // Sell
		}

		// Print success or failure message based on the update
		if (success) {
			System.out.println("Item quantity updated successfully.");
			return true;
		} else {
			System.out.println("Failed");
			return false;
		}
	}

	/**
	 * Gets the number of items in the inventory.
	 *
	 * @return The number of items in the inventory.
	 */
	public int getNumItems() {
		return numItems;
	}

	/**
	 * Searches for an item in the inventory by its item code and displays the item
	 * information if found.
	 *
	 * @param scanner The Scanner object for user input.
	 */
	public void searchForItem(Scanner scanner) {
		if (numItems == 0) {
			System.out.println("Inventory is empty. Cannot search for items.");
			return;
		}

		System.out.print("Enter the item code to search for: ");
		int searchItemCode = scanner.nextInt();
		scanner.nextLine(); // Consume the newline character

		// Sort the inventory by item code
		Collections.sort(inventory, Comparator.comparingInt(FoodItem::getItemCode));

		//Using binary search to search for items in the inventory
		int lowIndex = 0;
		int highIndex = numItems - 1;

		while (lowIndex <= highIndex) {
			int midPosition = lowIndex + (highIndex - lowIndex) / 2;
			FoodItem currentItem = inventory.get(midPosition);

			if (currentItem.getItemCode() == searchItemCode) {
				System.out.println("Item found: " + currentItem);
				return;
			} else if (currentItem.getItemCode() < searchItemCode) {
				lowIndex = midPosition + 1;
			} else {
				highIndex = midPosition - 1;
			}
		}

		System.out.println("Item with item code " + searchItemCode + " not found in inventory.");
	}
	
	/**
	 * Saves the inventory to a file.
	 *
	 * @param scanner The Scanner object for user input.
	 */

	public void saveToFile(Scanner scanner) {
		System.out.print("Enter the filename to save to: ");
		String fileName = scanner.next();

		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
			for (int i = 0; i < numItems; i++) {
				FoodItem currentItem = inventory.get(i);

				// Print item type abbreviation based on the class type
				char itemTypeAbbreviation = currentItem instanceof Fruit ? 'f'
						: currentItem instanceof Vegetable ? 'v' : 'p';
				writer.println(itemTypeAbbreviation);

				// Print item code, item name,item quantity, price and cost in separate lines
				writer.println(currentItem.getItemCode());
				writer.println(currentItem.getItemName());
				writer.println(currentItem.getItemQuantityInStock());
				writer.printf("%.2f%n", currentItem.getItemPrice());
				writer.printf("%.2f%n", currentItem.getItemCost());

				// Print supplier information based on the class type
				if (currentItem instanceof Fruit) {
					writer.println(((Fruit) currentItem).getOrchardName());
				} else if (currentItem instanceof Vegetable) {
					writer.println(((Vegetable) currentItem).getFarmName());
				} else if (currentItem instanceof Preserve) {
					writer.println(((Preserve) currentItem).getJarSize());
				}

			}

			System.out.println("Inventory successfully saved to file.");
		} catch (IOException e) {
			System.out.println("Could not write to file: " + e.getMessage());
		}
	}

	/**
	 * Reads the inventory from a file and adds the items to the current inventory.
	 *
	 * @param scanner The Scanner object for user input.
	 */
	public void readFromFile(Scanner scanner) {
		System.out.print("Enter the filename to read from: ");
		String fileName = scanner.next();
		scanner.nextLine(); // Consume the newline character

		try {
			File file = new File(fileName);
			if (!file.exists()) {
				throw new FileNotFoundException("Error: File not found");
			}

			try (Scanner fileScanner = new Scanner(file)) {
				while (fileScanner.hasNextLine()) {
					String itemType = fileScanner.nextLine().trim(); // Read item type

					// Adjust to read the file format
					int itemCode = Integer.parseInt(fileScanner.nextLine().trim());

					// Check if the item code already exists
					if (alreadyExists(new FoodItem(itemCode, "", 0, 0, 0)) != -1) {
						System.out.println("Item code already exists");
						System.out.println("Error Encountered while reading the file, aborting...");
						return;
					}

					String itemName = fileScanner.nextLine().trim();
					int itemQuantity = Integer.parseInt(fileScanner.nextLine().trim());
					float itemCost = Float.parseFloat(fileScanner.nextLine().trim());
					float itemPrice = Float.parseFloat(fileScanner.nextLine().trim());
					String supplierName = fileScanner.nextLine().trim(); // Read supplier name

					// Process the information based on the item type (f, v, p)
					FoodItem newItem;
					if (itemType.equalsIgnoreCase("f")) {
						// Process as a fruit
						newItem = new Fruit(itemCode, itemName, itemPrice, itemQuantity, itemCost, supplierName);
					} else if (itemType.equalsIgnoreCase("v")) {
						// Process as a vegetable
						newItem = new Vegetable(itemCode, itemName, itemPrice, itemQuantity, itemCost, supplierName);
					} else if (itemType.equalsIgnoreCase("p")) {
						// Process as a preserve
						newItem = new Preserve(itemCode, itemName, itemPrice, itemQuantity, itemCost, supplierName);
					} else {
						System.out.println("Invalid item type: " + itemType);
						continue; // Skip invalid item type
					}

					// Add the new item to the inventory
					inventory.add(newItem);
					numItems++;
				}

				System.out.println("Inventory successfully read from file.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found, ignoring...");
		}
	}

	/**
	 * Gets the item code of the last item in the inventory.
	 *
	 * @return The item code of the last item in the inventory.
	 */
	public int getItemCode() {
		return inventory.get(numItems).getItemCode();
	}

	/**
	 * Gets the inventory as an ArrayList of FoodItem objects.
	 *
	 * @return The inventory as an ArrayList of FoodItem objects.
	 */
	public ArrayList<FoodItem> getInventory() {
		return inventory;
	}

}
