package com.audition.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.audition.Constants;

public class BoardLocationTest {

	private BoardLocation boardLocation;
	private Game game;
	
	@Before
	public void setUp() throws Exception {
		
		game = new Game();
		game.init(3, 3);
		boardLocation = new BoardLocation(game.getBoard(), 1, 1, false);
	}

	@Test
	public void test_hasPacman_should_return_false_when_no_pacman() {
		
		assertFalse(boardLocation.hasPacman());
	}
	
	@Test
	public void test_hasPacman_should_return_true_when_pacman_present() {
		
		boardLocation.addObject(new Pacman(boardLocation));
		assertTrue(boardLocation.hasPacman());
	}
	
	@Test
	public void test_hasDot_shouold_return_false_when_no_dot() {
		
		assertFalse(boardLocation.hasDot());
	}
	
	@Test
	public void test_hasDot_should_return_true_when_dot_resent() {
		
		boardLocation.addObject(Constants.DOT);
		assertTrue(boardLocation.hasDot());
	}
	
	@Test
	public void test_isWall_should_return_false_when_not_wall() {
		
		assertFalse(boardLocation.isWall());
	}
	
	@Test
	public void test_isWall_should_return_true_when_wall() {
		
		BoardLocation boardLocationUnderTest = new BoardLocation(game.getBoard(), 1, 1, true);
		assertTrue(boardLocationUnderTest.isWall());
	}
	
	@Test
	public void test_hasMonster_should_return_false_when_no_monster() {
		
		assertFalse(boardLocation.hasMonster());
	}
	
	@Test
	public void test_hasMonster_should_return_true_when_monster_present() {
		
		boardLocation.addObject(new Monster());
		assertTrue(boardLocation.hasMonster());
	}

}
