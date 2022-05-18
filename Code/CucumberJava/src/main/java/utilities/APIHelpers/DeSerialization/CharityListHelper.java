package utilities.APIHelpers.DeSerialization;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CharityListHelper {

	/*
	 * CharityListHelper is a Static utility to perform Deserialization operations
	 * 
	 */
	// region Fields
	private static Logger log = LogManager.getLogger(CharityListHelper.class.getName());
	// endregion

	// region Constructor
	private CharityListHelper() {
		// Private constructor to restrict initialization of CharityListHelper class
	}
	// endregion

	// region Methods

	public static ArrayList<String> getDescriptionList(String response)
			throws JsonMappingException, JsonProcessingException {
		ArrayList<String> charities = new ArrayList<String>();
		if (response != null && !(response.isEmpty())) {
			log.debug("About to Deserialize JSON response to CharitiesList class");
			// DeSerializing JSON response to respective POJO class
			ObjectMapper mapper = new ObjectMapper();
			pojo.CharitiesList[] objArray = mapper.readValue(response, pojo.CharitiesList[].class);
			for (int i = 0; i < objArray.length; i++) {
				if (objArray[i].getDescription() != null) {
					log.debug("About to add Charities list description in list of charities");
					charities.add(objArray[i].getDescription());
					log.info(objArray[i].getDescription() + " is added in list of charities");
				} else {
					log.error("Null or Empty Charity List Description cannot be added");
				}

			}

		} else {
			log.error("Null or Empty respose was provided");
		}

		return charities;

	}
	// endregion
}
