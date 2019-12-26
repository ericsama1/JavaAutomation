package utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SetProperties {
	private static Properties props = new Properties();

	public SetProperties() {
		readProperties();
	}
	
	private void readProperties() {
		String propFileName = "config.properties";
		File ruta = new File(System.getProperty("user.dir"));
		File file = new File(ruta, propFileName);
		
		try {
			props.load(new FileInputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getProperty(String key) {
		return (String) props.get(key);
	}

}
