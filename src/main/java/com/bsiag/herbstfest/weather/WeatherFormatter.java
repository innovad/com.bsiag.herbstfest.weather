package com.bsiag.herbstfest.weather;

import java.io.File;
import java.io.FileWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class WeatherFormatter {

	private static Logger log = Logger.getLogger(WeatherFormatter.class);

	public String format(Weather weather) throws Exception {
		// Configuration
		Writer file = null;
		Configuration cfg = new Configuration();

		try {
			// Set Directory for templates
			cfg.setClassForTemplateLoading(this.getClass(), "/");
			// load template
			Template template = cfg.getTemplate("template.txt");

			// data-model
			Map<String, Object> input = new HashMap<String, Object>();
			input.put("weather", weather);

			// Also write output to console
			Writer out = new StringWriter();
			template.process(input, out);
			return out.toString();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}