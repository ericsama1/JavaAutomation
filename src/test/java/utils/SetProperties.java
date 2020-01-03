package utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SetProperties {
	private static Properties props = new Properties();
	
	private static String config = "config";
	private static String EXTENSION = ".properties";
	
	private static String currentPath = "user.dir";

	public SetProperties() {
		readProperties();
	}
	
	/**
	 * Method to read the properties file, and set this properties to project
	 */
	private void readProperties() {
		String propFileName = fullName(config);
		File path = new File(System.getProperty(currentPath));
		File file = new File(path, propFileName);
		
		try {
			props.load(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to get a specific properties
	 * @param key Name of the properties to get
	 * @return Value of the propertie
	 */
	public String getProperty(String key) {
		return (String) props.get(key);
	}
	
	private String fullName(String name) {
		return name + EXTENSION;
	}

}
