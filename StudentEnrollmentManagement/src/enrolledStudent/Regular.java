package enrolledStudent;

/**
 * Regular Class inherits EnrolledStudent class and provides methods and various fields for Regular and Employee Students 
 * 
 * @author hansunho
 *
 */
public class Regular extends EnrolledStudent {

	/**
	 * Fields
	 * 
	 * humanitiesCredits number of earned credits in Humanities division
	 * socialStudiesCredits number of earned credits in Social Studies division
	 * scienceCredits number of earned credits in Science division
	 * generalCredits number of general credits major string of major studies
	 */
	protected double humanitiesCredits;
	protected double socialStudiesCredits;
	protected double scienceCredits;
	protected double generalCredits;
	protected String major;

	/**
	 * constructor for a Regular Student. sets
	 * humanitiesCredits,socialStudiesCredits, scienceCredits, generalCredits,
	 * major as null.
	 * 
	 * @param first
	 *            first name of Regular student
	 * @param last
	 *            last name of Regular Student
	 * @param current
	 *            number of currently enrolled credits
	 * @param total
	 *            number of total earned credits
	 */
	public Regular(String first, String last, double current, double total) {
		super(first, last, current, total);
		humanitiesCredits = 0;
		socialStudiesCredits = 0;
		scienceCredits = 0;
		generalCredits = 0;
		major = "";
	}

	/**
	 * sets HumanitiesCredits
	 * 
	 * @param humanitiesCredits
	 *            number of Humanities credits to set
	 */
	protected void setHumanitiesCredits(double humanitiesCredits) {
		this.humanitiesCredits = humanitiesCredits;
	}

	/**
	 * sets socialStudiesCredits
	 * 
	 * @param socialStudiesCredits
	 *            number of Social Studies credits to set
	 */
	protected void setSocialStudiesCredits(double socialStudiesCredits) {
		this.socialStudiesCredits = socialStudiesCredits;
	}

	/**
	 * sets scienceCredits
	 * 
	 * @param scienceCredits
	 *            number of Science credits to set
	 */
	protected void setScienceCredits(double scienceCredits) {
		this.scienceCredits = scienceCredits;
	}

	/**
	 * sets generalCredits
	 * 
	 * @param generalCredits
	 *            number of general credits to set
	 */
	protected void setGeneralCredits(double generalCredits) {
		this.generalCredits = generalCredits;
	}

	/**
	 * sets major
	 * 
	 * @param major
	 *            major studies to set
	 */
	protected void setMajor(String major) {
		this.major = major;
	}

	/**
	 * return Student Category of Regular Student : "regular Student"
	 * 
	 */
	public String getStudentCategory() {
		return "Regular Student";
	}

	/**
	 * 
	 * @return number of earned Humanities Credits
	 */
	protected double getHumanitiesCredits() {
		return humanitiesCredits;
	}

	/**
	 * 
	 * @return number of earned Social Studies Credits
	 */
	protected double getSocialStudiesCredits() {
		return socialStudiesCredits;
	}

	/**
	 * 
	 * @return number of earned Science Credits.
	 */
	protected double getScienceCredits() {
		return scienceCredits;
	}

	/**
	 * 
	 * @return number of earned General credits
	 */
	protected double getGeneralCredits() {
		return generalCredits;
	}

	/**
	 * Returns major of student
	 */
	public String getMajor() {
		return major;
	}

	/**
	 * returns a string of Class Standing for student
	 * 
	 * returns a string of Class Standing appropriate for total number of earned
	 * credits of student. throws an exception if the total credits is not
	 * within ranges of valid numbers.
	 * 
	 */
	public String getClassStanding() throws Exception {
		if (totalCreditsEarned > 0 && totalCreditsEarned <= 11.5)
			return "First Year Semeseter 1";

		if (totalCreditsEarned >= 12 && totalCreditsEarned <= 27.5)
			return "First Year Semeseter 2";

		if (totalCreditsEarned >= 28 && totalCreditsEarned <= 43.5)
			return "Second Year Semeseter 1";

		if (totalCreditsEarned >= 44 && totalCreditsEarned <= 59.5)
			return "Second Year Semeseter 2";

		if (totalCreditsEarned >= 60 && totalCreditsEarned <= 75.5)
			return "Junior Semeseter 1";

		if (totalCreditsEarned >= 76 && totalCreditsEarned <= 91.5)
			return "Junior Semeseter 2";

		if (totalCreditsEarned >= 92 && totalCreditsEarned <= 107.5)
			return "Senior Semeseter 1";

		if (totalCreditsEarned >= 108 && totalCreditsEarned <= 123.5)
			return "Senior Semeseter 2";

		if (totalCreditsEarned > 123.5)
			return "Total credit has exceeded Senior Semeseter 2 standing";

		else
			throw new Exception();

	}

	//
	//
	//
	//

	/**
	 * checks if student is making good progress towards a degree
	 * 
	 * Check if a regular student is making good progress towards a degree in
	 * terms of earning enough credits in different divisions.
	 * makingGoodProgress checks that at least 10% of the student's total
	 * credits are in each of humanities, social studies, and science divisions.
	 */
	public boolean makingGoodProgress() {
		if (humanitiesCredits / totalCreditsEarned >= 0.1
				&& socialStudiesCredits / totalCreditsEarned >= 0.1
				&& scienceCredits / totalCreditsEarned >= 0.1)
			return true;
		else
			return false;
	}

	//
	//

	/**
	 * checks if student is registered for a valid number of credits
	 * 
	 * check if this student has registered for valid number of credits, which
	 * is between 12 and 18 credits inclusive for regular students.
	 */
	public boolean validRegistration() {
		if (currentEnrolledCredits <= 18 && currentEnrolledCredits >= 12)
			return true;
		else
			return false;

	}

}
