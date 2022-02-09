package p1.hangman;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Words {
	private static String[] counties = { "Argyll and Bute", "Caithness",  "Kingdom of Fife",
			            "East Lothian", "Highland", "Dumfries and Galloway",
			            "Renfrewshire", "Scottish Borders", "Perth and Kinross" };
	private static String[] countries = { "Scotland", "England", "Wales", "Northern Ireland", "Ireland",
			            "France", "Germany", "Netherlands", "Spain", "Portugal",
			            "Belgium", "Luxembourg", "Switzerland", "Italy", "Greece" };
	private static String[] cities = { "St Andrews", "Edinburgh", "Glasgow", "Kirkcaldy", "Perth",
			            "Dundee", "Stirling", "Inverness", "Aberdeen", "Falkirk" };
	
	private static String[] states = { "Alabama" };
	private static ArrayList<String> customWords = new ArrayList<String>();
	
	public static String randomWord(int category) {
		Random random = new Random();
		if (category == 1)
			return counties[random.nextInt(counties.length)];
		if (category == 2)
			return countries[random.nextInt(countries.length)];
		if (category == 3)
			return cities[random.nextInt(cities.length)];
		if (category == 4)
			return states[random.nextInt(states.length)];
		return "INCORRECT CATEGORY";
	}

	public static String pickRandomWordFromFile(String filePath) {
		try {
			FileReader file = new FileReader(filePath);
			BufferedReader reader = new BufferedReader(file);
			String line;
			while((line = reader.readLine()) != null) {
				customWords.add(line);
			}
			return customWords.get((int)(Math.random()* customWords.size()));
		} catch(FileNotFoundException e) {
			System.out.println("File error");
			return "FILE ERROR";
		} catch(IOException e) {
			System.out.println("IO error");
			return "IO ERROR";
		}
	}

	public static String[] getCounties() {
		return counties;
	}

	public static String[] getCountries() {
		return countries;
	}

	public static String[] getCities() {
		return cities;
	}

	public static String[] getStates() {
		return states;
	}

	public static ArrayList<String> getCustomWords() {
		return customWords;
	}
	

	}

