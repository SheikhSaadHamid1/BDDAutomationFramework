package utilities;

import java.util.Properties;

public class ConfigConstants {

	// region Fields
	private static ConfigReader reader;
	private static Properties properties;
	private String browser;
	private String url;
	// endregion

	// region Constructor

	public ConfigConstants() {
		reader = new ConfigReader();
		properties = reader.initializeProperties();
	}

	// endregion

	// region Methods

	public String getBrowser() {

		browser = properties.getProperty("browser");
		return browser != null ? browser : "chrome";
	}

	public String getUrl() {
		url = properties.getProperty("url");

		return url != null ? url : "https://www.trademe.co.nz";
	}

	public String getAPIURI() {
		String uri = properties.getProperty("api_uri");
		return url != null ? uri : "https://api.tmsandbox.co.nz/";
	}

	public long getExplicitWaitTime() {
		long explicitWait = 0;
		try {
			explicitWait = Long.parseLong(properties.getProperty("explicit_wait"));
		} catch (Exception e) {
			System.out.println("Please enter valid value for explicit time in config.properties");
		}

		return explicitWait;

	}

	public long getImplicitWaitTime() {
		long implicitWait = 0;
		try {
			implicitWait = Long.parseLong(properties.getProperty("implicit_wait"));
		} catch (Exception e) {
			System.out.println("Please enter valid value for Implicit time in config.properties");
		}

		return implicitWait;

	}

	public long getPageLoadTime() {
		long pageloadtime = 0;
		try {
			pageloadtime = Long.parseLong(properties.getProperty("pageload_wait"));
		} catch (Exception e) {
			System.out.println("Please enter valid value for page load time in config.properties");
		}

		return pageloadtime;

	}

	public String getExcelFilePath() {
		String basePath = System.getProperty("user.dir");
		String excelPath = properties.getProperty("excelFilePath");

		String filePath = basePath + excelPath;

		return filePath;
	}

	public String getAPILogFilePath(String fileName) {
		String filePath = "";
		if (fileName != null && !(fileName.isEmpty())) {
			String basePath = System.getProperty("user.dir");
			String apiLogsFilePath = properties.getProperty("apiLogFilePath");
			filePath = basePath + apiLogsFilePath + fileName + "_logs.txt";
		}

		return filePath;
	}
	// endregion
}
