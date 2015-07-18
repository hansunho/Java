package car;

/**
 * This class extends Car and set some specifications unique for Chevrolet
 * Corvettet.
 * 
 * @author hansunho
 * 
 */
public class ChevroletCorvettet extends Car {
	/**
	 * constructor for ChevroletCorvettet. It sets renwalAmount to 500 since
	 * renewal fee for Chevrolet Corvettets.
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
	public ChevroletCorvettet(String Name, String Address, String RenewalDate,
			String RegistrationNumber) {
		super(Name, Address, RenewalDate, RegistrationNumber);
		super.renewalAmount = 500;
	}
	/**
	 * @return Registration number of car
	 */
	@Override
	public String getRegistrationNumber() {
		return super.registrationNumber;
	}
	/**
	 * @return Type of ChevroletCorvettet
	 */
	@Override
	public String getType() {
		return "Sports Car";
	}

	/**
	 * @return make and model of car
	 */
	@Override
	public String getModel() {
		return "Chevrolet Corvettet";
	}

	/**
	 * @return returns 49432 because Corvette is priced at $49432
	 */
	@Override
	public double getValue() {
		return 49432;
	}

	/**
	 * * @return Type of ChevroletCorvettet 
	 */
	public String type() {
		return "Sports Car";

	}

	/**
	 * @return make and model of car
	 */
	public String model() {
		return "Ford Focus";

	}

}
