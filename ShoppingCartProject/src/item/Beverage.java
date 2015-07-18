package item;

import item.Item;

public class Beverage extends Item {
	// Beverage has two special fields
	private int fluidOunces; //volume of beverage item
	private double containerDeposit; //price of  bottle deposit for beverage item

	public Beverage(String product, double price, int volume, double deposit) {
		super(product, price);
		fluidOunces = volume;
		containerDeposit = deposit;
	}

	public double costPerUnit() {
		return super.costPerUnit() / fluidOunces; // returns cost per fluid
													// ounce
	}

	public double getCost() {
		return (super.getCost() + containerDeposit); // return the total cost (price of beverage item + bottle deposit
	}

	public String toString() {
		return super.toString() + "\nVolume: " + fluidOunces + "fl.oz."
				+ "\nDontainer Deposit: $" + containerDeposit;
	}

}
