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
	
	public boolean move() {
		
		BoardLocation locationDirectedTo = getLocationDirectedTo();
		
		if(locationDirectedTo.isWall()) {
			this.moving = false;
			return false;
		}
		//eat the dot
		locationDirectedTo.removeDot();
		
		this.moving = true;
		
		return true;
	}
	
	private BoardLocation getLocationDirectedTo() {
		
		int rowDirectedTo = currentBoardLocation.getRow();
		int columnDirectedTo = currentBoardLocation.getColumn();
		
		switch(this.currentDirection) {
		
			case UP:
				rowDirectedTo = currentBoardLocation.getRow() - 1;
				columnDirectedTo = currentBoardLocation.getColumn();
			break;
			
			case DOWN:
				rowDirectedTo = currentBoardLocation.getRow() + 1;
				columnDirectedTo = currentBoardLocation.getColumn();
			break;				
			
			case LEFT:
				rowDirectedTo = currentBoardLocation.getRow();
				columnDirectedTo = currentBoardLocation.getColumn() -1;
			break;
			
			case RIGHT:
				rowDirectedTo = currentBoardLocation.getRow();
				columnDirectedTo = currentBoardLocation.getColumn() + 1;
			break;
		}
		
		return currentBoardLocation.getBoard()[rowDirectedTo][columnDirectedTo];
	}

	public BoardLocation getCurrentBoardLocation() {
		
		return currentBoardLocation;
	}
	
}
