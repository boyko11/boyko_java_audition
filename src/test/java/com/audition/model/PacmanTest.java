package com.audition.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PacmanTest {

	private Pacman pacman;
	
	@Before
	public void setUp() throws Exception {
		
		pacman = new Pacman();
	}

	@Test
	public void test_WHEN_created_current_direction_SHOULD_be_up() {
		
		assertEquals(Direction.UP, pacman.getCurrentDirection());
	}
	
	@Test
	public void test_WHEN_created_Pacman_SHOULD_NOT_be_moving() throws Exception {
		
		assertFalse(pacman.isMoving());
	}
	
	@Test
	public void test_moveUP_should_direct_UP_AND_move() throws Exception {
		
		Pacman pacmanUnderTest = setUpMoveTest(Direction.DOWN);
		
		pacmanUnderTest.moveUP();
		
		assertEquals(Direction.UP, pacmanUnderTest.getCurrentDirection());
		assertTrue(pacmanUnderTest.isMoving());
	}
	
	@Test
	public void test_moveLEFT_should_direct_LEFT_AND_move() throws Exception {
		
		Pacman pacmanUnderTest = setUpMoveTest(Direction.UP);
		
		pacmanUnderTest.moveLEFT();
		
		assertEquals(Direction.LEFT, pacmanUnderTest.getCurrentDirection());
		assertTrue(pacmanUnderTest.isMoving());
	}
	
	@Test
	public void test_moveDOWN_should_direct_DOWN_AND_move() throws Exception {
		
		Pacman pacmanUnderTest = setUpMoveTest(Direction.UP);
		
		pacmanUnderTest.moveDOWN();
		
		assertEquals(Direction.DOWN, pacmanUnderTest.getCurrentDirection());
		assertTrue(pacmanUnderTest.isMoving());
	}
	
	@Test
	public void test_moveRIGHT_should_direct_RIGHT_AND_move() throws Exception {
		
		Pacman pacmanUnderTest = setUpMoveTest(Direction.UP);
		
		pacmanUnderTest.moveRIGHT();
		
		assertEquals(Direction.RIGHT, pacmanUnderTest.getCurrentDirection());
		assertTrue(pacmanUnderTest.isMoving());
	}
	
	private Pacman setUpMoveTest(Direction setupDirection) {
		
		Pacman pacmanUnderTest = new Pacman();
		pacmanUnderTest.setDirection(setupDirection);
		pacmanUnderTest.setMoving(false);
		return pacmanUnderTest;
	}

}
