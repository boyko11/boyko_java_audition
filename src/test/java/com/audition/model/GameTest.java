package com.audition.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameTest {

	private Game game;
	@Before
	public void setUp() throws Exception {
		
		game = new Game();
		game.init(3, 3);
		game.printBoard();
	}

	@Test
	public void testInit_ShouldAllocateExtremeRowsAndColumnsForWalls() {
		
		BoardLocation[][] board = game.getBoard();
		
		assertEquals(5, board.length);
		assertEquals(5, board[0].length);
	}
	
	@Test
	public void testInit_ShouldMakeFirstRow_a_Wall() throws Exception {
		
		BoardLocation[][] board = game.getBoard();
		
		for(int i = 0; i < board[0].length; i++) {
			assertTrue(board[0][i].isWall());
		}
	}
	
	@Test
	public void testInit_ShouldMakeLastRow_a_Wall() throws Exception {
		
		BoardLocation[][] board = game.getBoard();
		
		for(int i = 0; i < board[board.length - 1].length; i++) {
			assertTrue(board[board.length - 1][i].isWall());
		}
	}
	
	@Test
	public void testInit_ShouldMakeFirstColumn_a_Wall() throws Exception {
		
		BoardLocation[][] board = game.getBoard();
		
		for(int i = 0; i < board.length; i++) {
			
			assertTrue(board[i][0].isWall());
		}
	}
	
	@Test
	public void testInit_ShouldMakeLastColumn_a_Wall() throws Exception {
		
		BoardLocation[][] board = game.getBoard();
		
		for(int i = 0; i < board.length; i++) {
			
			assertTrue(board[i][board.length - 1].isWall());
		}
	}
	
	@Test
	public void testInit_ShouldCreatePacmanInMiddle() throws Exception {
		
		BoardLocation[][] board = game.getBoard();
		
		int pacmanInitialRow = Math.floorDiv(board.length, 2);
		int pacmanInitialColumn = Math.floorDiv(board[0].length, 2);
		
		assertTrue(board[pacmanInitialRow][pacmanInitialColumn].hasPacman());
		
	}
	
	public void testInit_ShouldPutDots_at_all_locations_except_Pacman() {
		
		BoardLocation[][] board = game.getBoard();
		
		int pacmanInitialRow = Math.floorDiv(board.length, 2);
		int pacmanInitialColumn = Math.floorDiv(board[0].length, 2);
		
		for(int i = 1; i < board.length - 1; i++) {
			
			for(int j = 1; j < board[0].length -1; j++) {
				
				if(i == pacmanInitialRow && j == pacmanInitialColumn) {
					continue;
				}
				
				assertTrue(board[i][0].isWall());
			}
			
		}
	}

}
