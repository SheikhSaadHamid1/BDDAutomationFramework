package pages.homepage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import factory.DriverFactory;
import pages.automobiles.MotorPageHelper;
import utilities.Common;

public class HomePageHelper extends DriverFactory {

	// region Fields

	private static Logger log = LogManager.getLogger(HomePageHelper.class.getName());
	private WebElement motorSection = driver.findElement(HomePageConstants.getMotorsLocator());

	// endregion

	// region Methods

	public void navigateHomePage() {
		log.debug("About to get URL from configuration file");
		String url = config.getUrl();
		log.info("URL is retreived from configuration file. URL: " + url);
		driver.navigate().to(url);
		log.info("Navigated to URL: " + url);

	}

	public MotorPageHelper navigateMotorsPage() {

		Common.clickElement(motorSection);
		log.info("Motor section is clicked");
		String expectedPageTitle = "Cars And Vehicles For Sale | Trade Me Motors";
		log.debug("About to wait for Title update after navigating to Motor page");
		boolean isMotorPageDisplayed = Common.waitForTitleUpdate(driver, config, expectedPageTitle);
		if (isMotorPageDisplayed) {
			return new MotorPageHelper();
		}

		else {
			log.error("Motor page is not displayed");
			return null;
		}

	}

	// endregion

}
