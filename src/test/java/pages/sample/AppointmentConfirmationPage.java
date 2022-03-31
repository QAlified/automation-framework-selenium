package pages.sample;
import org.openqa.selenium.By;

import automation.WebAutomator;

public class AppointmentConfirmationPage {
	
	WebAutomator automator;
	
	By buttonGoToHomePage = By.linkText("Go to Homepage");
	
	public AppointmentConfirmationPage(WebAutomator automator) {
		this.automator = automator;
	}
	
	public void goToHomePage() {
		this.automator.find(buttonGoToHomePage).click();
	}
	
}
