package pages;

import org.openqa.selenium.By;

import automation.WebAutomator;

public class MainPage {
	WebAutomator automator;
	
	By saberMasTestAutomatizado = By.cssSelector("a[href='https://qalified.com/test-automation']");
	
	public MainPage(WebAutomator automator) {
		this.automator = automator;
	}
	
	public void moveToBtn() {
		automator.find(saberMasTestAutomatizado).moveToElement();
	}
	
	public void clickSaberMasTestAutomatizado() {
		this.moveToBtn();
		this.automator.find(saberMasTestAutomatizado).click();
	}

}
