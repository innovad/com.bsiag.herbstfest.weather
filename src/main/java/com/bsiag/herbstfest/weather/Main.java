package com.bsiag.herbstfest.weather;

import java.io.InputStream;

import org.apache.log4j.PropertyConfigurator;

public class Main {

	public static void main(String[] args) throws Exception {
		// Configure Log4J
		PropertyConfigurator.configure(Main.class.getClassLoader().getResource("log4j.properties"));

		// Read the WOEID Code from the Command-line
		String woeid = "2423945";
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