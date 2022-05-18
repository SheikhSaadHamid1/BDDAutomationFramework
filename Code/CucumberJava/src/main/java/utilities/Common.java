package utilities;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.PrintStream;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.cucumber.java.Scenario;
import io.restassured.path.json.JsonPath;


public class Common {

	/*
	 * 
	 * Common class is static Utility to provides common functionalities, to be used
	 * across framework.
	 * 
	 */
	//region Fields
	private static WebDriverWait wait;
	private static ConfigConstants config = new ConfigConstants();
	private static PrintStream printStream;
	private static Logger log = LogManager.getLogger(Common.class.getName());

	//endregion
	
	//region Constructor
	private Common() {
		// Private constructor to restrict initialization of Common class
	}
	
	//endregion
	
	//region Methods

	public static void TakeScreenShot(WebDriver driver, Scenario scenario) {
		try {
			String ScreenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", ScreenshotName);
		} catch (Exception e) {
			System.out.println("Failed to take screenshot due to " + e.getStackTrace());
		}

	}

	public static void clickElement(WebElement element) {
		log.debug("Validating element visibility on page");
		if (element.isDisplayed()) {
			log.info("Element: "+element+" is visible on page");
			log.debug("Clicking on element: "+element);
			element.click();
		} else {
			log.error("Element is not displayed on page");
		}
	}

	public static void sendKeys(WebElement element, String text) {
		log.debug("Validating provided strings : "+element+ " and "+text+" are not null");
		if (element != null && text != null) {
			log.debug("Clicking on element: "+element);
			element.click();
			log.debug("Clearing input field");
			element.clear();
			log.debug("Sending keys to element: "+element);
			element.sendKeys(text);
		}
	}

	public static boolean waitForTitleUpdate(WebDriver driver, ConfigConstants config, String expectedTitle) {
		log.debug("Setting up explicit wait with configured wait time "+config.getExplicitWaitTime());
		wait = new WebDriverWait(driver, config.getExplicitWaitTime());
		log.debug("Waiting for change of page title");
		boolean isPageChanged = wait.until(ExpectedConditions.titleContains(expectedTitle));
		if(isPageChanged) {
			log.info("Page Title changed");
		}
		
		return isPageChanged;
	}

	public static String getRequiredString(String word) {
		if (word.contains(":") ) {
			String[] wordArray = word.split(":");
			return wordArray[1].toString().trim();

		} 
		else if(word.contains("\n")) {
			String[] wordArray = word.split("\n");
			return wordArray[1].toString().trim();
		}
		else {
			return word.trim();
		}

	}

	public static String refineStringCase(String word) {
		String refinedCase = "";
		if (word.length() > 0 && word != null) {
			String firstLetter = word.substring(0, 1).toUpperCase();
			String remainingLetters = word.substring(1).toLowerCase();

			refinedCase = firstLetter + remainingLetters;

		}

		return refinedCase;
	}

	public static PrintStream getLogFile(String fileName) {
		
		log.debug("Getting log file path for "+fileName);
		String filePath = config.getAPILogFilePath(fileName);
		
		File file = new File(filePath);

		try {
			printStream = new PrintStream(new FileOutputStream(file), true);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Log file created for "+fileName);
		return printStream;

	}
	
	public static String getJsonValue(String  response, String key) {
		
		String value = "";
		try {
			if(response != null && key != null) {
				log.debug("Creating JSON path object to read values from JSON String");
				JsonPath js = new JsonPath(response);
				
				value = js.getString(key);
				log.info("Value:"+value+" is retrieved for key: "+key);
			}
			
		}
		catch (Exception e) {
			log.error("Not able to get value for key: "+key+"  from JSON String: "+response);
		}
		
		return value;
	}
	
	//endregion

}
