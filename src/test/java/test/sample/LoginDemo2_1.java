package test.sample;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginDemo2_1 {
	
	String driverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
	WebDriver driver;
	WebDriverWait wait;
	String url = "https://katalon-demo-cura.herokuapp.com";
	
	@Test
	public void login() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(url);
		
		WebElement btnMakeApp = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-make-appointment")));
		btnMakeApp.click();
		
		WebElement inputUser = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txt-username")));
		inputUser.sendKeys("John Doe");
		
		WebElement inputPsw = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txt-password")));
		inputPsw.sendKeys("ThisIsNotAPassword");
		
		WebElement btnLogin = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-login")));
		btnLogin.click();
		
		this.driver.quit();
	}

}
