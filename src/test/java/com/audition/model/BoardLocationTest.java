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
	public void test_hasPacman_ShouldReturnFalse_WhenNoPacman() {
		
		assertFalse(boardLocation.hasPacman());
	}
	
	@Test
	public void test_hasPacman_ShouldReturnTrue_WhenPacmanPresent() {
		
		boardLocation.addObject(new Pacman(boardLocation));
		assertTrue(boardLocation.hasPacman());
	}
	
	@Test
	public void test_hasDot_ShouldReturnFalse_WhenNoDot() {
		
		assertFalse(boardLocation.hasDot());
	}
	
	@Test
	public void test_hasDot_ShouldReturnTrue_WhenDotPresent() {
		
		boardLocation.addObject(Constants.DOT);
		assertTrue(boardLocation.hasDot());
	}
	
	@Test
	public void test_isWall_ShouldReturnFalse_WhenNotWall() {
		
		assertFalse(boardLocation.isWall());
	}
	
	@Test
	public void test_isWall_ShouldReturnTrue_WhenWall() {
		
		BoardLocation boardLocationUnderTest = new BoardLocation(game.getBoard(), 1, 1, true);
		assertTrue(boardLocationUnderTest.isWall());
	}
	
	@Test
	public void test_hasMonster_ShouldReturnFalse_WhenNoMonster() {
		
		assertFalse(boardLocation.hasMonster());
	}
	
	@Test
	public void test_hasMonster_ShouldReturnTrue_WhenMonsterPresent() {
		
		boardLocation.addObject(new Monster());
		assertTrue(boardLocation.hasMonster());
	}

}
