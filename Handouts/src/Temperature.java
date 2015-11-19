/*
 * File: Temperature.java
 * ----------------------
 * This program converts back and forth between Fahrenheit
 * and Celsius temperatires
 */

import acm.gui.*;
import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;
import javax.swing.*;

public class Temperature extends Program {
	
	public void init() {
		setLayout(new TableLayout(2, 3));
		
		fahrenField = new IntField(32);
		fahrenField.setActionCommand("F -> C");
		fahrenField.addActionListener(this);
		
		celsiusField = new IntField(0);
		celsiusField.setActionCommand("C -> F");
		celsiusField.addActionListener(this);
		
		add(new JLabel("Degrees Fahrenheit"));
		add(fahrenField);
		add(new JButton("F -> C"));
		
		add(new JLabel("Degrees Celsius"));
		add(celsiusField);
		add(new JButton("C -> F"));
		
		addActionListeners();
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("F -> C")) {
			int f = fahrenField.getValue();
			int c = GMath.round((5.0 / 9.0) * (f - 32));
			celsiusField.setValue(c);
		} else if (cmd.equals("C -> F")) {
			int c = celsiusField.getValue();
			int f = GMath.round(((9.0 / 5.0) * c) + 32);
			fahrenField.setValue(f);
		}
	}
	
	/* Private instance variables */
	private IntField fahrenField;
	private IntField celsiusField;
}