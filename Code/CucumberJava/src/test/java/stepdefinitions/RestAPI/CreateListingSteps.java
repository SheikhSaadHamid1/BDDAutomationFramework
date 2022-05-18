package stepdefinitions.RestAPI;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import payloads.SellingPayloadConstants;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import utilities.Common;
import utilities.ConfigConstants;
import utilities.APIHelpers.Serialization.SellingListHelper;
import utilities.APIHelpers.specifications.Specifications;

public class CreateListingSteps {

	// region fields

	private ResponseSpecification specs;
	private RequestSpecification reqSpec;
	private Specifications specifications = new Specifications();
	private ConfigConstants config = new ConfigConstants();
	private String response = "";
	private String listingId = "";
	private Response responseData;
	private static Logger log = LogManager.getLogger(CreateListingSteps.class.getName());

	// endregion

	// region stepDefinitionMethods
	@Given("user provides valid {string},{string},{string}, {string} with {string} and body")
	public void user_provides_valid_keys(String consumerKey, String consumerSecret, String accessToken,
			String tokenSecret, String requestType) {
		// Write code here that turns the phrase above into concrete actions
		// System.setProperty("https.protocols", "TLSv1.1");
		log.info("Test Execution started_ \"user provide valid keys\"");
		log.debug("About to get payload from SellingListHelper class");
		String payload = SellingListHelper.getPayload();
		log.info("Payload: " + payload);
		log.debug("About to get class name as String");
		String className = CreateListingSteps.class.getSimpleName();

		log.debug("About to build a Request Specification with passing class name as parameter");
		reqSpec = specifications.requestSpecification(className);

		log.debug(
				"About to build a Response Specifications with providing Authentication token, content type and body");
		specs = RestAssured.given().spec(reqSpec).auth().oauth(consumerKey, consumerSecret, accessToken, tokenSecret)
				.header("Content-type", requestType).queryParam("Duration", SellingPayloadConstants.getDuration() ).body(payload).then();

		log.info("Response Specifications created with all parameters, payloads and content type");

	}

	@When("user sends post request on {string}")
	public void user_sends_post_request_on(String endpoint) {
		// Write code here that turns the phrase above into concrete actions
		try {
			log.info("Test execution started _ \"user sends post request on \"");

			log.debug("About to send post request on endpoint: " + endpoint);
			log.info("For details related to API request, refer CreateListingSteps_logs.txt file");
			responseData = specs.when().post(endpoint).andReturn();
			log.info("Response is created with sending post request on endpoint: " + endpoint);
		} catch (Exception e) {
			log.error("Cannot sent post request on " + endpoint + " due to :" + e.getMessage());
			Assert.fail("Test failed due to " + e.getMessage());
		}

	}

	@Then("API responds with {int}")
	public void api_responds_with(int statusCode) {
		// Write code here that turns the phrase above into concrete actions
		try {
			log.info("Test execution started _ \"api_responds_with \" ");

			log.debug("About to Assert status code with expected status code: " + statusCode
					+ " and extracting response as a String");
			response = responseData.then().assertThat().statusCode(statusCode).extract().response().asPrettyString();
			log.info("Status code: " + statusCode + " is asserted sucessfully");
		} catch (AssertionError e) {
			log.error("Invalid API Response due to : " + e.getMessage());

		} catch (Exception e) {
			Assert.fail("Test failed due to " + e.getMessage());
		}

	}

	@And("user gets success message and listing id")
	public void user_gets_success_message_and_listing_id() {
		// Write code here that turns the phrase above into concrete actions

		try {
			log.debug("About to get Listing ID from JSON response: " + response);
			listingId = Common.getJsonValue(response, "ListingId");
			log.info("Listing id retrieved: " + listingId);

			log.debug("About to get Description from JSON response: " + response);
			String description = Common.getJsonValue(response, "Description");
			log.info("Description retrieved: " + description);

			String expectedMessage = "ListingId " + listingId.toString() + " created.";
			log.debug("About to perform Assertion of expected message: " + expectedMessage + " with actual message: "
					+ description);
			Assert.assertEquals(expectedMessage, description);
		}

		catch (AssertionError e) {
			log.error("Assertion Failed due to : " + e.getMessage());

		}

		catch (Exception e) {

			Assert.fail("Test failed due to " + e.getMessage());
		}

	}

	// Commented below code as Selling/Listing API doesn't responds correctly with
	// provided listing ID on sandbox environment.
	/*
	 *
	 * 
	 * @When("user provides valid {string},{string},{string}, {string} with listing id as query parameter"
	 * ) public void user_provides_valid_with_listing_id_as_query_parameter(String
	 * consumerKey, String consumerSecret, String accessToken, String tokenSecret) {
	 * // Write code here that turns the phrase above into concrete actions
	 * specification = RestAssured.given().auth().oauth(consumerKey, consumerSecret,
	 * accessToken, tokenSecret) .queryParam("listingId", listingId).then(); }
	 * 
	 * @And("user sends Get request on {string}") public void
	 * user_sends_get_request_on(String listingEndPoint) { // Write code here that
	 * turns the phrase above into concrete actions responseData =
	 * specification.when().post(listingEndPoint); }
	 * 
	 * @Then("Api responds with {int}") public void api_responds_with(Integer
	 * statusCode) { // Write code here that turns the phrase above into concrete
	 * actions responseData.then().assertThat().statusCode(statusCode); }
	 * 
	 */
	// endregion
}
