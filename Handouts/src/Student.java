/**
 * The Student class keeps track of the following pieces of data
 * about a student: the student's name, ID number, and the number
 * of credits the student has earned toward graduation.
 * All of this information is entirely private to the class.
 * Clients can obtain this information only by using the various
 * methods defined by the class.
 */

public class Student {
	
	/* Public constants */

	/** The number of units required for graduation */
	public static final double UNITS_TO_GRADUATE = 180.0;


	/**
	 * Creates a new Student object with the specified name and ID.
	 * @param studentName The student's name as a String
	 * @param studentID The student's ID number as an int
	 */
	public Student(String studentName, int studentID) {
		name = studentName;
		ID = studentID;
	}

	/**
	 * Gets the name of this student.
	 * @return The name of this student
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the ID number of this student.
	 * @return The ID number of this student
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Sets the number of units earned.
	 * @param units The new number of units earned
	 */
	public void setUnits(double units) {
		unitsEarned = units;
	}

	/**
	 * Gets the number of units earned.
	 * @return The number of units this student has earned
	 */
	public double getUnits() {
		return unitsEarned;
	}

	/**
	 * Increments the number of units earned.
	 * @param additionalUnits The additional number of units earned
	 */
	public void incrementUnits(double additionalUnits) {
		unitsEarned += additionalUnits;
	}
	
	/**
	 * Gets the number of units earned.
	 * @return Whether the student has enough units to graduate
	 */
	public boolean hasEnoughUnits() {
		return (unitsEarned >= UNITS_TO_GRADUATE);
	}
	
	
	/**
	 * Creates a string identifying this student.
	 * @return The string used to display this student
	 */
	public String toString() {
		return name + " (#" + ID + ")";
	}


	/* Private instance variables */
	private String name; 		/* The student's name         */
	private int ID;     		/* The student's ID number    */
	private double unitsEarned; /* The number of units earned */

}