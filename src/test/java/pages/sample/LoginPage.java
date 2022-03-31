package pages.sample;

import org.openqa.selenium.By;

import automation.WebAutomator;

public class LoginPage {
	
	WebAutomator automator;
	
	By username = By.id("txt-username");
	By password = By.id("txt-password");
	By btnLogin = By.id("btn-login");
	By titleTextLoginPage = By.xpath("//h2[contains(text(),'Login')]");
	
	
	public LoginPage(WebAutomator automator) {
		this.automator = automator;
	}
	
	private void setUsername(String username) {
		automator.find(this.username).setText(username);
	}
	
	private void setPassword(String password) {
		automator.find(this.password).setText(password);
	}
	
	private void clickLogin() {
		automator.find(btnLogin).click();
	}
	
	public String getLoginTitle(){
		return automator.find(titleTextLoginPage).getText();
	}

	public void loginToMedicare(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
		this.clickLogin();
	}
	
	
}
