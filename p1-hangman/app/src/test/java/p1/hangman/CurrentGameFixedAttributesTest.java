package p1.hangman;

import static org.junit.Assert.*;

import org.junit.Test;

public class CurrentGameFixedAttributesTest {

    @Test
    public void testInitializeClassVariables() {
        String [] userInput1 = {"--guesses", "20" , "--hints", "30", ""};
        CurrentGameFixedAttributes gameAttributes1 = new CurrentGameFixedAttributes(userInput1);
        assertEquals(20, gameAttributes1.getMaxGuesses());
        assertEquals(30, gameAttributes1.getMaxHints());
        assertEquals("", gameAttributes1.getWordSourceFilePath());

        String[] userInput2 = {"C:\\Users\\Pallavi\\Documents\\words.txt", "--guesses", "10"};
        gameAttributes1 = new CurrentGameFixedAttributes(userInput2);
        assertEquals(10, gameAttributes1.getMaxGuesses());
        assertEquals(2, gameAttributes1.getMaxHints());
        assertEquals("C:\\Users\\Pallavi\\Documents\\words.txt", gameAttributes1.getWordSourceFilePath());

        String[] userInput3 = {"--hints", "8", "C:\\Users\\Pallavi\\Documents\\words.txt"};
        gameAttributes1 = new CurrentGameFixedAttributes(userInput3);
        assertEquals(10, gameAttributes1.getMaxGuesses());
        assertEquals(8, gameAttributes1.getMaxHints());
        assertEquals("C:\\Users\\Pallavi\\Documents\\words.txt", gameAttributes1.getWordSourceFilePath());

    }

}
