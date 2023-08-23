package test.sample;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.UIElement;
import exceptions.MissingPropertyException;
import test.testBase;

public class loginDemo2 extends testBase {
	
	
	private static final org.apache.logging.log4j.Logger logger=LogManager.getLogger(loginDemo2.class);
	
	
	/* Test de login parametrizado (No es posible correr tests parametrizados desde la línea de
	 * comandos. Se debe hacer click derecho en el archivo testng.xml y presionar Run As > TestNG Suite)*/
	@Test
	@Parameters({"testUrl"})
	//Se trae el parámetro "testUrl" del archivo testng.xml	
	public void loginWithTemplate(String testUrl) throws MissingPropertyException {			
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
