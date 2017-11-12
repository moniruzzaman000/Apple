package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {

	public static String getProperty(String key) {
		String value = null;

		Properties prop = loadProperty("testRun");

		value = prop.getProperty(key);

		if (value == null) {

			String currentEnv = prop.getProperty("testEnv");
			prop = loadProperty(currentEnv);
			value = prop.getProperty(key);
		}

		return value;
	}

	public static String getSaucelabsProperty(String key) {
		String value = null;

		Properties prop = loadProperty("Saucelabs");

		value = prop.getProperty(key);

		return value;
	}

	private static Properties loadProperty(String propFileName) {

		Properties prop = new Properties();

		String filePath = ".\\src\\main\\resources\\properties\\" + propFileName + ".properties";

		try {
			File file = new File(filePath);
			FileInputStream stream = new FileInputStream(file);
			prop.load(stream);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return prop;
	}

}
