/*
 * File: TextFieldExample.java
 * ---------------------------
 * This class displays a greeting whenever a name is entered
 */

import acm.program.*;
import java.awt.event.*;
import javax.swing.*;

public class TextFieldExample extends ConsoleProgram {
	
	public void init() {
		namefield = new JTextField(10);
		add(new JLabel("Name"), SOUTH);
		add(namefield, SOUTH);
		namefield.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == namefield) {
			println("Hello, " + namefield.getText());
		}
	}
	
	/* Private instance variables */
	private JTextField namefield;

}
