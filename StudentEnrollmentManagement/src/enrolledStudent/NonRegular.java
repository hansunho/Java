package enrolledStudent;

/**
 * NonRegular class inherits abstract EnrolledStudent class and provides a general format for Speciala and Alum Students. 
 * 
 * @author hansunho
 *
 */
public abstract class NonRegular extends EnrolledStudent {

	/**
	 * 
	 * @param first
	 *            first name of student
	 * @param last
	 *            last name of student
	 * @param current
	 *            number of credits currently enrolled
	 * @param total
	 *            total number of earned credits
	 */

	NonRegular(String first, String last, double current, double total) {
		super(first, last, current, total);

		super.totalstu += 1;
	}

	/**
	 * returns a string of Class Standing for student
	 * 
	 * Non-Regular students do not have class standing, so throw exception
	 */
	public String getClassStanding() throws Exception {
		throw new Exception(
				"Class Standing cannot be found in Non-Regular Student");

	}

	/**
	 * checks if student is making good progress towards a degree
	 * 
	 *  Non-regular students are not working towards a degree, so throw exception
	 */
	public boolean makingGoodProgress() throws Exception {
		throw new Exception(
				"Progress report is unavailable for Non-Regular Student");
	}

	
	/**
	 * checks if student is registered for a valid number of credits
	 * 
	 * Return True if currentEnrolledCredits is between 0 and 4 (inclusive) otherwise return false
	 */
	public boolean validRegistration() {
		if (currentEnrolledCredits >= 0 && currentEnrolledCredits <= 4)
			return true;
		else
			return false;
	}
}
