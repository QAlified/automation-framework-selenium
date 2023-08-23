package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import automation.WebAutomator;

public class MainPage {
	WebAutomator automator;
	
	By saberMasTestAutomatizado = By.cssSelector("a[href='https://qalified.com/es/testing-automatizado/']");
	
	public MainPage(WebAutomator automator) {
		this.automator = automator;
	}
	
	public void moveToBtn() throws InterruptedException {
		automator.find(saberMasTestAutomatizado).moveToElement();

	}
	
	public void clickSaberMasTestAutomatizado() throws InterruptedException {
		this.moveToBtn();
		this.automator.find(saberMasTestAutomatizado).click();
	}

}
