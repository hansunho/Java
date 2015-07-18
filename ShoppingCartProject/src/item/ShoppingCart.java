package item;

import item.Beverage;
import item.Item;
import item.Package;
import item.Produce;

public class ShoppingCart {

	private int maxSize;
	private int currentSize;
	private Item[] itemArray;

	ShoppingCart() {
		maxSize = 10; // initial maximum of shopping cart
		currentSize = 0;
		itemArray = new Item[maxSize];
	}

	public void addItem(Item product) {
		// check if array for the shopping cart is full
		if (currentSize == maxSize) {
			maxSize = 2 * maxSize; // if so make the shopping cart twice as
									// large
			Item[] temp = new Item[maxSize];
			// make a temporary cart to move all the items into the new and
			// bigger shopping cart
			for (int i = 0; i < currentSize; i++)
				temp[i] = itemArray[i];
			itemArray = temp; // update itemArray to the new, larger array
								// //@@@@@@@@@@@@@@@@@@@does this line copy
								// everything?????????/ASKKKKK
		}
		// add item to array
		itemArray[currentSize] = product;
		currentSize++;
	}

	public void printCart() {
		System.out.println("Items in ShoppinCart");
		for (int i = 0; i < currentSize; i++)
			System.out.println(itemArray[i]);
		System.out.println("End of Listing");
	}

	public void totalCost() {
		double total = 0;
		for (int i = 0; i < currentSize; i++) {
			total = total + itemArray[i].getCost();
		}

		System.out.println("Total Cost: $" + total);
	}

	public void numberInCart(String groceryName) {
		int NumberOfItem = 0;
		for (int i = 0; i < currentSize; i++) {
			if ((itemArray[i].getName()).equals(groceryName))
				NumberOfItem++;
			;
		}

		System.out.println("There are " + NumberOfItem + " " + groceryName
				+ " in the cart");
	}

	public static void main(String[] argv) {
		// various items of different classes
		ShoppingCart newcart = new ShoppingCart();

		Item item1 = new Item("item", 15);
		
		Produce prod1 = new Produce("Tomato", 5.0, 10, "Vegetable");

		Produce prod2 = new Produce("Carrot", 7.25, 5, "Vegetable");

		Produce prod3 = new Produce("Cheese", 14.75, 2, "Dairy");

		Produce prod4 = new Produce("Watermelon", 5, 7, "Fruit");

		Produce prod5 = new Produce("Kiwi", 5.24, 3, "Fruit");

		Produce prod6 = new Produce("Mango", 9.99, 10, "Fruit");

		Beverage beverage1 = new Beverage("MountainDew", 1.25, 16, 0.05);

		Beverage beverage2 = new Beverage("Pepsi", 1.50, 16, 0.05);

		Beverage beverage3 = new Beverage("Dr.Pepper", 1.10, 12, 0.05);

		Beverage beverage4 = new Beverage("OrangeJuice", 3.25, 36, 0.15);

		Beverage beverage5 = new Beverage("TonicWater", 2.00, 20, 0.10);

		Beverage beverage6 = new Beverage("GreyGoose", 28.99, 25, 0.50);

		Package pack1 = new Package("CheeseIt", 3.89, 10, 20, 5, 5);

		Package pack2 = new Package("Oreos", 2.85, 60, 30, 10, 7);

		Package pack3 = new Package("Chocolate", 8.85, 10, 50, 5, 1);

		Package pack4 = new Package("Donettes", 1.99, 20, 10, 5, 2);

		Package pack5 = new Package("SnackPack", 1.55, 10, 6, 8, 3);

		Package pack6 = new Package("Mac'N'Cheese", 1.33, 20, 30, 10, 2);

		

	}
}