import acm.program.*;
import acm.graphics.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class EtchASketch extends GraphicsProgram {
	
	public void init() {
		add(new JButton("North"), SOUTH);
		add(new JButton("South"), SOUTH);
		add(new JButton("East"), SOUTH);
		add(new JButton("West"), SOUTH);
		cross = new GCross(SIZE, SIZE);
		addActionListeners();
	}
	
	public void run() {
		lastX = getWidth() / 2;
		lastY = getHeight() / 2;
		add(cross, lastX, lastY);
	}
	
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		double x = 0;
		double y = 0;
		if (cmd.equals("North")) {
			y = -DIFF;
		} else if (cmd.equals("South")) {
			y = DIFF;
		} else if (cmd.equals("East")) {
			x = DIFF;
		} else if (cmd.equals("West")) {
			x = -DIFF;
		}
		cross.move(x, y);
		GLine line = new GLine(lastX, lastY, lastX + x, lastY + y);
		line.setColor(Color.RED);
		add(line);
		lastX += x;
		lastY += y;
	}
	
	class GCross extends GCompound {
		public GCross(double width, double height) {
			add(new GLine(-width, -height, width, height));
			add(new GLine(width, -height, -width, height));
		}
	}
	
	/* Constants */
	private static final double SIZE = 10;
	private static final double DIFF = 20;
	
	/* Private instance variables */
	private double lastX;
	private double lastY;
	private GCompound cross;
}
