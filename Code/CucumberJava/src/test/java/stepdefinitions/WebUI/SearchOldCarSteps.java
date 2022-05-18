package stepdefinitions.WebUI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.automobiles.MotorPageHelper;
import pages.homepage.HomePageHelper;
import pages.searchresults.SearchResultHelper;
import utilities.ConfigConstants;

public class SearchOldCarSteps {
	// region Fields
	private static HomePageHelper homePage;
	private static MotorPageHelper motorPage;
	private static SearchResultHelper searchResults;
	private ConfigConstants config = new ConfigConstants();
	private static Logger log = LogManager.getLogger(DriverFactory.class.getName());
	// endregion

	// region Methods
	@Given("user navigates to automobiles section from home page")
	public void user_navigates_to_automobiles_section_from_home_page() {

		log.info("About to Start Test Execution of Search Old Car functionality");
		DriverFactory.getDriver().get(config.getUrl());
		log.debug("About to initialize HomePageHelper class");
		homePage = new HomePageHelper();
		log.debug("About to initialize MotorPageHelper class");
		motorPage = homePage.navigateMotorsPage();

	}

	@When("user select old cars tab")
	public void user_select_old_cars_tab() {

		motorPage.clickUsedCarsTab();

	}

	@And("user enters {string} in keyword field")
	public void user_enters_in_keyword_field(String keyword) {

		motorPage.enterKeyword(keyword.toUpperCase());
	}

	@And("user selects {string} from make dropdown")
	public void user_selects_from_make_dropdown(String make) {

		motorPage.selectMake(make);
	}

	@And("user selects {string} from model dropdown")
	public void user_selects_from_model_dropdown(String model) {

		motorPage.selectModel(model);
	}

	@And("user select {string} from Body Style dropdown")
	public void user_select_from_body_style_dropdown(String bodyStyle) {

		motorPage.selectBodyType(bodyStyle);

	}

	@And("user clicks on search button")
	public void user_clicks_on_search_button() {

		motorPage.clickSearchButton();
	}

	@Then("search results are displayed")
	public void search_results_are_displayed() {

		log.debug("About to validate that search results are displayed");
		searchResults = motorPage.searchResultsDisplayed();
		if (searchResults != null) {
			Assert.assertTrue(true);
			log.info("Search results are displayed");
		} else {
			log.error("Search results are not displayed");
			Assert.assertTrue(false);
		}
	}

	@When("user clicks on a search result containing {string} value")
	public void user_clicks_on_a_search_result_containing_value(String model) {

		if (searchResults != null) {
			searchResults.selectCar(model);
		}

	}

	@Then("old car details page is displayed")
	public void old_car_details_page_is_displayed() {
		try {
			log.debug("About to perform assertion on Search results are displayed");
			Assert.assertTrue(searchResults.searchedCarPageDisplayed());
			log.info("Search results are displayed");
			
		} catch (AssertionError e) {
			log.error("Search results are not displayed. Message: " + e.getMessage());
			Assert.fail("Test failed due to " + e.getMessage());
		}

	}

	@And("{string} information is displayed correctly for number plates")
	public void information_is_displayed_correctly_for_number_plates(String numberPlate) {

		try {
			searchResults.AddToFilterList();
			log.debug("About to verify if Number plate information is displayed on filters section of page");
			Assert.assertTrue(searchResults.isFilterAvailable(numberPlate.toUpperCase()));
			log.info("Number plate information is available on filters section of page");
		} catch (AssertionError e) {
			log.error(
					"Number Plate information is not displayed in filter section of page. Message: " + e.getMessage());
			Assert.fail("Test failed due to " + e.getMessage());
		}

	}

	@And("{string} information is displayed correctly for kilometers")
	public void information_is_displayed_correctly_for_kilometers(String kilometers) {

		try {
			log.debug("About to verify if Mileage information is displayed on filters section of page");
			Assert.assertTrue(searchResults.isFilterAvailable(kilometers));
			log.info("Mileage information is available on filters section of page");
		} catch (AssertionError e) {
			log.error("Mileage information is not displayed in filter section of page. Message: " + e.getMessage());
			Assert.fail("Test failed due to " + e.getMessage());
		}

	}

	@And("{string} information is displayed correctly for car body")
	public void information_is_displayed_correctly_for_car_body(String body) {

		try {
			log.debug("About to verify if Body information is displayed on filters section of page");
			Assert.assertTrue(searchResults.isFilterAvailable(body));
			log.info("Body information is available on filters section of page");
		} catch (AssertionError e) {
			log.error("Body information is not displayed in filter section of page. Message: " + e.getMessage());
			Assert.fail("Test failed due to " + e.getMessage());
		}

	}

	@And("{string} information is displayed correctly for seats")
	public void information_is_displayed_correctly_for_seats(String seats) {

		try {
			log.debug("About to verify if Seats information is displayed on filters section of page");
			Assert.assertTrue(searchResults.isFilterAvailable(seats));
			log.info("Seats information is available on filters section of page");

		} catch (AssertionError e) {
			log.error("Seats information is not displayed in filter section of page. Message: " + e.getMessage());
			Assert.fail("Test failed due to " + e.getMessage());
		}

	}
//endreqgion

}
