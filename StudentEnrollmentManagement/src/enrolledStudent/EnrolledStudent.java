package enrolledStudent;

/**
 * EnrolledStudent Class provides setters, getters, general format for students
 * 
 * @author hansunho
 *
 */
public abstract class EnrolledStudent {

	
	/**
	 * first name of respective student
	 */
	protected String firstName;

	/**
	 * last name of respective student
	 */
	protected String lastName;

	/**
	 * number of credits enrolled in current semester
	 */
	protected double currentEnrolledCredits;

	/**
	 * sum of all credits earned by this student
	 */
	protected double totalCreditsEarned;

	/**
	 * constructor for a student
	 * 
	 * @param first
	 *            string of a first name of student
	 * @param last
	 *            string of a last name of student
	 * @param current
	 *            number of credits student is currently enrolled in
	 * @param total
	 *            number of total credits student has earned
	 */

	protected static int totalstu;
	public EnrolledStudent(String first, String last, double current,
			double total) {
		firstName = first;
		lastName = last;
		currentEnrolledCredits = current;
		totalCreditsEarned = total;
	}

	/**
	 * 
	 * @param firstname
	 *            first name to set
	 */
	public void setFirstName(String firstname) {
		firstName = firstname;
	}

	/**
	 * 
	 * @param lastname
	 *            last name to set
	 */
	public void setLastName(String lastname) {
		lastName = lastname;
	}

	/**
	 * 
	 * @param currentcredits
	 *            current credits to set for student
	 */
	public void setCurrentEnrolledCredits(double currentcredits) {
		currentEnrolledCredits = currentcredits;
	}

	/**
	 * 
	 * @param totalCreditsEarned
	 *            total credits earned to set for student
	 */


	public void setTotalCreditsEarned(double totalCreditsEarned) {
		this.totalCreditsEarned = totalCreditsEarned;
	}

	
	/**
	 * 
	 * @return first name of student
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * 
	 * @return last name of student
	 */

	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @return Current number of enrolled credits 
	 */
	public double getCurrentEnrolledCredits() {
		return currentEnrolledCredits;
	}

	/**
	 * 
	 * @return total number of credits
	 */
	public double getTotalCreditsEarned() {
		return totalCreditsEarned;
	}
	
	
	public static int getTotal()
	{
		return totalstu;
	}

	// methods
	

	public abstract String getStudentCategory();

	public abstract String getClassStanding() throws Exception;

	public abstract boolean makingGoodProgress() throws Exception;

	public abstract boolean validRegistration();

	public abstract String getMajor() throws Exception;

}
