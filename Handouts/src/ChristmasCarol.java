/**
 * File: ChristmasCarol.java
 * -------------------------
 * An example program that creates three Employee objects.
 */

import acm.program.*;

public class ChristmasCarol extends ConsoleProgram {
	
	public void run() {
		Employee ceo = new Employee("Ebenezer Scrooge", 161803399);
		Employee partner = new Employee("Jacob Marley", 271828182);
		Employee clerk = new Employee("Bob Cratchit", 314159265);
		
		ceo.setTitle("Ceo");
		partner.setTitle("Former Partner");
		clerk.setTitle("Clerk");
		
		ceo.setActive(true);
		partner.setActive(false);
		clerk.setActive(true);
		
		ceo.setSalary(1000);
		partner.setSalary(0);
		clerk.setSalary(25);
	}

}
