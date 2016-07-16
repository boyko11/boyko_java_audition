package com.audition.model;

import java.util.ArrayList;
import java.util.List;

import com.audition.Constants;


public class BoardLocation {
	
	private int row;
	private int column;
	boolean wall;
	private List<Object> objectsAtThisLocation;
	private BoardLocation[][] board;
	
	public BoardLocation(BoardLocation[][] board, int row, int column, boolean wall) {
		
		this.row = row;
		this.column = column;
		this.wall = wall;
		this.board = board;
	}
	
	public int getRow() {
		
		return this.row;
	}
	
	public int getColumn() {
		
		return this.column;
	}
	
	public boolean isWall() {
		
		return this.wall;
	}
	
	public void setWall(boolean wall) {
		
		this.wall = wall;
	}
	
	public void addObject(Object object) {
		
		if(objectsAtThisLocation == null) {
			objectsAtThisLocation = new ArrayList<Object>();
		}
		objectsAtThisLocation.add(object);
	}
	
	public boolean hasPacman() {
		
		if(this.objectsAtThisLocation == null || this.objectsAtThisLocation.isEmpty()) {
			return false;
		}
		
		return this.objectsAtThisLocation.stream()
				.anyMatch(objectAtThisLocation -> objectAtThisLocation instanceof Pacman);
	}
	
	public boolean hasDot() {
		
		if(this.objectsAtThisLocation == null || this.objectsAtThisLocation.isEmpty()) {
			return false;
		}
		
		return this.objectsAtThisLocation.stream()
				.anyMatch(objectAtThisLocation -> (
					objectAtThisLocation instanceof Character
					&& (Character) objectAtThisLocation == Constants.DOT
				));
	}
	
	public boolean hasMonster() {
		
		if(this.objectsAtThisLocation == null || this.objectsAtThisLocation.isEmpty()) {
			return false;
		}
		
		return this.objectsAtThisLocation.stream()
				.anyMatch(objectAtThisLocation -> objectAtThisLocation instanceof Monster);
	}
	
	public void clearObjects() {
		
		if(this.objectsAtThisLocation == null) {
			this.objectsAtThisLocation.clear();
		}
	}
	
	public BoardLocation[][] getBoard() {
		
		return board;
	}
	
	public void print() {
		
		System.out.print(Constants.SPACE);
		
		if(this.isWall()) {
			System.out.print("###");
			System.out.print(Constants.SPACE);
			return;
		}
		String contentOfBoardLocation = Constants.SPACE;
		if(this.hasDot()) {
			contentOfBoardLocation += String.valueOf(Constants.DOT);
		}
		
		if(this.hasPacman()) {
			contentOfBoardLocation += "P";
		}
		
		if(this.hasMonster()) {
			contentOfBoardLocation += "M";
		}
		
		System.out.print(String.format("%1$3s", contentOfBoardLocation));
		
		System.out.print(Constants.SPACE);
	}

}