package pojo;

import java.util.List;

public class SellingList {

	/*
	 * Pojo class created to Serialize Body content of a JSON Payload
	 * 
	 */

	// region fields
	private int Category;
	private String Title;
	private String Subtitle;
	private List<String> Description;
	private double StartPrice;
	private double ReservedPrice;
	private double BuyNowPrice;
	private int Duration;
	private int Pickup;
	private List<ShippingOptions> ShippingOptions;
	private List<Integer> PaymentMethods;
	// endregion

	// region Constructor
	public SellingList(int category, String title, String subtitle, List<String> description, double startPrice,
			double reservedPrice, double buyNowPrice, int duration, int pickup, List<ShippingOptions> shippingOptions,
			List<Integer> paymentMethods) {
		this.Category = category;
		this.Title = title;
		this.Subtitle = subtitle;
		this.Description = description;
		this.StartPrice = startPrice;
		this.ReservedPrice = reservedPrice;
		this.BuyNowPrice = buyNowPrice;
		this.Duration = duration;
		this.Pickup = pickup;
		this.ShippingOptions = shippingOptions;
		this.PaymentMethods = paymentMethods;
	}
	// endregion

	// region Getters
	public int getCategory() {
		return Category;
	}

	public String getTitle() {
		return Title;
	}

	public String getSubtitle() {
		return Subtitle;
	}

	public List<String> getDescription() {
		return Description;
	}

	public double getStartPrice() {
		return StartPrice;
	}

	public double getReservedPrice() {
		return ReservedPrice;
	}

	public double getBuyNowPrice() {
		return BuyNowPrice;
	}

	public int getDuration() {
		return Duration;
	}

	public int getPickup() {
		return Pickup;
	}

	public List<ShippingOptions> getShippingOptions() {
		return ShippingOptions;
	}

	public List<Integer> getPaymentMethods() {
		return PaymentMethods;
	}
	// endRegion

}
