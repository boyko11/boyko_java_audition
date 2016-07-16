package com.audition.model;

public class Pacman {

	private Direction currentDirection;
	private BoardLocation currentBoardLocation;
	private boolean moving;
	
	public Pacman(BoardLocation boardLocation) {
		
		currentDirection = Direction.UP;
		currentBoardLocation = boardLocation;
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
	
	public boolean moveUP() {
		
		this.currentDirection = Direction.UP;
		
		BoardLocation locationDirectedTo = currentBoardLocation.getBoard()[currentBoardLocation.getRow() - 1][currentBoardLocation.getColumn()];
		if(locationDirectedTo.isWall()) {
			this.moving = false;
			return false;
		}
		
		this.moving = true;
		return true;
	}

	public boolean moveLEFT() {
		
		this.currentDirection = Direction.LEFT;
		
		BoardLocation locationDirectedTo = currentBoardLocation.getBoard()[currentBoardLocation.getRow()][currentBoardLocation.getColumn() - 1];
		
		if(locationDirectedTo.isWall()) {
			this.moving = false;
			return false;
		}
		
		this.moving = true;
		return true;
	}
	
	public boolean moveDOWN() {
		
		this.currentDirection = Direction.DOWN; 
		
		BoardLocation locationDirectedTo = currentBoardLocation.getBoard()[currentBoardLocation.getRow() + 1][currentBoardLocation.getColumn()];
		
		if(locationDirectedTo.isWall()) {
			this.moving = false;
			return false;
		}
		
		this.moving = true;
		return true;
	}
	
	public boolean moveRIGHT() {
		
		this.currentDirection = Direction.RIGHT;
		
		BoardLocation locationDirectedTo = currentBoardLocation.getBoard()[currentBoardLocation.getRow()][currentBoardLocation.getColumn() + 1];
		
		if(locationDirectedTo.isWall()) {
			this.moving = false;
			return false;
		}
		
		this.moving = true;
		
		return true;
	}

	public BoardLocation getCurrentBoardLocation() {
		
		return currentBoardLocation;
	}
	
}
