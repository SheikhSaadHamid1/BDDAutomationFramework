package pages.homepage;

import org.openqa.selenium.By;

public class HomePageConstants {
		//region Fields
		private static By MotorsLocator = By.xpath(".//a[@classiclink='motors']");
		//endregion
		
		//region Methods
		public static By getMotorsLocator() {
			return MotorsLocator;
		}
		
		//endregion
		
		
		
		
		
}
