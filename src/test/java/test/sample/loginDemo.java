package test.sample;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class loginDemo {
	
	//Declaración de variables
	String driverPath;
	WebDriver driver;
	WebDriverWait wait;
	String url;
	
	//Prueba del login sin POM ni el template
	@Test
	public void loginWithoutPOMNorTemplate() {
		driverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 30);
		url = "https://katalon-demo-cura.herokuapp.com";
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
		
		driver.quit();
	}

}
