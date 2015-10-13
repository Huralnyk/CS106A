public class Frosh extends Student {

	/* constructor */
	public Frosh(String name, int id) {
		super(name, id); // calls Student constructor
		setUnits(0);
	}

	public String toString() {
    	// studentID and studentName are private,
    	// so they are not directly accessible, even
    	// in subclass!  Must use public "getters".
    	return ("Frosh: " + getName() + 
                 " (#" + getID() + ")");
	}
}