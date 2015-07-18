package item;

public class Item {
	// protected variables that can be accesed by its subclasses
	protected String name; // name of the grocery item
	protected double cost; // purchase price of the grocery item

	public Item(String product, double price) {
		name = product;
		cost = price;
	}

	public double getCost() {
		return cost; //returns the cost of item
	}

	public double costPerUnit(){
		return cost; // since unit is not provided, just return the cost of item
	}
	
	public String toString () {
        return "\nProduct: " + name 
            + "\nPrice: $" + cost;

    }
	
	public String getName()
	{
		return name; // returns the name of item
	}
	
}
