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

	@Test
	public void testIsCurrentGuessEqualToTargetWord() {
		GameState currentGameState = new GameState("Caithness", 12, 3);
		currentGameState.setGuess("Caithness");
		assertTrue(currentGameState.isCurrentGuessEqualToTargetWord());

		currentGameState.setGuess("rhuiebiue");
		assertFalse(currentGameState.isCurrentGuessEqualToTargetWord());

		currentGameState.setGuess("s");
		assertFalse(currentGameState.isCurrentGuessEqualToTargetWord());
	}

	@Test
	public void testIsCurrentGuessACorrectLetter() {
		GameState currentGameState = new GameState("Germany", 12, 3);
		currentGameState.setGuess("y");
		assertTrue(currentGameState.isCurrentGuessACorrectLetter());

		currentGameState.setGuess("d");
		assertFalse(currentGameState.isCurrentGuessACorrectLetter());
	}

}
