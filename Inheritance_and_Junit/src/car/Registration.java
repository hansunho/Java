package car;

/**
 * Interface Registration provides methods for registration information for car.
 * 
 * @author hansunho
 * 
 */
public interface Registration {

	/**
	 * sets and updates registration expiration date for car
	 * 
	 * @param date
	 *            new renewal date to be set for car
	 */
	public void setRenewalDate(String date);

	/**
	 * gets Registration number of car
	 * 
	 * @return Registration number for car
	 */
	public String getRegistrationNumber();

	/**
	 * gets renewal date of registration
	 * 
	 * @return Renewal date of registration for car
	 */
	public String getRenewalDate();
}
