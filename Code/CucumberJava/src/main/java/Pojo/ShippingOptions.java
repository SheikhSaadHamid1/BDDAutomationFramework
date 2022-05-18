package pojo;

public class ShippingOptions {
	// region Fields
	private int Type;
	private double Price;
	private String Method;
	private int ShippingId;
	// endregion

	// region Constructor
	public ShippingOptions(int type, double price, String method, int shippingId) {
		this.Type = type;
		this.Price = price;
		this.Method = method;
		this.ShippingId = shippingId;
	}

	// endregion

	// region Methods

	public int getType() {
		return Type;
	}

	public double getPrice() {
		return Price;
	}

	public String getMethod() {
		return Method;
	}

	public int getShippingId() {
		return ShippingId;
	}

	// endregion

}
