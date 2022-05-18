package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	// region Fields
	private Properties properties;
	private Properties apiProperties;
	// endregion

	// region Methods
	public Properties initializeProperties() {
		properties = new Properties();
		String path = "./src/test/resources/Config/config.properties";
		try {
			FileInputStream file = new FileInputStream(path);
			properties.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return properties;
	}

	public Properties initializerAPIProperties() {
		apiProperties = new Properties();
		String path = "./src/test/resources/DataProvider/ApiData.properties";
		try {
			FileInputStream file = new FileInputStream(path);
			apiProperties.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return apiProperties;

	}
	// endregion

}
