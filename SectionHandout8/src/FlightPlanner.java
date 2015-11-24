/*
 * File: FlightPlanner
 * -------------------
 * This program reads in a file containing flight destinations from various cities,
 * and then allow the user to plan a round-trip flight route.
 */

import acm.program.*;
import acm.util.*;
import java.util.*;
import java.io.*;

public class FlightPlanner extends ConsoleProgram {
	
	/* Initializes the program */
	public void init() {
		loadDatabase();
	}
	
	/* Loads the database from a file specified by FILE_NAME constant */
	private void loadDatabase() {
		try {
			BufferedReader rd = new BufferedReader(new FileReader(FILE_NAME));
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				if (!line.equals("")) {
					parseLine(line);
				}
			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
	}
	
	/* Parses data from line and puts it to database instance variable */
	private void parseLine(String line) {
		int endCityIndex = line.indexOf("->");
		String city = line.substring(0, endCityIndex).trim();
		String destination = line.substring(endCityIndex + 2).trim();
		if (database.get(city) == null) {
			ArrayList<String> destinations = new ArrayList<String>();
			destinations.add(destination);
			database.put(city, destinations);
		} else {
			database.get(city).add(destination);
		}
	}
	
	/** Runs the program */
	public void run() {
		println("Welcome to Flight Planner!");
		chooseStartingCity();
		composeRoute();		
		printRoute();
	}
	
	/**
	 * Chooses the starting city from a database 
	 */
	private void chooseStartingCity() {
		println("Here's a list of all the cities in our database: ");
		printCollection(database.keySet());
		println("Let's plan a round-trip route!");
		while (true) {
			String city = readLine("Enter the starting city: ");
			if (database.keySet().contains(city)) {
				route.add(city);
				break;
			}
			println("Nice try! This city is not in our database.");
		}
	}
	
	/** 
	 * Compose the route by asking the user where does he want to fly
	 * from current chosen city, until he choose starting city. 
	 */
	private void composeRoute() {
		while (true) {
			String origin = route.get(route.size() - 1);
			println("From " + origin + " you can directly fly to: ");
			printCollection(database.get(origin));
			String destination = readLine("Where do you want to go from " + origin + "? ");
			if (!database.get(origin).contains(destination)) {
				println("You can't get to that city by a direct flight.");
				continue;
			}
			route.add(destination);
			if (destination.equals(route.get(0))) break;
		}
	}
	
	/** Prints the final route composed by the user */
	private void printRoute() {
		println("The route you've chosen is: ");
		for (int i = 0; i < route.size(); i++) {
			String separator = i == 0 ? "" : " -> ";
			print(separator + route.get(i));
		}
	}
	
	/** Prints out the collection of string, each string on new line */
	private void printCollection(Collection<String> collection) {
		for (String city : collection) {
			println(" " + city);
		}
	}
	
	/* Private constants */
	private static final String FILE_NAME = "flights.txt";
	
	/* Private instance variables */
	private Map<String, ArrayList<String>> database = new HashMap<String, ArrayList<String>>();
	private List<String> route = new ArrayList<String>();
}
