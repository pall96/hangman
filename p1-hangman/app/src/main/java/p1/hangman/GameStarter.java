package p1.hangman;

import java.util.Scanner;

public class GameStarter {
	static GameState currentGame;
	static CurrentGameFixedAttributes currentGameFixedAttributes;

	public static void main(String[] commandLineInput) {
		currentGameFixedAttributes = new CurrentGameFixedAttributes(commandLineInput);
		startAndPlayGame();
	}

	public static void startAndPlayGame() {
		startGame();
		playGame();
	}

	public static void startGame() {
		if (currentGameFixedAttributes.wordsource.equals("")) {
			System.out.println("  1. Counties");
			System.out.println("  2. Countries");
			System.out.println("  3. Cities");
			System.out.println("  4. States");
			System.out.print("Pick a category:");

			Scanner sc = new Scanner(System.in);
			currentGame = new GameState(Words.randomWord(sc.nextInt()), currentGameFixedAttributes.maxguesses, currentGameFixedAttributes.maxhints);
		} else {
			currentGame = new GameState(Words.randomWord(currentGameFixedAttributes.wordsource), currentGameFixedAttributes.maxguesses, currentGameFixedAttributes.maxhints);
		}
	}

	static void playGame() {
		while (!currentGame.won() && !currentGame.lost()) {
			currentGame.showCorrectlyGuessedLetters();
			System.out.println("Guesses remaining: " + currentGame.getGuessesRemaining());
			currentGame.makeGuessOrAskForHint();
			if(currentGame.isHintRequested()) {
				currentGame.provideHint();
			}
			else {
				boolean correct;
				correct = currentGame.isCurrentGuessCorrect();
				if(correct) {
					System.out.println("Good guess!");
				} else {
					System.out.println("Wrong guess!");
				}
				currentGame.updateCurrentGameStateAttributes();
				checkIfGameWonAndDoWinningActions();
				checkIfGameLostAndDoLosingActions();

			}
		}
	}

	static void checkIfGameWonAndDoWinningActions() {
		if (currentGame.won()) {
			System.out.println("Well done!");
			System.out.println("You took " + currentGame.getGuessesMade() + " guesses");
		}
	}

	static void checkIfGameLostAndDoLosingActions() {
		if (currentGame.lost()) {
			System.out.println("You lost!");
			System.out.println("The word was " + currentGame.getTargetWord());
		}
	}


}
