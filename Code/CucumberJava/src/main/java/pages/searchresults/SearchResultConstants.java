package pages.searchresults;

import org.openqa.selenium.By;

public class SearchResultConstants {
	
	//region Fields
	private static By carTitlesLocator = By.xpath(".//div[@tmid='title']");
	private static By searchedCarTitle = By.xpath("//h1[@class='tm-motors-listing__title']");
	private static By searchFiltersLocator = By.xpath(".//span[@class='o-tag__content']/div");
	//endregion
	
	
	//region Methods
	public static By getCarTitlesLocator() {
		return carTitlesLocator;
	}
	
	
	public static By getSearchedCarTitle() {
		return searchedCarTitle;
	}
	
	public static By getSearchFiltersLocator() {
		return searchFiltersLocator;
	}
	
	//endregion

}
