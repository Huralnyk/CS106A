/*
 * File: Employee.java
 * -------------------
 * This class keeps track of the following pieces of data about an employee:
 * the name of the employee, the employee's nine-digit tax id number,
 * the employee's job title, a flag indicating whether the employee is still
 * active, and the employee's annual salary.
 * 
 * Based on the class Student from Chapter 6, "The Art and Science of Java" by
 * Eric Roberts. 
 */

public class Employee {
	
	/**
	 * Creates a new Employee with the specified name and tax id number.
	 * @param name	The employee's name as a String
	 * @param taxID	The employee's tax id number as an int
	 */
	public Employee(String name, int taxID) {
		if (taxID < 100000000 || taxID > 999999999) {
			throw new IllegalArgumentException("The tax ID number should consist nine digits.");
		}
		this.name = name;
		this.taxID = taxID;
	}
	
	/**
	 * Gets the name of this employee.
	 * @return The name of this employee
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the tax id of this employee.
	 * @return The tax id of this employee
	 */
	public int getTaxID() {
		return taxID;
	}
	
	/**
	 * Sets the job title.
	 * @param title The new job title
	 */
	public void setJobTitle(String title) {
		jobTitle = title;
	}
	
	/**
	 * Gets the job title of this employee.
	 * @return The job title of this employee
	 */
	public String getJobTitle() {
		return jobTitle;
	}
	
	/**
	 * Sets whether this employee is still active.
	 * @param flag Flag indicating whether this employee is still active
	 */
	public void setActive(boolean flag) {
		isActive = flag;
	}
	
	/**
	 * Checks whether this employee is still active. 
	 * @return Flag indicating whether this employee is still active
	 */
	public boolean isActive() {
		return isActive;
	}
	
	/**
	 * Sets the annual salary of this employee.
	 * @param amount The new amount of annual salary
	 */
	public void setSalary(double amount) {
		salary = amount;
	}
	
	/**
	 * Gets the annual salary of this employee.
	 * @return The annual salary of this employee
	 */
	public double getSalary() {
		return salary;
	}
	
	/** Private instance variables */
	private String name;		// The employee's name
	private int taxID;			// The employee's nine-digit tax number
	private String jobTitle;	// The employee's job title
	private boolean isActive;	// Flag indicating whether employee's is still active
	private double salary;		// The employee's annual salary
}
