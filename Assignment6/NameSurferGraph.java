/*
 * File: NameSurferGraph.java
 * ---------------------------
 * This class represents the canvas on which the graph of
 * names is drawn. This class is responsible for updating
 * (redrawing) the graphs whenever the list of entries changes
 * or the window is resized.
 */

import acm.graphics.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;

public class NameSurferGraph extends GCanvas
	implements NameSurferConstants, ComponentListener {

	/**
	* Creates a new NameSurferGraph object that displays the data.
	*/
	public NameSurferGraph() {
		addComponentListener(this);
		entries = new ArrayList<NameSurferEntry>();
	}
	
	
	/**
	* Clears the list of name surfer entries stored inside this class.
	*/
	public void clear() {
		entries.clear();
		update();
	}
	
	
	/* Method: addEntry(entry) */
	/**
	* Adds a new NameSurferEntry to the list of entries on the display.
	* Note that this method does not actually draw the graph, but
	* simply stores the entry; the graph is drawn by calling update.
	*/
	public void addEntry(NameSurferEntry entry) {
		if (entries.indexOf(entry) == -1) {
			entries.add(entry);
			update();
		}
	}
	
	
	/**
	* Updates the display image by deleting all the graphical objects
	* from the canvas and then reassembling the display according to
	* the list of entries. Your application must call update after
	* calling either clear or addEntry; update is also called whenever
	* the size of the canvas changes.
	*/
	public void update() {
		removeAll();
		drawGrid();
		for (int i = 0; i < entries.size(); i++) {
			drawGraphWithEntry(entries.get(i), getColorForGraph(i));
		}
	}
	
	/**
	 * Draws the background grid for the graph.
	 */
	private void drawGrid() {
		double columnWidth = getWidth() / NDECADES;
		for (int i = 0; i < NDECADES; i++) {
			double x = i * columnWidth;
			add(new GLine(x, 0, x, getHeight()));
			String decade = " " + (START_DECADE + i * 10);
			GLabel label = new GLabel(decade);
			add(label, x, getHeight() - label.getDescent());
		}
		add (new GLine(0, GRAPH_MARGIN_SIZE, getWidth(), GRAPH_MARGIN_SIZE));
		add (new GLine(0, getHeight() - GRAPH_MARGIN_SIZE, getWidth(), getHeight() - GRAPH_MARGIN_SIZE));
	}
	
	/**
	 * Draws graph for NameSurferEntry with specified color.
	 */
	private void drawGraphWithEntry(NameSurferEntry entry, Color c) {
		double y = rankOnPlot(entry.getRank(0));
		GPoint startPoint = new GPoint(0, y);
		GLabel info = getInfoLabel(entry.getName(), entry.getRank(0));
		info.setLocation(LABEL_OFFSET, y - LABEL_OFFSET);
		info.setColor(c);
		add(info);
		
		for (int i = 1; i < NDECADES; i++) {
			double x = i * (getWidth() / NDECADES);
			y = rankOnPlot(entry.getRank(i));
			
			GLine line = new GLine(startPoint.getX(), startPoint.getY(), x, y);
			line.setColor(c);
			add(line);
			
			info = getInfoLabel(entry.getName(), entry.getRank(i));
			info.setLocation(x + LABEL_OFFSET, y - LABEL_OFFSET);
			info.setColor(c);
			add(info);
			
			startPoint.setLocation(x, y);
		}
	}
	
	/**
	 * Converts rank to its y-coordinate on the graph.
	 */
	private double rankOnPlot(int rank) {
		if (rank == 0) {
			return getHeight() - GRAPH_MARGIN_SIZE;
		} else {
			double graphHeight = getHeight() - 2 * GRAPH_MARGIN_SIZE;
			double scale = graphHeight / MAX_RANK;
			return GRAPH_MARGIN_SIZE + rank * scale;
		}
	}
	
	/**
	 * Constructs info label for plot.
	 */
	private GLabel getInfoLabel(String name, int rank) {
		String str = rank == 0 ? "*" : "" + rank;
		GLabel info = new GLabel(name + " " + str);
		info.setFont("Arial-12");
		return info;
	}
	
	/**
	 * Returns the color Nth plot on the graph.
	 */
	private Color getColorForGraph(int n) {
		switch (n % 4) {
			case 1: return Color.RED;
			case 2: return Color.BLUE;
			case 3: return Color.MAGENTA;
		}
		return Color.BLACK;
	}
	
	/* Implementation of the ComponentListener interface */
	public void componentHidden(ComponentEvent e) { }
	public void componentMoved(ComponentEvent e) { }
	public void componentResized(ComponentEvent e) { update(); }
	public void componentShown(ComponentEvent e) { }
	
	/* Private instance variables */
	private ArrayList<NameSurferEntry> entries;
}
