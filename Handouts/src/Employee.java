/**
 * File: Employee.java
 * -------------------
 * Class which describes the Employee variable type.
 */

public class Employee {
	
	public Employee(String newName, int newId) {
		name = newName;
		taxId = newId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	
	public int getTaxId() {
		return taxId;
	}
	
	/* Employee instance variables */
	private String name;
	private int taxId;
	private String title;
	private boolean active;
	private int salary;
}
