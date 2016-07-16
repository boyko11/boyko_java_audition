package com.audition.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.audition.Constants;

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
		
		Pacman pacmanUnderTest = setUpMoveTest(Direction.UP, false, null);
		
		pacmanUnderTest.move();
		
		assertEquals(Direction.UP, pacmanUnderTest.getCurrentDirection());
		assertTrue(pacmanUnderTest.isMoving());
	}
	
	@Test
	public void test_move_should_move_LEFT_when_direction_LEFT_and_valid_destination() throws Exception {
		
		Pacman pacmanUnderTest = setUpMoveTest(Direction.LEFT, false, null);
		
		pacmanUnderTest.move();
		
		assertEquals(Direction.LEFT, pacmanUnderTest.getCurrentDirection());
		assertTrue(pacmanUnderTest.isMoving());
	}
	
	@Test
	public void test_move_should_move_down_when_direction_DOWN_and_valid_destination() throws Exception {
		
		Pacman pacmanUnderTest = setUpMoveTest(Direction.DOWN, false, null);
		
		pacmanUnderTest.move();
		
		assertEquals(Direction.DOWN, pacmanUnderTest.getCurrentDirection());
		assertTrue(pacmanUnderTest.isMoving());
	}
	
	@Test
	public void test_move_should_move_RIGHT_when_direction_RIGHT_and_valid_destination() throws Exception {
		
		Pacman pacmanUnderTest = setUpMoveTest(Direction.RIGHT, false, null);
		
		pacmanUnderTest.move();
		
		assertEquals(Direction.RIGHT, pacmanUnderTest.getCurrentDirection());
		assertTrue(pacmanUnderTest.isMoving());
	}
	
	@Test
	public void test_move_should_not_move_when_direction_UP_and_destination_is_wall() throws Exception {
		
		Pacman pacmanUnderTest = setUpMoveTest(Direction.UP, true, null);
		
		assertFalse(pacmanUnderTest.move());
		assertFalse(pacmanUnderTest.isMoving());
	}
	
	@Test
	public void testMove_should_not_move_when_direction_DOWN_and_destination_is_wall() throws Exception {
		
		Pacman pacmanUnderTest = setUpMoveTest(Direction.DOWN, true, null);
		
		assertFalse(pacmanUnderTest.move());
		assertFalse(pacmanUnderTest.isMoving());
	}
	
	@Test
	public void test_move_should_not_move_when_direction_LEFT_and_destination_is_wall() throws Exception {
		
		Pacman pacmanUnderTest = setUpMoveTest(Direction.LEFT, true, null);
		
		assertFalse(pacmanUnderTest.move());
		assertFalse(pacmanUnderTest.isMoving());
	}
	
	@Test
	public void test_move_should_not_move_when_direction_RIGHT_and_destination_is_wall() throws Exception {
		
		Pacman pacmanUnderTest = setUpMoveTest(Direction.RIGHT, true, null);
		
		assertFalse(pacmanUnderTest.move());
		assertFalse(pacmanUnderTest.isMoving());
	}
	
	@Test
	public void test_move_should_eat_dot_if_present() throws Exception {
		
		Pacman pacmanUnderTest = setUpMoveTest(Direction.RIGHT, false, Constants.DOT);
		BoardLocation currentLocation = pacmanUnderTest.getCurrentBoardLocation();
		
		int currentRow = currentLocation.getRow();
		int currentColumn = currentLocation.getColumn();
		
		//destination has a DOT
		BoardLocation destination = currentLocation.getBoard()[currentRow][currentColumn + 1];
		assertTrue(destination.hasDot());
		
		pacmanUnderTest.move();
		
		//destination has NO Dot after Pacman ate it
		assertFalse(destination.hasDot());
		
	}
	
	private Pacman setUpMoveTest(Direction setupDirection, boolean destinationIsWall, Object objectAtDestination) {
		
		BoardLocation currentBoardLocation = pacman.getCurrentBoardLocation();
		
		BoardLocation[][] currentBoard = currentBoardLocation.getBoard();
		
		int rowDirectedTo = currentBoardLocation.getRow();
		int columnDirectedTo = currentBoardLocation.getColumn();
		
		switch(setupDirection) {
		
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
		
		
		if(destinationIsWall) {

			currentBoard[rowDirectedTo][columnDirectedTo].setWall(true);
		}
		
		if(objectAtDestination != null) {
			
			currentBoard[rowDirectedTo][columnDirectedTo].addObject(objectAtDestination);
		}
		
		pacman.setDirection(setupDirection);
		pacman.setMoving(false);
		return pacman;
	}

}
