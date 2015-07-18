package item;

import item.Item;

public class Package extends Item {

	// Package has four speical fields
	private double length;
	private double width;
	private double height;
	private int ounces;

	public Package(String product, double price, double l, double w, double h,
			int vol) {
		super(product, price);
		length = l;
		width = w;
		height = h;
		ounces = vol;
	}

	public String toString() {
		return super.toString() + "\nlength: " + length + "\nwidth: " + width
				+ "\nheight: " + height + "\nvolume: " + ounces + "lbs";
	}

}