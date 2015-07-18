package car;
/**
 * this interface provides 
 * @author hansunho
 *
 */
public interface CarDescription {
	
	/**
	 * returns a string of type of the car (eg. Minivan, Sports Car, SUV...)
	 * 
	 * @return Type of the car 
	 */
	public String getType();
	/**
	 * returns a string of make/model of the car (eg. Honda Civic, Toyota Corolla, Audi A8...)
	 * 
	 * @return make/model of the car 
	 */
	public String getModel();

	/**
	 * returns a double of cost of the car
	 * @return price of car
	 */
	public double getValue();
}
