package p1.hangman;

import java.util.ArrayList;
import java.util.Scanner;

// The game state
public class GameState {


	private String targetWord;
	private int guessesMade;
	private int guessesRemaining;
	private int hintsRemaining;
	
	private ArrayList<Integer> indexOfLettersGuessedCorrectly = new ArrayList<Integer>();;
	private ArrayList<Integer> indexOfLettersNotGuessedCorrectly = new ArrayList<Integer>();
	

	
	public GameState(String target, int maxGuesses, int maxHints) {
		this.targetWord = target;
		
		for(int i = 0; i < target.length(); ++i) {
			indexOfLettersNotGuessedCorrectly.add(i);
		}
		
		this.guessesMade = 0;
		guessesRemaining = maxGuesses; 
		this.hintsRemaining = maxHints;
	}
	
	void showWord(String word) {
		for (int i = 0; i < word.length(); ++i) {
			if (indexOfLettersGuessedCorrectly.contains(i)) {
				System.out.print(word.charAt(i));
			} else {
				System.out.print("-");
			}
		}
		System.out.println("");
	}
	
	boolean guessLetter() {
		int i;
		char letter;
		
		System.out.print("Guess a letter or word (? for a hint): ");
		Scanner sc = new Scanner(System.in).useDelimiter("\n");
		String str = sc.next();
		
		if (str.length() > 1) {
			if (str== targetWord) {
				indexOfLettersNotGuessedCorrectly.clear();
				return true;
			} else return false;
		}
		
		letter = str.charAt(0);
		
		if (letter == '?') {
			hint();
			return false;
		}
		
		for(i = 0; i < indexOfLettersNotGuessedCorrectly.size(); ++i) { // Loop over the not got
			if (Character.toLowerCase(targetWord.charAt(indexOfLettersNotGuessedCorrectly.get(i))) == letter) {
				indexOfLettersGuessedCorrectly.add(indexOfLettersNotGuessedCorrectly.remove(i));
				guessesMade++;
				return true;
			}
		}

		guessesMade++; // One more guess
		guessesRemaining--;
		return false;
	}
	
	boolean won() {
		if (indexOfLettersNotGuessedCorrectly.size() == 0) return true; else return false;
	}

	boolean lost() {
		if (indexOfLettersNotGuessedCorrectly.size() > 0 && guessesRemaining == 0) return true; else return false;
	}

	void hint() {
		if (hintsRemaining == 0) {
			System.out.println("No more hints allowed");
		}
		
		System.out.print("Try: ");
		System.out.println(targetWord.charAt((int)(Math.random()* targetWord.length())));
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

	public ArrayList<Integer> getIndexOfLettersGuessedCorrectly() {
		return indexOfLettersGuessedCorrectly;
	}

	public ArrayList<Integer> getIndexOfLettersNotGuessedCorrectly() {
		return indexOfLettersNotGuessedCorrectly;
	}
}
