package enrolledStudent;

/**
 * Employee Class inherits from Regular super class 
 * 
 * @author hansunho
 *
 */
public class Employee extends Regular {

	/**
	 * constructor for Employee Student
	 * 
	 * @param first
	 *            first name of Employee Student
	 * @param last
	 *            last name of Employee Student
	 * @param current
	 *            number of credits Employee student is currently enrolled in
	 * @param total
	 *            number of total credits Employee student has earned
	 */
	public Employee(String first, String last, double current, double total) {
		super(first, last, current, total);

	}

	/**
	 * returns Employee's student category : "Employee"
	 * 
	 */
	@Override
	public String getStudentCategory() {
		return "Employee Student";
	}

	
	/**
	 * checks if registration is valid
	 * 
	 * checks if the number of enrolled credits is within a valid range for
	 * employee student, which is 0~4 (inclusive) and return either true or
	 * false.
	 */
	@Override
	public boolean validRegistration() {
		if (currentEnrolledCredits >= 0 && currentEnrolledCredits <= 4)
			return true;
		else
			return false;
	}

}
