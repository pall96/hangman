package p1.hangman;

public class CurrentGameFixedAttributes {



	private int maxGuesses = 10;
	private int maxHints = 2;
	
	private String wordSourceFilePath = "";
	
	CurrentGameFixedAttributes(String[] commandLineInput) {
		initializeClassVariables(commandLineInput);
	}

	public void initializeClassVariables(String[] commandLineInput) {
		for(int i = 0; i < commandLineInput.length; ++i) {
			if (commandLineInput[i].equals("--guesses")) {
				maxGuesses = Integer.parseInt(commandLineInput[i+1]);
				i++;
			} else if (commandLineInput[i].equals("--hints")) {
				maxHints = Integer.parseInt(commandLineInput[i+1]);
				i++;
			} else {
				wordSourceFilePath = commandLineInput[i];
			}
		}
	}

	public int getMaxGuesses() {
		return maxGuesses;
	}

	public int getMaxHints() {
		return maxHints;
	}

	public String getWordSourceFilePath() {
		return wordSourceFilePath;
	}
}
