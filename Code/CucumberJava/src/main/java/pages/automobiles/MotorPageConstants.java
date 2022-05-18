package pages.automobiles;

import org.openqa.selenium.By;

public class MotorPageConstants {
	
	//region Fields
	private static By oldMotorsLocator = By.xpath(".//tg-tab-heading[text()=' Used ']");
	private static By keywordsLocator = By.xpath(".//input[@name='keyword']");
	private static By makeDropDownLocator = By.xpath(".//select[@name='selectedMake']");
	private static By modelDropDownLocator = By.xpath(".//select[@name='searchParams.model']");
	private static By BodyTypeLocator = By.xpath(".//div[@class='tm-motors-search-bar__dropdown-multi-select']/button");
	private static By bodyTypeDropDown = By.xpath(".//span[@class='o-checkbox__label-text']");
	private static By searchButtonLocator = By.xpath(".//button[@type='submit']");
	private static By searchResultsContainer = By.xpath(".//div[@class='tm-motors-search-results__results-container']");
	private static By carTitlesLocator = By.xpath(".//div[@tmid='title']");
	//endregion
	
	
	
	//region Methods
	//Getters for All Locators
	public static By getOldMotorsLocator() {
		return oldMotorsLocator;
	}
	public static By getKeywordsLocator() {
		return keywordsLocator;
	}
	public static By getMakeDropDownLocator() {
		return makeDropDownLocator;
	}
	public static By getModelDropDownLocator() {
		return modelDropDownLocator;
	}
	public static By getBodyTypeLocator() {
		return BodyTypeLocator;
	}
	public static By getBodyTypeDropDown() {
		return bodyTypeDropDown;
	}
	public static By getSearchButtonLocator() {
		return searchButtonLocator;
	}
	
	public static By getSearchResultsContainer() {
		return searchResultsContainer;
	}
	//endregion
	
	
	
	
	
	
	

	
	
}
