package com.audition.model;

public class Game {

	private BoardLocation[][] board;
	
	public void init(int boardRows, int boardColumns) {
		
		//+2 for walls surrounding the board
		board = new BoardLocation[boardRows + 2][boardColumns + 2];
		
		for(int row = 0; row < boardRows + 2; row++) {
			
			for(int column = 0; column < boardColumns + 2; column++) {
				
				//if it is a location at the extremities - make it a wall
				boolean isWall = false;
				if(row == 0 || column == 0 || row == boardRows + 1 || column == boardColumns + 1) {
					isWall = true;
					board[row][column] = new BoardLocation(row, column, isWall);
				}
				board[row][column] = new BoardLocation(row, column, isWall);
			}
		}
		
		//place pacman in the middle of the board
		int pacmanInitialRow = Math.floorDiv(board.length, 2);
		int pacmanInitialColumn = Math.floorDiv(board[0].length, 2);
		
		Pacman pacman = new Pacman();
		board[pacmanInitialRow][pacmanInitialColumn].addObject(pacman);
	}
	
	public BoardLocation[][] getBoard() {
		
		return this.board;
	}
	
	public void printBoard() {
		
		
		for(int row = 0; row < board.length; row++) {
			
			for(int column = 0; column < board[0].length; column++) {
				
				board[row][column].print();
			}
			System.out.println();
			for(int column = 0; column < board[0].length; column++) {
				
				System.out.print("-----");
			}
			System.out.println();
		}
	}
}
