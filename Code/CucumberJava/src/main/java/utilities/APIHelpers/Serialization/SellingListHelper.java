package utilities.APIHelpers.Serialization;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.google.gson.Gson;
import payloads.SellingPayloadConstants;
import pojo.SellingList;
import pojo.ShippingOptions;

public class SellingListHelper {

	// region Fields
	private static Logger log = LogManager.getLogger(SellingListHelper.class.getName());
	// endregion
	// Method to Serialize Java Pojo class and convert into JSON Payload String

	// region Methods
	public static String getPayload() {
		String payload = "";

		log.debug("About to add Shipping options from Selling Payload Constants class in Shipping option list");
		List<ShippingOptions> shippingOptions = new ArrayList<ShippingOptions>();
		shippingOptions.add(new ShippingOptions(

				SellingPayloadConstants.getFirstShippingOptionType(),
				SellingPayloadConstants.getFirstShippingOptionPrice(),
				SellingPayloadConstants.getFirstShippingOptionMethod(),
				SellingPayloadConstants.getFirstShippingOptionShippingId())

		);

		shippingOptions.add(new ShippingOptions(

				SellingPayloadConstants.getSecondShippingOptionType(),
				SellingPayloadConstants.getSecondShippingOptionPrice(),
				SellingPayloadConstants.getSecondShippingOptionMethod(),
				SellingPayloadConstants.getSecondShippingOptionShippingId())

		);

		log.info("Shipping options list is created");

		log.debug("About to add Description from Selling Payload Constants class in description list");

		List<String> description = new ArrayList<String>();

		description.add(SellingPayloadConstants.getFirstDescprition());
		description.add(SellingPayloadConstants.getSecondDescription());
		log.info("Description list is created");

		log.debug("About to add Payment Method from Selling Payload Constants class in Payment Method list");
		List<Integer> paymentMethod = new ArrayList<Integer>();

		paymentMethod.add(SellingPayloadConstants.getFirstPaymentMethod());
		paymentMethod.add(SellingPayloadConstants.getSecondPaymentMethod());
		log.info("Payment method list is created");
		// Initializing Selling List through using a Constructor

		log.debug("About to initialize SellingList with providing all paramters in constructor");
		SellingList list = new SellingList(SellingPayloadConstants.getCategory(), SellingPayloadConstants.getTitle(),
				SellingPayloadConstants.getSubtitle(), description, SellingPayloadConstants.getStartPrice(),
				SellingPayloadConstants.getReservedPrice(), SellingPayloadConstants.getBuyNowPrice(),
				SellingPayloadConstants.getDuration(), SellingPayloadConstants.getPickup(), shippingOptions,
				paymentMethod);
		log.info("SellingList is initialized");

		// Serializing Class object to JSON String.
		log.debug("About to use GSON to Serialize SellingList object into a JSON string payload.");
		Gson gson = new Gson();
		try {
			payload = gson.toJson(list);
			log.info("JSON String payload is created");
		} catch (Exception e) {
			log.error("JSON String Payload is not created");
		}

		return payload;

	}
	// endregion

}
