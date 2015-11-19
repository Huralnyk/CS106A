/*
 * File: UfoGame.java
 * ------------------
 * This program plays a game where the user tries to
 * shoot a UFO before the UFO "lands".
 */

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;

public class UfoGame extends GraphicsProgram {
	
	/** Size and speed of UFO */
	private static final int UFO_WIDTH = 40;
	private static final int UFO_HEIGHT = UFO_WIDTH / 2;
	private static final int UFO_SPEED = 5;
	
	/** Size and speed of bullets */
	private static final int BULLET_SPEED = 10;
	private static final int BULLET_DIAM = 10;
	
	/** Animation cycle delay */
	private static final int DELAY = 10;
	
	public void run() {
		setup();
		while (!gameIsOver()) {
			moveUFO();
			moveBullet();
			checkForCollision();
			pause(DELAY);
		}
	}
	
	/** Setup UFO and add mouse listeners */
	private void setup() {
		ufo = new GRect(UFO_WIDTH, UFO_HEIGHT);
		ufo.setFilled(true);
		add(ufo, getWidth(), 0); // UFO starts at top right
		ufoToLeft = true;
		addMouseListeners();
	}
	
	/** 
	 * Determines if game is over -- true if either
	 * the UFO is destroyed or if the UFO lands.
	 */
	private boolean gameIsOver() {
		return (ufo == null) ||
				(ufo.getY() >= getHeight() - UFO_HEIGHT);
	}
	
	/** 
	 * When mouse is clicked create bullet, unless a bullet
	 * already exists.
	 */
	public void mouseClicked(MouseEvent e) {
		if (bullet == null) {
			bullet = new GOval(BULLET_DIAM, BULLET_DIAM);
			bullet.setFilled(true);
			bullet.setColor(Color.RED);
			add(bullet, (getWidth() - BULLET_DIAM) / 2,
					getHeight() - BULLET_DIAM);
		}
	}
	
	/**
	 * Moves UFO, if UFO has moved to the edge of screen, moves
	 * UFO down and changes UFO direction.
	 */
	private void moveUFO() {
		if (ufoToLeft) {
			ufo.move(-UFO_SPEED, 0);
			if (ufo.getX() <= 0) {
				ufoToLeft = false;
				ufo.move(0, UFO_HEIGHT);
			}
		} else {
			ufo.move(UFO_SPEED, 0);
			if (ufo.getX() >= getWidth() - UFO_WIDTH) {
				ufoToLeft = true;
				ufo.move(0, UFO_HEIGHT);
			}
		}
	}
	
	/**
	 * Moves bullet
	 */
	private void moveBullet() {
		if (bullet != null) {
			bullet.move(0, -BULLET_SPEED);
		}
	}
	
	/**
	 * Checks for bullet interaction with the world
	 * (either colliding with the UFO or moving offscreen).
	 */
	private void checkForCollision() {
		collideWithUFO();
		moveOffscreen();
	}
	
	/**
	 * Checks to see if UFO and bullet collide, if so
	 * bullet and UFO are removed and both variables are
	 * set to null.
	 */
	private void collideWithUFO() {
		if (bullet != null) {
			GObject collObj = getElementAt(bullet.getX(), bullet.getY());
			if (collObj != null) {
				remove(ufo);
				remove(bullet);
				ufo = null;
				bullet = null;
			}
		}
	}
	
	/**
	 * Determines if bullet has moved of screen,
	 * if it has, removes bullet, sets variable to null.
	 */
	private void moveOffscreen() {
		if (bullet != null) {
			if (bullet.getY() <= - BULLET_DIAM) {
				remove(bullet);
				bullet = null;
			}
		}
	}
	/* Private instance variables */
	private GRect ufo;
	private GOval bullet;
	private boolean ufoToLeft; // when true, UFO is moving to left
}