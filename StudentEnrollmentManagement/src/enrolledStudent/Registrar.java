package enrolledStudent;

import java.util.ArrayList;
import enrolledStudent.EnrolledStudent;
import enrolledStudent.Alum;
import enrolledStudent.NonRegular;
import enrolledStudent.Regular;
import enrolledStudent.Special;
import enrolledStudent.Employee;

/**
 * Registrar Class contains a method that contains an ArrayList<EnrolledStudent>
 * which stores all four types of students ans prints their information
 * accordingly.
 * 
 * @author hansunho
 * 
 */
public class Registrar {

	/**
	 * checks the arrayList and prints all of students with all available
	 * information in Arraylist which takes EnrolledStudent type students
	 * including Alum, Employee, Special, and regular Students.
	 * 
	 * printStudents methods iteratively prints students' first and last names,
	 * Student category, major, Class Standing, making good progress(T/F),
	 * current enrolled credits, total earned credits, and valid
	 * Registration(T/F) for all students in ArrayList. First try&catch
	 * statements checks if getMajor() throws an exception, if so skip printing
	 * Major, ClassStanding, and makingGoodProgress() since major-less students
	 * are special students and do not have those characteristics defined. if
	 * getMajor() does not throw an exception, further check if
	 * getClassStanding() throws an exception. If so, student is
	 * NonRegular(Alum) so skip getClassStanding and makingGoodProgress calls.
	 * If doesn't throw an exception, print both class standing and
	 * makningGoodProgress.
	 * 
	 * @param array
	 *            ArrayList that takes objects with type EnrolledStudent
	 */

	public static void totalNonRegularStudents(ArrayList<EnrolledStudent> array) {
		int counter = 0;

		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).getClass() != enrolledStudent.Regular.class
					&& array.get(i).getClass() != enrolledStudent.Employee.class)
				counter++;
		}

		System.out.println("number of non-regular students: " + counter);

	}

	public static void printStudents(ArrayList<EnrolledStudent> array) {

		for (int i = 0; i < array.size(); i++) {

			System.out.println("Name: " + array.get(i).getFirstName() + " "
					+ array.get(i).getLastName());

			System.out.println("Student Category: "
					+ array.get(i).getStudentCategory());

			/**
			
			 */
			try {

				System.out.println("Major: " + array.get(i).getMajor());
				try {

					System.out.println("Class Standing: "
							+ array.get(i).getClassStanding());
					System.out.println("Making Good Progress? (T/F):"
							+ array.get(i).makingGoodProgress());
				} catch (Exception e) {

				}

			}

			catch (Exception e) {
			}
			System.out.println("Current Enrolled Credits: "
					+ array.get(i).getCurrentEnrolledCredits());
			System.out.println("Total Credits Earned: "
					+ array.get(i).getTotalCreditsEarned());
			System.out.println("Valid Registration? (T/F): "
					+ array.get(i).validRegistration());

			System.out.println();
		}

		System.out.println("End of List");
	}

	public static void main(String[] argv) {

		/**
		 * Create an ArrayList that take objects with type EnrolledStudent
		 */
		ArrayList<EnrolledStudent> studentList = new ArrayList<EnrolledStudent>();
		/**
		 * alum1-student1 has 0 CurrentRnrolledCredits,0 TotalCreditsEarned, and
		 * major Biology.Student Category should return Alum if the method was
		 * implemented correctly. Since Alum does not have class Standing and
		 * not making progress towards a degree, they should both throw
		 * exceptions resulting in skipping both categories from being printed.
		 * Since 0<=CurrentEnrolledCredits<=4, valid registration should return
		 * true.
		 */
		Alum alum1 = new Alum("alum1", "Student1", 0, 0);
		alum1.setMajor("Biology");

		/**
		 * alum2-Student2 has 4 CurrentRnrolledCredits,10 TotalCreditsEarned,
		 * and major Physics.Student Category should return Alum if the method
		 * was implemented correctly. Since Alum does not have class Standing
		 * and not making progress towards a degree, they should both throw
		 * exceptions resulting in skipping both categories from being
		 * printed.Since 0<=CurrentEnrolledCredits<=4, valid registration should
		 * return true.
		 */
		Alum alum2 = new Alum("alum2", "Student2", 4, 10);
		alum2.setMajor("Physics");

		/**
		 * alum3-Student3 has 5 CurrentRnrolledCredits,30 TotalCreditsEarned,
		 * and major Sociology.Student Category should return Alum if the method
		 * was implemented correctly. Since Alum does not have class Standing
		 * and not making progress towards a degree, they should both throw
		 * exceptions resulting in skipping both categories from being
		 * printed.Since 4<CurrentEnrolledCredits, valid registration should
		 * return false.
		 */
		Alum alum3 = new Alum("alum3", "Student3", 5, 30);
		alum2.setMajor("Sociology");

		/**
		 * Special1-student1 has -4 CurrentRnrolledCredits,56
		 * TotalCreditsEarned. since Special Students do not have major, class
		 * Standing and not making progress towards a degree, they should all
		 * throw exceptions resulting in skipping all categories from being
		 * printed. Since CurrentEnrolledCredits<0 , valid registration should
		 * return false. Student Category should return Special if the method
		 * was implemented correctly.
		 */
		Special spec1 = new Special("Special1", "student1", -4, 56);

		/**
		 * Special2-student2 has 3 CurrentRnrolledCredits,126
		 * TotalCreditsEarned. since Special Students do not have major, class
		 * Standing and not making progress towards a degree, they should all
		 * throw exceptions resulting in skipping all categories from being
		 * printed. Since 0<=CurrentEnrolledCredits<=4, , valid registration
		 * should return true. Student Category should return Special if the
		 * method was implemented correctly.
		 */
		Special spec2 = new Special("Special2", "student2", 3, 126);

		/**
		 * Special3-student3 has 14 CurrentRnrolledCredits,76
		 * TotalCreditsEarned. since Special Students do not have major, class
		 * Standing and not making progress towards a degree, they should all
		 * throw exceptions resulting in skipping all categories from being
		 * printed. Since 4<CurrentEnrolledCredits, , valid registration should
		 * return false. Student Category should return Special if the method
		 * was implemented correctly.
		 */
		Special spec3 = new Special("Special3", "student3", 14, 76);

		/**
		 * regular1-Student1 has 17 CurrentRnrolledCredits,100
		 * TotalCreditsEarned, Economics Major.since
		 * 92<=totalCreditsEarned<=107.5, it should return class standing of
		 * Senior Semester 2. since all of
		 * humanitiesCredits,SocialStudiesCredits, and ScienceCredits are more
		 * than 10% of TotalCreditsEarned it should return true for making good
		 * progress. Since 12<=CurrentEnrolledCredits<=18, , valid registration
		 * should return true. Student Category should return Regular if the
		 * method was implemented correctly.
		 */
		Regular reg1 = new Regular("regular1", "Student1", 18, 100);
		reg1.setMajor("Economics");
		reg1.setHumanitiesCredits(11);
		reg1.setSocialStudiesCredits(11);
		reg1.setScienceCredits(11);
		reg1.setGeneralCredits(66);

		/**
		 * regular2-Student2 has 12 CurrentRnrolledCredits,40
		 * TotalCreditsEarned, English Major.since 28<=totalCreditsEarned<=43.5,
		 * it should return class standing of Second Year Semester 1.Even though
		 * SocialStudiesCredits and ScienceCredits are more than 10% of
		 * TotalCreditsEarned, HumanitiesCredits is only 5% (2/40) of Total
		 * credits.So it should return false for making good progress(all three
		 * studies should have 10% of higher to be making a good progress. Since
		 * 12<=CurrentEnrolledCredits<=18, , valid registration should return
		 * true. Student Category should return Regular if the method was
		 * implemented correctly.
		 */
		Regular reg2 = new Regular("regular2", "Student2", 12, 40);
		reg2.setMajor("English");
		reg2.setHumanitiesCredits(2);
		reg2.setSocialStudiesCredits(25);
		reg2.setScienceCredits(8);
		reg2.setGeneralCredits(66);

		/**
		 * regular3-Student3 has 19 CurrentRnrolledCredits,24
		 * TotalCreditsEarned, Economics Major.since
		 * 12<=totalCreditsEarned<=27.5, it should return class standing of
		 * First Year Semester 2. since all of
		 * humanitiesCredits,SocialStudiesCredits, and ScienceCredits are more
		 * than 10% of TotalCreditsEarned it should return true for making good
		 * progress. Since 18<CurrentEnrolledCredits, , valid registration
		 * should return false. Student Category should return Regular if the
		 * method was implemented correctly.
		 */
		Regular reg3 = new Regular("regular3", "Student3", 19, 24);
		reg3.setMajor("Economics");
		reg3.setHumanitiesCredits(10);
		reg3.setSocialStudiesCredits(16);
		reg3.setScienceCredits(16);
		reg3.setGeneralCredits(66);

		/**
		 * Employee1-Student1 has 1.5 CurrentRnrolledCredits, 8
		 * TotalCreditsEarned,and Philosophy Major. since
		 * 0<=totalCreditsEarned<=11.5, it should return class standing of First
		 * Year Semester 1. since all of humanitiesCredits,SocialStudiesCredits,
		 * and ScienceCredits are more than 10% of TotalCreditsEarned it should
		 * return true for making good. Since 0<=CurrentEnrolledCredits<=4,
		 * valid registration should return true.Student Category should return
		 * Employee if the method was implemented correctly.
		 */

		Employee emp1 = new Employee("Employee1", "Student1", 1.5, 8.0);
		emp1.setMajor("Philosophy");
		emp1.setHumanitiesCredits(1);
		emp1.setSocialStudiesCredits(1);
		emp1.setScienceCredits(1);
		emp1.setGeneralCredits(1);

		/**
		 * Employee2-Student2 has 1 CurrentRnrolledCredits,123.5
		 * TotalCreditsEarned,and Anthropology Major. since
		 * 108<=totalCreditsEarned<=123.5, it should return class standing of
		 * Senior Semester 2. since all of
		 * humanitiesCredits,SocialStudiesCredits, and ScienceCredits are less
		 * than 10% of TotalCreditsEarned it should return false for making good
		 * progress. Since 0<=CurrentEnrolledCredits<=4, valid registration
		 * should return true.Student Category should return Employee if the
		 * method was implemented correctly.
		 */
		Employee emp2 = new Employee("Employee2", "Student2", 1, 123.5);
		emp2.setMajor("Anthropology");
		emp2.setHumanitiesCredits(10);
		emp2.setSocialStudiesCredits(8);
		emp2.setScienceCredits(0);
		emp2.setGeneralCredits(66);

		/**
		 * Employee2-Student2 has 6 CurrentRnrolledCredits,144
		 * TotalCreditsEarned,and German Major. since 123.5<totalCreditsEarned,
		 * it should return class standing exceeded Senior Semeseter2. Even
		 * though humanitiesCredits,SocialStudiesCredits are more than 10% of
		 * TotalCreditsEarned, , ScienceCreditsis less than 10% of total
		 * credits. So it should return false for making good progress. Since
		 * 4<CurrentEnrolledCredits, valid registration should return
		 * false.Student Category should return Employee if the method was
		 * implemented correctly.
		 */
		Employee emp3 = new Employee("Employee3", "Student3", 6, 144.0);
		emp3.setMajor("German");
		emp3.setHumanitiesCredits(20);
		emp3.setSocialStudiesCredits(26);
		emp3.setScienceCredits(0);
		emp3.setGeneralCredits(66);

		/**
		 * add students in arraylist
		 */
		studentList.add(alum1);
		studentList.add(alum2);
	//	studentList.add(alum3);
		studentList.add(spec1);
		studentList.add(spec2);
		studentList.add(spec3);
		studentList.add(reg1);
		studentList.add(reg2);
		studentList.add(reg3);
		studentList.add(emp1);
		studentList.add(emp2);
		studentList.add(emp3);

		System.out.println(emp3.getTotal());
		//totalNonRegularStudents(studentList);

	}
}