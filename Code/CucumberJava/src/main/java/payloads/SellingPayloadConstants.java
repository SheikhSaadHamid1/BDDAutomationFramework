package payloads;

import java.util.Properties;
import utilities.ConfigReader;

public class SellingPayloadConstants {
	// region Fields
	private static ConfigReader apiDataConfig = new ConfigReader();
	private static Properties apiData = apiDataConfig.initializerAPIProperties();
	private static int category;
	private static String title;
	private static String subtitle;
	private static String firstDescprition;
	private static String secondDescription;
	private static Double startPrice;
	private static Double reservedPrice;
	private static Double buyNowPrice;
	private static int duration;
	private static int pickup;
	private static int firstShippingOptionType;
	private static Double firstShippingOptionPrice;
	private static String firstShippingOptionMethod;
	private static int firstShippingOptionShippingId;
	private static int secondShippingOptionType;
	private static Double secondShippingOptionPrice;
	private static String secondShippingOptionMethod;
	private static int secondShippingOptionShippingId;
	private static int firstPaymentMethod;
	private static int secondPayment;
	// endregion

	// region Methods
	// Getters methods for all the fields required for generating Payload data
	// All Getters are Static, therefore no instantiation is required
	public static int getCategory() {

		return Integer.parseInt(apiData.getProperty("Category"));
	}

	public static String getTitle() {
		return apiData.getProperty("Title");
	}

	public static String getSubtitle() {
		return apiData.getProperty("Subtitle");
	}

	public static String getFirstDescprition() {
		return apiData.getProperty("FirstDescription");
	}

	public static String getSecondDescription() {
		return apiData.getProperty("SecondDescription");
	}

	public static Double getStartPrice() {
		return Double.parseDouble(apiData.getProperty("StartPrice"));
	}

	public static Double getReservedPrice() {
		return Double.parseDouble(apiData.getProperty("ReservedPrice"));
	}

	public static Double getBuyNowPrice() {
		return Double.parseDouble(apiData.getProperty("BuyNowPrice"));
	}

	public static int getDuration() {
		return Integer.parseInt(apiData.getProperty("Duration"));
	}

	public static int getPickup() {
		return Integer.parseInt(apiData.getProperty("Pickup"));
	}

	public static int getFirstShippingOptionType() {
		return Integer.parseInt(apiData.getProperty("FirstShippingOptionType"));
	}

	public static Double getFirstShippingOptionPrice() {
		return Double.parseDouble(apiData.getProperty("FirstShippingOptionPrice"));
	}

	public static String getFirstShippingOptionMethod() {
		return apiData.getProperty("FirstShippingOptionMethod");
	}

	public static int getFirstShippingOptionShippingId() {
		return Integer.parseInt(apiData.getProperty("FirstShippingOptionShippingId"));
	}

	public static int getSecondShippingOptionType() {
		return Integer.parseInt(apiData.getProperty("SecondShippingOptionType"));
	}

	public static Double getSecondShippingOptionPrice() {
		return Double.parseDouble(apiData.getProperty("SecondShippingOptionPrice"));
	}

	public static String getSecondShippingOptionMethod() {
		return apiData.getProperty("SecondShippingOptionMethod");
	}

	public static int getSecondShippingOptionShippingId() {
		return Integer.parseInt(apiData.getProperty("SecondShippingOptionShippingId"));
	}

	public static int getFirstPaymentMethod() {
		return Integer.parseInt(apiData.getProperty("FirstPaymentMethod"));
	}

	public static int getSecondPaymentMethod() {
		return Integer.parseInt(apiData.getProperty("SecondPaymentMethod"));
	}

	// endregion

}
