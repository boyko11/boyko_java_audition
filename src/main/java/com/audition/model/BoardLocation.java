package com.audition.model;

import java.util.ArrayList;
import java.util.List;

import com.audition.Constants;


public class BoardLocation {
	
	private int row;
	private int column;
	private List<Object> objectsAtThisLocation;
	
	public BoardLocation(int row, int column) {
		
		this.row = row;
		this.column = column;
	}
	
	public int getRow() {
		
		return row;
	}
	
	public int getColumn() {
		
		return column;
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
