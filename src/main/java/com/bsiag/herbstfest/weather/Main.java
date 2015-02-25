package com.bsiag.herbstfest.weather;

import java.io.InputStream;

import org.apache.log4j.PropertyConfigurator;

public class Main {

	public static void main(String[] args) throws Exception {
		// Configure Log4J
		PropertyConfigurator.configure(Main.class.getClassLoader().getResource("log4j.properties"));

		// TODO BSI CRM Platin Build 1 (Plain Maven Project without Tycho)
		// Build this project with Maven.
		// Run it on command line.
		// Change the default location (woeid), build and run again.

		// Read the WOEID Code from the Command-line
		String woeid = "676757"; // München
		// String woeid = "781712"; // Baden
		// String woeid = "12478530";
		try {
			woeid = args[0];
		} catch (Exception e) {
		}

		// Start the program
		start(woeid);
	}

	private static void start(String woeid) throws Exception {
		// Retrieve Data
		InputStream dataIn = new YahooRetriever().retrieve(woeid);

		// Parse Data
		Weather weather = new YahooParser().parse(dataIn);

		// Format (Print) Data
		String result = new WeatherFormatter().format(weather);
		System.out.println();
		System.out.println(result);
		System.out.println();
	}
}