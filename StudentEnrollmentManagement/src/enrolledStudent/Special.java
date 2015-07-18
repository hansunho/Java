package enrolledStudent;
/**
 * Special class inherits NonRegular class and provides methods for Special students
 * 
 * @author hansunho
 *
 */
public class Special extends NonRegular {

	/**
	 * constructor for Special Student
	 * 
	 * @param first
	 *            first name of Special Student
	 * @param last
	 *            last name of Special Student
	 * @param current
	 *            number of credits Special student is currently enrolled in
	 * @param total
	 *            number of total credits Special student has earned
	 */
	Special(String first, String last, double current, double total) {
		super(first, last, current, total);
	}

	/**
	 * returns the student category of Special Student : "Special"
	 */
	public String getStudentCategory() {
		return "Special";
	}

	/**
	 * returns major of Special Student
	 * However, Special Students do not have majors, so throw exceptions.
	 */
	public String getMajor() throws Exception {
		throw new Exception("Special students do not have a major");
	}

}
