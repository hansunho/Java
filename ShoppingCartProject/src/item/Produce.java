package item;

import item.Item;

public class Produce extends Item {

	// produce has two private fields
	private double pounds; // weight of item in pounds
	private String category; // type of item eg. vegetable, fruit, cheese, etc.

	public Produce(String product, double price, double weight, String division) {
		super(product, price);
		pounds = weight;
		category = division;
	}

	public double costPerUnit() {
		return cost / pounds; // returns cost per pound
	}

	public String toString() {
		return super.toString() + "\nweight: " + pounds + "lbs"
				+ "\ncategory: " + category;
	}
	
	
}
