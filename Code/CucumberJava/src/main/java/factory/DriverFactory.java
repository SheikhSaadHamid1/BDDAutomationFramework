package factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.BrowserEnum;
import utilities.ConfigConstants;

public class DriverFactory {
	/*
	 * Driver Factory class is used to Initialize Driver instance to execute Web UI
	 * Tests Uses WebDriverManager to setup ChromeDriver
	 * 
	 */

	// region Fields
	protected static WebDriver driver;
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	protected ConfigConstants config = new ConfigConstants();
	protected static WebDriverWait wait;
	private static Logger log = LogManager.getLogger(DriverFactory.class.getName());
	// endregion

	// region Methods
	// Initialize Browser and Driver Instance
	public WebDriver initializeDriver(String browser) {
		log.info("Initializing Driver to launch Web UI Tests");

		if (browser.isEmpty()) {
			log.error("Please provide a valid browser name in config.properties file");
			return null;
		} else

		{
			// Launch Chrome Browser
			log.debug("Setting up browser to be used for Application under test");
			if (browser.equals(BrowserEnum.chrome.toString())) {
				log.debug("About to Setup ChromeDriver using WebDriverManager");
				WebDriverManager.chromedriver().setup();
				log.debug("About to start ChromeDriver browser");
				tlDriver.set(new ChromeDriver());
				log.info("Chrome Browser is launched");

			}
			// Launch Firefox Browser

			else if (browser.equals(BrowserEnum.firefox.toString())) {
				log.debug("About to Setup FireFoxDriver using WebDriverManager");
				WebDriverManager.firefoxdriver().setup();
				log.debug("About to start Firefox browser");
				tlDriver.set(new FirefoxDriver());
				log.info("Firefox browser is launched");
			}

			else {
				log.error(
						"Please provide valid browser information in config.properties file. Available options are chrome and firefox only");
			}

			log.debug("About to setup driver properties: deleteAllCookies");
			getDriver().manage().deleteAllCookies();
			log.debug("About to setup driver properties: window maximize");
			getDriver().manage().window().maximize();

			driver = getDriver();
			log.info("driver is initialized");
			// Initialized Explicit WebDriverWait instance
			log.debug("About to setup Explicit Wait to be used across several tests");
			wait = new WebDriverWait(driver, config.getExplicitWaitTime());
			log.info("Explicit wait is initialized");
			return driver;

		}
	}

	public static synchronized WebDriver getDriver() {

		return tlDriver.get();
	}

	// endregion

}
