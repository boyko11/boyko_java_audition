package com.audition.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PacmanTest {

	private Pacman pacman;
	
	@Before
	public void setUp() throws Exception {
		
		Game game = new Game();
		game.init(3, 3);
		pacman = game.getPacman();
	}

	@Test
	public void test_WHEN_created_direction_SHOULD_be_up_AND_location_should_be_in_middle() {
		
		assertEquals(Direction.UP, pacman.getCurrentDirection());
		BoardLocation currentLocation = pacman.getCurrentBoardLocation();
		assertEquals(2, currentLocation.getRow());
		assertEquals(2, currentLocation.getColumn());
	}
	
	@Test
	public void test_WHEN_created_Pacman_SHOULD_NOT_be_moving() throws Exception {
		
		assertFalse(pacman.isMoving());
	}
	
	@Test
	public void test_move_should_move_UP_when_direction_UP_and_valid_destination() throws Exception {
		
		Pacman pacmanUnderTest = setUpMoveTest(Direction.UP, false);
		
		pacmanUnderTest.move();
		
		assertEquals(Direction.UP, pacmanUnderTest.getCurrentDirection());
		assertTrue(pacmanUnderTest.isMoving());
	}
	
	@Test
	public void test_move_should_move_LEFT_when_direction_LEFT_and_valid_destination() throws Exception {
		
		Pacman pacmanUnderTest = setUpMoveTest(Direction.LEFT, false);
		
		pacmanUnderTest.move();
		
		assertEquals(Direction.LEFT, pacmanUnderTest.getCurrentDirection());
		assertTrue(pacmanUnderTest.isMoving());
	}
	
	@Test
	public void test_move_should_move_down_when_direction_DOWN_and_valid_destination() throws Exception {
		
		Pacman pacmanUnderTest = setUpMoveTest(Direction.DOWN, false);
		
		pacmanUnderTest.move();
		
		assertEquals(Direction.DOWN, pacmanUnderTest.getCurrentDirection());
		assertTrue(pacmanUnderTest.isMoving());
	}
	
	@Test
	public void test_move_should_move_RIGHT_when_direction_RIGHT_and_valid_destination() throws Exception {
		
		Pacman pacmanUnderTest = setUpMoveTest(Direction.RIGHT, false);
		
		pacmanUnderTest.move();
		
		assertEquals(Direction.RIGHT, pacmanUnderTest.getCurrentDirection());
		assertTrue(pacmanUnderTest.isMoving());
	}
	
	@Test
	public void test_move_should_not_move_when_direction_UP_and_destination_is_wall() throws Exception {
		
		Pacman pacmanUnderTest = setUpMoveTest(Direction.UP, true);
		
		assertFalse(pacmanUnderTest.move());
		assertFalse(pacmanUnderTest.isMoving());
	}
	
	@Test
	public void testMove_should_not_move_when_direction_DOWN_and_destination_is_wall() throws Exception {
		
		Pacman pacmanUnderTest = setUpMoveTest(Direction.DOWN, true);
		
		assertFalse(pacmanUnderTest.move());
		assertFalse(pacmanUnderTest.isMoving());
	}
	
	@Test
	public void test_move_should_not_move_when_direction_LEFT_and_destination_is_wall() throws Exception {
		
		Pacman pacmanUnderTest = setUpMoveTest(Direction.LEFT, true);
		
		assertFalse(pacmanUnderTest.move());
		assertFalse(pacmanUnderTest.isMoving());
	}
	
	@Test
	public void test_move_should_not_move_when_direction_RIGHT_and_destination_is_wall() throws Exception {
		
		Pacman pacmanUnderTest = setUpMoveTest(Direction.RIGHT, true);
		
		assertFalse(pacmanUnderTest.move());
		assertFalse(pacmanUnderTest.isMoving());
	}
	
	private Pacman setUpMoveTest(Direction setupDirection, boolean destinationIsWall) {
		
		BoardLocation currentBoardLocation = pacman.getCurrentBoardLocation();
		
		if(destinationIsWall) {
			
			BoardLocation[][] currentBoard = currentBoardLocation.getBoard();
			
			switch(setupDirection) {
			
				case UP:
					currentBoard[currentBoardLocation.getRow() - 1][currentBoardLocation.getColumn()].setWall(true);
				break;
				case DOWN:
					currentBoard[currentBoardLocation.getRow() + 1][currentBoardLocation.getColumn()].setWall(true);
				break;				
				case LEFT:
					currentBoard[currentBoardLocation.getRow()][currentBoardLocation.getColumn() - 1].setWall(true);
				break;
				case RIGHT:
					currentBoard[currentBoardLocation.getRow()][currentBoardLocation.getColumn() + 1].setWall(true);
				break;
				default:
				break;
				
			}
			
		}
		
		pacman.setDirection(setupDirection);
		pacman.setMoving(false);
		return pacman;
	}

}
