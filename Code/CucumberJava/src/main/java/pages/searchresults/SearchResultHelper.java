package pages.searchresults;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import factory.DriverFactory;
import utilities.Common;

public class SearchResultHelper extends DriverFactory {
//region Fields
	private List<WebElement> carTitles;
	private List<WebElement> searchFilters;
	private List<String> filterList = new ArrayList<String>();
	private static Logger log = LogManager.getLogger(SearchResultHelper.class.getName());
//endregion

// region Methods
	public void selectCar(String carName) {
		log.debug("About to creat list of WebElements for Searched car Titles");
		carTitles = driver.findElements(SearchResultConstants.getCarTitlesLocator());
		log.debug("About to iterate car titles to select given car: " + carName);
		for (int i = 0; i < carTitles.size(); i++) {
			if (carTitles.get(i).getText().trim().contains(Common.refineStringCase(carName))) {
				Common.clickElement(carTitles.get(i));
				log.info("Car: " + carName + " is selected from Search results");
				break;
			} else {
				log.error("Car: " + carName
						+ " is not available in Search results. Please provide valid Car Name is feature file");
			}
		}

	}

	public boolean searchedCarPageDisplayed() {
		log.debug("About to wait for visibility of element after page navigation to searched car page");
		return wait.until(ExpectedConditions.visibilityOfElementLocated(SearchResultConstants.getSearchedCarTitle()))
				.isDisplayed();

	}

	public void AddToFilterList() {
		// boolean isFilterAvailable = false;
		log.debug("About to wait for visibility of search Filters on page");
		searchFilters = wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(SearchResultConstants.getSearchFiltersLocator()));
		if (searchFilters.size() > 0) {
			log.info("Search filters are displayed on page");
		} else {
			log.error("Search Filters are not available on page");
		}

		for (int i = 0; i < searchFilters.size(); i++) {
			String filterName = Common.getRequiredString(searchFilters.get(i).getText().trim());

			filterList.add(filterName);
			log.info(filterName + " added in filter list");
		}

	}

	public boolean isFilterAvailable(String filter) {
		boolean isFilterAvailable = false;

		log.debug("About to validate filter: " + filter + " is available in Filter list");
		if (filterList.contains(filter.trim())) {
			isFilterAvailable = true;
			log.info(filter + " is available in filter section");
		} else {
			log.error(filter + " is not available in filter section");
		}

		return isFilterAvailable;
	}
//endregion
}
