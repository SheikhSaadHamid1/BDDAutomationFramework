package myhooks;

import io.cucumber.java.Scenario;
import utilities.Common;
import utilities.ConfigConstants;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class ApplicationHooks {
	//region Fields
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigConstants config;
	//endregion
	
	
	//region Methods
	@Before(order = 0)
	public void getProperties() {
		config = new ConfigConstants();
	}
	@Before (order = 1)
	public void launchBrowser(Scenario scenario) {
		//Retrieve browser name from configuration file and initializing driver
		String browserName = config.getBrowser();
		driverFactory = new DriverFactory();
		driver = driverFactory.initializeDriver(browserName);
	}
	
	
	
	@After (order =0 )
	public void quitBrowser() {
		if(driver!=null) {
			driver.quit();
		}
	}
	//endregion
}
