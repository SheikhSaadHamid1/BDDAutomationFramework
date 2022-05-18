package utilities.APIHelpers.specifications;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utilities.Common;
import utilities.ConfigConstants;

public class Specifications {
	// region Fields
	private RequestSpecification request;
	private static Logger log = LogManager.getLogger(Specifications.class.getName());
	private static ConfigConstants config = new ConfigConstants();
	// endregion

	// region Methods
	public RequestSpecification requestSpecification(String uri, String className) {
		log.debug("About to construct Request specification with " + uri
				+ " and using className to create specific API Request and Response Log file");
		try {
			if (uri != null && !(uri.isEmpty())) {
				RestAssured.baseURI = uri;
				request = new RequestSpecBuilder().setBaseUri(uri)
						.addFilter(RequestLoggingFilter.logRequestTo(Common.getLogFile(className)))
						.addFilter(ResponseLoggingFilter.logResponseTo(Common.getLogFile(className)))
						.setContentType(ContentType.JSON).build();
				log.info("Request Specification created. API logs for both Request and Response will be added in "
						+ className + "_log file");

			}

			else {
				log.error("Null or empty URI is provided for tests");
			}

		} catch (Exception e) {
			log.error("Request Specification failed due to error: " + e.getMessage());
		}

		return request;
	}

	public RequestSpecification requestSpecification(String className) {
		log.debug(
				"About to construct Request specification using className to create specific API Request and Response Log file");
		try {

			request = new RequestSpecBuilder()
					.addFilter(RequestLoggingFilter.logRequestTo(Common.getLogFile(className)))
					.addFilter(ResponseLoggingFilter.logResponseTo(Common.getLogFile(className)))

					.build();

			log.info("Request Specification created. API logs for both Request and Response will be added in "
					+ className + "_log file");

		} catch (Exception e) {
			log.error("Request Specification failed due to error: " + e.getMessage());
		}

		return request;
	}

	public ResponseSpecification responseSpecfication() {
		ResponseSpecification responseSpec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();
		return responseSpec;

	}
	//endregion

}
