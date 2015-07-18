package enrolledStudent;

/**
 * Alum inherits Abstract NonRegular class and creates a class specific for Alum Students 
 * 
 * @author hansunho
 *
 */
public class Alum extends NonRegular {

	/**
	 * major major studies of student
	 */
	protected String major;

	/**
	 * constructor for Alum Student. initialize major as null
	 * 
	 * @param first
	 *            first name of Alum Student
	 * @param last
	 *            last name of Alum Student
	 * @param current
	 *            number of credits alum student is currently enrolled in
	 * @param total
	 *            number of total  credits alum student has earned
	 */
	Alum(String first, String last, double current, double total) {
		super(first, last, current, total);
		major = "";
	}


	/**
	 * 
	 * @param Major
	 *            major to be set
	 */
	public void setMajor(String Major) {
		major = Major;
	}

	/**
	 * returns major of alum student
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * returns the student category of alum student : "Alum"
	 */
	public String getStudentCategory() {
		return "Alum";
	}

}
