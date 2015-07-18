package car;
/**
 * Abstract class Car extends its superclass Owner and implements interfaces
 * Registration and CarDescription. Car provides essential qualities and a
 * platform for cars to build upon.
 * 
 * @author hansunho
 * 
 */
public abstract class Car extends Owner implements Registration, CarDescription {
	/**
	 * registrationNumber Registration number of a car issued by government
	 */
	public String registrationNumber;
	/**
	 * renewalDate required date for car to be re-registered.
	 */
	public String renewalDate;
	/**
	 * renewalAmount Cost of renewing registration of a car
	 */
	public double renewalAmount;

	/**
	 * constructor for Car
	 * 
	 * @param Name name of car owner
	 * @param Address address of car owner 
	 * @param RenewalDate required date for car to be re-registered.
	 * @param RegistrationNumber Registration number of car issued by government
	 */
	public Car(String Name, String Address, String RenewalDate,
			String RegistrationNumber) {
		super(Name, Address);
		renewalDate = RenewalDate;
		registrationNumber = RegistrationNumber;
	}
	/**
	 * sets the registration renewal date of car
	 * 
	 * @param date date to be set for registration renewal
	 */
	@Override
	public void setRenewalDate(String date) {
		renewalDate = date;
	}
	/**
	 * returns Registration renewal date of car
	 * 
	 * @return renewalDate required date for car to be re-registered. 
	 */
	@Override
	public String getRenewalDate() {
		return renewalDate;
	}
	//abstract public void setRenewalAmount(); included in the constructors of sub-classes of Cars
	abstract public String type();
	abstract public String model();
}
