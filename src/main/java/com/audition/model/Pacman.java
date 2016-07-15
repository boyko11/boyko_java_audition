package com.audition.model;

public class Pacman {

	private Direction currentDirection;
	private boolean moving;
	
	public Pacman() {
		currentDirection = Direction.UP;
		moving = false;
	}
	
	public Direction getCurrentDirection() {
		return currentDirection;
	}
	
	public void setDirection(Direction direction) {
		this.currentDirection = direction;
	}
	
	public boolean isMoving() {
		return moving;
	}
	
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	
	public void moveUP() {
		
		this.moving = true;
		this.currentDirection = Direction.UP; 
	}

	public void moveLEFT() {
		
		this.moving = true;
		this.currentDirection = Direction.LEFT; 
	}
	
	public void moveDOWN() {
		
		this.moving = true;
		this.currentDirection = Direction.DOWN; 
	}
	
	public void moveRIGHT() {
		
		this.moving = true;
		this.currentDirection = Direction.RIGHT; 
	}
	
}
