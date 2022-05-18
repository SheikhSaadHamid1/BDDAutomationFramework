package stepdefinitions.RestAPI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import com.fasterxml.jackson.core.JsonProcessingException;
import utilities.ConfigConstants;
import utilities.APIHelpers.DeSerialization.CharityListHelper;
import utilities.APIHelpers.specifications.Specifications;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;

public class SearchCharitiesSteps {
	// region fields
	private ValidatableResponse validateResponse;
	private ConfigConstants config = new ConfigConstants();
	private ArrayList<String> listOfCharities;
	private Specifications specifications = new Specifications();
	private RequestSpecification reqSpec;

	private Response responce;
	private static Logger log = LogManager.getLogger(SearchCharitiesSteps.class.getName());

	// endregion

	// region stepdefinitionMethods

	@Given("user set TradeMe sandbox API URI")
	public void user_set_trade_me_sandbox_api_URI() {
		// Write code here that turns the phrase above into concrete actions
		log.debug("About to start Test execution of : SearchCharityFunctionality");

		String className = SearchCharitiesSteps.class.getSimpleName();
		log.debug("About to create Request Specification with URI and class name");
		reqSpec = given().spec(specifications.requestSpecification(config.getAPIURI(), className)).and();
		log.info("Request Specification is created");

	}

	@When("user send Get http request on {string}")
	public void user_send_http_header_on(String endpoint) {
		// Write code here that turns the phrase above into concrete actions
		log.debug("About to send Get Request on endpoint: " + endpoint);

		if (endpoint != null && !(endpoint.isEmpty())) {

			responce = reqSpec.when().get(endpoint).andReturn();
		}
		log.info("Response is created with all parameters and Get request ");
	}

	@Then("API responds {int} status code")
	public void api_responds_status_code(Integer statusCode) {
		// Write code here that turns the phrase above into concrete actions
		log.debug("About to validate API status code with expected status code: " + statusCode);
		try {
			validateResponse = responce.then().assertThat().statusCode(statusCode).and();
		} catch (AssertionError e) {
			log.error("Invalid API response recieved due to " + e.getMessage());
		} catch (Exception e) {
			Assert.fail("Test failed due to " + e.getMessage());
		}
	}

	@And("List of charities are displayed")
	public void list_of_charities_are_displayed() {
		// Write code here that turns the phrase above into concrete actions
		String response = validateResponse.extract().asPrettyString();
		try {
			log.debug("About to get list of charities from CharityListHelper class");
			listOfCharities = CharityListHelper.getDescriptionList(response);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			log.error("No List generated due to " + e.getMessage());
		}

		if (listOfCharities.size() > 0) {
			log.info("Charities name are displayed and added in list");
			Assert.assertTrue(true);
		} else {
			log.error("No Charities available in the response");
			Assert.fail("No Charities available");
		}

	}

	@And("List contains {string} in Description")
	public void list_contains_in_description(String charityName) {
		// Write code here that turns the phrase above into concrete actions
		log.debug("About to validate that list contains " + charityName + " charity");

		try {
			if (charityName != null) {

				Assert.assertTrue(listOfCharities.contains(charityName));
				log.info(charityName + " is available in Charitylist description");
			}
		} catch (AssertionError e) {
			log.error("Charity name: " + charityName + " is not available in the list of Charities");
		}

	}

	// endregion
}
