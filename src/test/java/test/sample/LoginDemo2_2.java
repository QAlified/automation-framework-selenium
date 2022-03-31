package test.sample;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.UIElement;
import exceptions.MissingPropertyException;
import test.TestBase;

public class LoginDemo2_2 extends TestBase {
	
	
	private static final org.apache.logging.log4j.Logger logger=LogManager.getLogger(LoginDemo2_2.class);
	
	
	@Test
	@Parameters({"testUrl"})
	public void login(String testUrl) throws MissingPropertyException {	
		
		this.automator.goTo(testUrl);
		
		UIElement btnMakeApp = this.getAutomator().find(By.id("btn-make-appointment"));
		btnMakeApp.click();
		
		UIElement inputUser = this.getAutomator().find(By.id("txt-username"));
		inputUser.setText("John Doe");
		
		UIElement inputPsw = this.getAutomator().find(By.id("txt-password"));
		inputPsw.setText("ThisIsNotAPassword");
		
		UIElement btnLogin = this.getAutomator().find(By.id("btn-login"));
		btnLogin.click();
		
	}

}
