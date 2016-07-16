package com.audition.model;

import java.util.ArrayList;
import java.util.List;

import com.audition.Constants;


public class BoardLocation {
	
	private int row;
	private int column;
	boolean wall;
	private List<Object> objectsAtThisLocation;
	
	public BoardLocation(int row, int column, boolean wall) {
		
		this.row = row;
		this.column = column;
		this.wall = wall;
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
	
	public void clearObjects() {
		
		if(this.objectsAtThisLocation == null) {
			this.objectsAtThisLocation.clear();
		}
	}
	
}