package car;

/**
 * This class contains information regarding owner of vehicle and methods to get
 * and set that information
 * 
 * @author hansunho
 * 
 */
public class Owner {

	public Owner(String name, String address) {
		Name = name;
		Address = address;
	}

	/**
	 * Name name of car owner
	 */
	protected String Name = null;

	/**
	 * Address address of car owner
	 */
	protected String Address = null;

	/**
	 * gets name of owner
	 * 
	 * @return name of vehicle owner
	 */
	public String getName() {
		return Name;
	}

	/**
	 * sets name of owner
	 * 
	 * @param name
	 *            name of vehicle owner
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * gets Address of owner
	 * 
	 * @return Address of vehicle owner
	 */
	public String getAddress() {
		return Address;
	}

	/**
	 * sets Address of owner
	 * 
	 * @param address
	 *            Address of vehicle owner
	 */
	public void setAddress(String address) {
		Address = address;
	}
}
