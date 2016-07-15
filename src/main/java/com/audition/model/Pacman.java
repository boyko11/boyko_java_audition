package com.audition.model;

public class Pacman {

	private Direction currentDirection;
	
	public Pacman() {
		currentDirection = Direction.UP;
	}
	
	public Direction getCurrentDirection() {
		return currentDirection;
	}
}
