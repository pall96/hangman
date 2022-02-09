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

	@Test
	public void testUpdateGuessesMade() {
		GameState currentGameState = new GameState("Italy", 12, 3);
		currentGameState.setGuess("I");
		currentGameState.updateGuessesMade();
		assertEquals(1, currentGameState.getGuessesMade());

		currentGameState.setGuess("M");
		currentGameState.updateGuessesMade();
		assertEquals(2, currentGameState.getGuessesMade());

		currentGameState.setGuess("?");
		currentGameState.updateGuessesMade();
		assertEquals(2, currentGameState.getGuessesMade());
	}

	@Test
	public void testUpdateGuessesRemaining() {
		GameState currentGameState = new GameState("Perth and Kinross", 20, 6);
		currentGameState.setGuess("e");
		currentGameState.updateGuessesRemaining();
		assertEquals(19, currentGameState.getGuessesRemaining());

		currentGameState.setGuess("h");
		currentGameState.updateGuessesRemaining();
		assertEquals(18, currentGameState.getGuessesRemaining());

		currentGameState.setGuess("?");
		currentGameState.updateGuessesRemaining();
		assertEquals(18, currentGameState.getGuessesRemaining());
	}

	@Test
	public void testUpdateHintsRemaining() {
		GameState currentGameState = new GameState("New Delhi", 10, 2);
		currentGameState.setGuess("i");
		currentGameState.updateHintsRemaining();
		assertEquals(2, currentGameState.getHintsRemaining());

		currentGameState.setGuess("?");
		currentGameState.updateHintsRemaining();
		assertEquals(1, currentGameState.getHintsRemaining());
	}

}
