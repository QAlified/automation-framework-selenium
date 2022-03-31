package pages.sample;

import org.openqa.selenium.By;

import automation.WebAutomator;

public class MainPageHealthcarePage{
	
	WebAutomator automator;
		
	By btnMakeApp = By.id("btn-make-appointment");
	By titleMainPage = By.xpath("//h1[contains(text(),'CURA Healthcare Service')]");
	By btnBurgerMenu = By.id("menu-toggle");
	By btnHistory = By.linkText("History");
	
	public MainPageHealthcarePage(WebAutomator automator) {
		this.automator = automator;
	}
	
	public void clickMakeApp() {
		automator.find(btnMakeApp).click();
	}
	
	public String getMainTitle() {
		return automator.find(titleMainPage).getText();
	}
	
	public void goToHistory() {
		automator.find(btnBurgerMenu).click();
		automator.find(btnHistory).click();
	}
}