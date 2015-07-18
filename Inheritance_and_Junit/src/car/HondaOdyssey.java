package car;
public class HondaOdyssey extends Car {
	/**
	 * constructor for FordFocus. It sets renwalAmount to 100 since renewal fee
	 * for HondaOdyssey is $100.
	 * @param Name
	 *            name of car owner
	 * @param Address
	 *            address of car owner
	 * @param RenewalDate
	 *            required date for car to be re-registered.
	 * @param RegistrationNumber
	 *            Registration number of car issued by government
	 */
	public HondaOdyssey(String Name, String Address, String RenewalDate,
			String RegistrationNumber) {
		super(Name, Address, RenewalDate, RegistrationNumber);
		super.renewalAmount = 100;
	}	
	/**
	 * @return Registration number of car
	 */
	@Override
	public String getRegistrationNumber() {
		return super.registrationNumber;
	}	
	/**
	 * @return Type of HondaOdyssey
	 */
	@Override
	public String getType() {
		return "Minivan";
	}
	/**
	 * @return Make/model of HondaOdyssey
	 */
	@Override
	public String getModel() {
		return "Honda Odyssey";
	}	
	/**
	 * @return returns HondaOdyssey because FordFocus is priced at $8900
	 */
	@Override
	public double getValue() {
		return 8900;
	}
	/**
	 * @return Type of HondaOdyssey
	 */
	public String type() {
		return "Minivan";	}
	/**
	 * @return Make/model of HondaOdyssey
	 */
	public String model() {
		return "Honda Odyssey";}
}
