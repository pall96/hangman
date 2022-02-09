package p1.hangman;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameStateTest {

	@Test
	public void testIsHintRequested() {
		GameState currentGameState = new GameState("Caithness", 12, 3);
		currentGameState.setGuess("h");
		assertFalse(currentGameState.isHintRequested());

		currentGameState.setGuess("?");
		assertTrue(currentGameState.isHintRequested());

		currentGameState.setGuess("");
		assertFalse(currentGameState.isHintRequested());

	}

}
