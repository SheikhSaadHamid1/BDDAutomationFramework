package pages.automobiles;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import factory.DriverFactory;
import pages.searchresults.SearchResultHelper;
import utilities.Common;

public class MotorPageHelper extends DriverFactory {
	
	//region Fields
	private Select select;
	private static Logger log = LogManager.getLogger(MotorPageHelper.class.getName());
	private WebElement usedCarsTab = driver.findElement(MotorPageConstants.getOldMotorsLocator());
	private WebElement keyWordField = driver.findElement(MotorPageConstants.getKeywordsLocator());
	private WebElement makeDropDown = driver.findElement(MotorPageConstants.getMakeDropDownLocator());
	private WebElement modelDropDown;  
	private WebElement bodyTypeField = driver.findElement(MotorPageConstants.getBodyTypeLocator());
	private List<WebElement> bodyTypeOptions;
	private WebElement searchButton = driver.findElement(MotorPageConstants.getSearchButtonLocator());
	private WebElement searchResults;
	//endregion
	
	
	//region Methods
	
	public void clickUsedCarsTab() {
		try {
			Common.clickElement(usedCarsTab);
			log.info("User Car Tab is clicked");
		}
		catch(Exception e) {
			
		}
			
	}
	
	
	public void enterKeyword(String keyword) {
		try {
			Common.sendKeys(keyWordField, Common.refineStringCase(keyword));
			log.info("Keyword is entered");
		}
		catch(Exception e) {
			log.error("Test failed due to not able to enter keyword in keyword field");
		}
		
	}
	
	public void selectMake(String make) {
		log.debug("About to Initialize Select class for Make dropdown");
		select = new Select(makeDropDown);
		try {
			log.debug("About to select make: "+make+" from Make dropdown");
			select.selectByValue(Common.refineStringCase(make));
			log.info("Make: "+make+" is selected from Make dropdown");
			
		}
		catch (Exception e) {
			log.error("Cannot select given make of a car. Please provide a valid make in Feature file");
		}
		
	}
	
	public void selectModel(String model) {
		log.debug("About to wait for Model dropdown till its clickable");
		modelDropDown = wait.until(ExpectedConditions.elementToBeClickable(MotorPageConstants.getModelDropDownLocator()));
		Common.clickElement(modelDropDown);
		log.debug("About to initialize Select class for Model dropdown");
		select = new Select(modelDropDown);
		try {
			log.debug("About to select Model: "+model+" from Model dropdown");
			select.selectByValue(Common.refineStringCase(model));
			log.info("Model: "+model+" is selected from Model dropdown");
		}
		catch (Exception e) {
			log.error("Cannot select given model of a car. Please provide a valid model in Feature file");
		}
		
	}
	
	public void selectBodyType(String bodyType)  {
		Common.clickElement(bodyTypeField);
		try {
			log.debug("About to wait for presence of Body Type element on page");
			bodyTypeOptions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(MotorPageConstants.getBodyTypeDropDown()));
			log.debug("About to iterate Body type options to select given BodyType: "+bodyType);
			for(int i = 0; i < bodyTypeOptions.size() ; i++) {
				if(bodyTypeOptions.get(i).getText().trim().equalsIgnoreCase(Common.refineStringCase(bodyType))){
					Common.clickElement(bodyTypeOptions.get(i));
					log.info("BodyType: "+bodyType+" is selected");
					break;
				}
				else {
					log.error("BodyType: "+bodyType+ " doesnt match with available Body type ");
				}
				
				
			}
			
		}
		catch (Exception e) {
			log.error("Test Failed as Element for Body type is not displayed");
		}
		
		
	}
	
	
	public void clickSearchButton() {
		try {
			Common.clickElement(searchButton);
			log.info("Search button is clicked");
		}
		catch (Exception e) {
			log.error("Test failed due to not able to click Search button");
		}
		
	}
	
	public SearchResultHelper searchResultsDisplayed() {
		try {
			log.debug("About to wait for visibility of WebElement on Search Page");
			searchResults = wait.until(ExpectedConditions.visibilityOfElementLocated(MotorPageConstants.getSearchResultsContainer()));
			
		}
		catch(Exception e) {
			log.error("Test Failed as Search results are not displayed ");
		}
		
		return searchResults.isDisplayed() ? new SearchResultHelper() : null; 
	
	}
	
	//endregion
	
	
	
	
}
