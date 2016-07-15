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

}
