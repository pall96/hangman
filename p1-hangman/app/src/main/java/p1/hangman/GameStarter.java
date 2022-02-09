package p1.hangman;

import java.util.Scanner;

public class GameStarter {
	static GameState currentGame;
	static CurrentGameFixedAttributes currentGameFixedAttributes;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		currentGameFixedAttributes = new CurrentGameFixedAttributes(args);

		doStuff(sc);

	}

	static void doStuff(Scanner sc) {

		boolean correct;

		if (currentGameFixedAttributes.wordsource == "") {

			System.out.println("  1. Counties");
			System.out.println("  2. Countries");
			System.out.println("  3. Cities");
			System.out.println("  4. States");

			System.out.print("Pick a category:");

			currentGame = new GameState(Words.randomWord(sc.nextInt()), currentGameFixedAttributes.maxguesses, currentGameFixedAttributes.maxhints);
		} else {
			currentGame = new GameState(Words.randomWord(currentGameFixedAttributes.wordsource), currentGameFixedAttributes.maxguesses, currentGameFixedAttributes.maxhints);
		}

		while (!currentGame.won() && !currentGame.lost()) {
			currentGame.showWord(currentGame.word);

			System.out.println("Guesses remaining: " + currentGame.wrong);

			correct = currentGame.guessLetter();

			if (correct) System.out.println("Good guess!");
			if (!correct) System.out.println("Wrong guess!");
		}

		if (currentGame.won()) {
			System.out.println("Well done!");
			System.out.println("You took " + currentGame.g + " guesses");
		}
		else
			System.out.println("You lost!");
			System.out.println("The word was " + currentGame.word);
	}


}
