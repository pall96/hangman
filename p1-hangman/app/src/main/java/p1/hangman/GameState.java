package p1.hangman;

import java.util.ArrayList;
import java.util.Scanner;


public class GameState {
	private String targetWord;
	private int guessesMade;
	private int guessesRemaining;
	private int hintsRemaining;
	private String guess;
	private ArrayList<Integer> indexOfLettersGuessedCorrectly = new ArrayList<Integer>();;
	private ArrayList<Integer> indexOfLettersNotGuessed = new ArrayList<Integer>();
	

	
	public GameState(String target, int maxGuesses, int maxHints) {
		this.targetWord = target;
		
		for(int i = 0; i < target.length(); ++i) {
			indexOfLettersNotGuessed.add(i);
		}
		
		this.guessesMade = 0;
		guessesRemaining = maxGuesses; 
		this.hintsRemaining = maxHints;
	}
	
	void showCorrectlyGuessedLetters() {
		for (int i = 0; i < targetWord.length(); ++i) {
			if (indexOfLettersGuessedCorrectly.contains(i)) {
				System.out.print(targetWord.charAt(i));
			} else {
				System.out.print("-");
			}
		}
		System.out.println("");
	}

	void makeGuessOrAskForHint() {
		System.out.print("Guess a letter or word (? for a hint): ");
		Scanner sc = new Scanner(System.in).useDelimiter("\n");
		guess = sc.next();
	}

	boolean isHintRequested() {
		if (guess.equals("?")) {
			return true;
		} else {
			return false;
		}
	}

	void provideHint() {
		if (hintsRemaining == 0) {
			System.out.println("No more hints allowed");
		}
		System.out.print("Try: ");
		System.out.println(targetWord.charAt((int)(Math.random()* targetWord.length())));
	}

	boolean isCurrentGuessCorrect () {
		if (isCurrentGuessEqualToTargetWord()) {
			return true;
		} else {
			if (isCurrentGuessACorrectLetter()) {
				return true;
			} else {
				return false;
			}
		}
	}

	boolean isCurrentGuessEqualToTargetWord() {
		if (guess.equals(targetWord)) {
			return true;
		} else {
			return false;
		}
	}

	boolean isCurrentGuessACorrectLetter() {
		char guessedLetter;
		guessedLetter = guess.charAt(0);
		boolean isCorrect = false;
		for (int i = 0; i < indexOfLettersNotGuessed.size(); ++i) {
			if (Character.toLowerCase(targetWord.charAt(indexOfLettersNotGuessed.get(i))) == guessedLetter) {
				indexOfLettersGuessedCorrectly.add(indexOfLettersNotGuessed.remove(i));
				isCorrect = true;
			}
		}
		return isCorrect;
	}

	void updateCurrentGameStateAttributes() {
		updateGuessesMade();
		updateGuessesRemaining();
		updateHintsRemaining();
		updateIndexLists();
	}

	void updateGuessesMade() {
		if (!isHintRequested()) {
			guessesMade++;
		}
	}

	void updateGuessesRemaining() {
		if (!isHintRequested()) {
			guessesRemaining--;
		}
	}

	void updateHintsRemaining() {
		if (isHintRequested()) {
			hintsRemaining--;
		}
	}

	void updateIndexLists() {
		char guessedLetter;
		guessedLetter = guess.charAt(0);
		for (int i = 0; i < indexOfLettersNotGuessed.size(); ++i) {
			if (Character.toLowerCase(targetWord.charAt(indexOfLettersNotGuessed.get(i))) == guessedLetter) {
				indexOfLettersGuessedCorrectly.add(indexOfLettersNotGuessed.remove(i));
			}
		}
	}
	boolean won() {
		if (indexOfLettersNotGuessed.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	boolean lost() {
		if (indexOfLettersNotGuessed.size() > 0 && guessesRemaining == 0) {
			return true;
		} else {
			return false;
		}
	}



	public String getTargetWord() {
		return targetWord;
	}

	public int getGuessesMade() {
		return guessesMade;
	}

	public int getGuessesRemaining() {
		return guessesRemaining;
	}

	public int getHintsRemaining() {
		return hintsRemaining;
	}

	public String getGuess() {
		return guess;
	}

	public ArrayList<Integer> getIndexOfLettersGuessedCorrectly() {
		return indexOfLettersGuessedCorrectly;
	}

	public ArrayList<Integer> getIndexOfLettersNotGuessedCorrectly() {
		return indexOfLettersNotGuessed;
	}
}
