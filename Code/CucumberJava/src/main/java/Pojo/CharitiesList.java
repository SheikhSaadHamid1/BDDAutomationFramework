package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CharitiesList {

	// region Fields
	@JsonProperty("CharityType")
	private int charityType;

	@JsonProperty("ImageSource")
	private String imageSource;

	@JsonProperty("DarkModeImageSource")
	private String darkModeImageSource;
	@JsonProperty("Description")
	private String description;

	@JsonProperty("Tagline")
	private String tagline;

	// endregion

	// region Methods

	public int getCharityType() {
		return charityType;
	}

	public String getImageSource() {
		return imageSource;
	}

	public String getDarkModeImageSource() {
		return darkModeImageSource;
	}

	public String getDescription() {
		return description;
	}

	public String getTagline() {
		return tagline;
	}

	public void setCharityType(int CharityType) {
		this.charityType = CharityType;
	}

	public void setImageSource(String ImageSource) {
		this.imageSource = ImageSource;
	}

	public void setDarkModeImageSource(String DarkModeImageSource) {
		this.darkModeImageSource = DarkModeImageSource;
	}

	public void setDescription(String Description) {
		this.description = Description;
	}

	public void setTagline(String Tagline) {
		this.tagline = Tagline;
	}

	// endregion

}
