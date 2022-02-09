package p1.hangman;

import java.util.Scanner;

public class GameStarter {
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GameState currentGame = null;
		CurrentGameFixedAttributes currentGameFixedAttributes;

		currentGameFixedAttributes = new CurrentGameFixedAttributes(args);

		doStuff(sc, currentGameFixedAttributes, currentGame);

	}

	static void doStuff(Scanner sc, CurrentGameFixedAttributes currentGameFixedAttributes, GameState gameState) {

		boolean correct;

		if (currentGameFixedAttributes.wordsource == "") {

			System.out.println("  1. Counties");
			System.out.println("  2. Countries");
			System.out.println("  3. Cities");
			System.out.println("  4. States");

			System.out.print("Pick a category:");

			gameState = new GameState(Words.randomWord(sc.nextInt()), currentGameFixedAttributes.maxguesses, currentGameFixedAttributes.maxhints);
		} else {
			gameState = new GameState(Words.randomWord(currentGameFixedAttributes.wordsource), currentGameFixedAttributes.maxguesses, currentGameFixedAttributes.maxhints);
		}

		while (!gameState.won() && !gameState.lost()) {
			gameState.showWord(gameState.word);

			System.out.println("Guesses remaining: " + gameState.wrong);

			correct = gameState.guessLetter();

			if (correct) System.out.println("Good guess!");
			if (!correct) System.out.println("Wrong guess!");
		}

		if (gameState.won()) {
			System.out.println("Well done!");
			System.out.println("You took " + gameState.g + " guesses");
		}
		else
			System.out.println("You lost!");
			System.out.println("The word was " + gameState.word);
	}


}
