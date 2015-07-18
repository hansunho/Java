package car;

public class FordFocus extends Car {
	/**
	 * constructor for FordFocus. It sets renwalAmount to 150 since renewal fee
	 * for Ford Focus.
	 * 
	 * @param Name
	 *            name of car owner
	 * @param Address
	 *            address of car owner
	 * @param RenewalDate
	 *            required date for car to be re-registered.
	 * @param RegistrationNumber
	 *            Registration number of car issued by government
	 */
	public FordFocus(String Name, String Address, String RenewalDate,
			String RegistrationNumber) {
		super(Name, Address, RenewalDate, RegistrationNumber);
		super.renewalAmount = 150;}
	/**
	 * @return Registration number of car
	 */
	@Override
	public String getRegistrationNumber() {
		return super.registrationNumber;
		}
	/**
	 * @return Type of FordFocus
	 */
	@Override
	public String getType() {
		return "Compact Car";
	}
	/**
	 * @return make and model of FordFocus
	 */
	@Override
	public String getModel() {
		return "Ford Focus";
	}
	/**
	 * @return returns 14449 because FordFocus is priced at $14449
	 */
	@Override
	public double getValue() {
		return 14449;	}
	/**
	 * * @return Type of FordFocus
	 */
	public String type() {
		return "Compact Car";
	}
	/**
	 * @return make and model of FordFocus
	 */
	public String model() {
		return "Ford Focus";
	}
}
