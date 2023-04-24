package test.sample;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.csv.CSVRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import config.Config;
import exceptions.MissingPropertyException;
import pages.sample.AppointmentConfirmationPage;
import pages.sample.AppointmentReservationPage;
import pages.sample.LoginPage;
import pages.sample.MainPageHealthcarePage;
import test.TestBase;
import util.CSVHandler;

public class ReservationDemo4 {
	
	WebDriver driver;
	WebDriverWait wait;
	String driverPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
	String url = "https://katalon-demo-cura.herokuapp.com";
	
	@Test
	public void makeMultipleAppointments() throws MissingPropertyException, IOException, InterruptedException {	
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(url);
		
		//Homepage
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-make-appointment"))).click();
		
		//Login on the web
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txt-username"))).sendKeys("John Doe");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txt-password"))).sendKeys("ThisIsNotAPassword");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-login"))).click();
		
		//Reservation page 1
		Select select = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("combo_facility"))));
		select.selectByValue("Seoul CURA Healthcare Center");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("chk_hospotal_readmission"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("radio_program_medicare"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txt_visit_date"))).sendKeys("13/04/2021");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txt_comment"))).sendKeys("Comentario de prueba");
		//Confirm the reservation
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-book-appointment"))).click();
		Thread.sleep(3000); //Delay
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Go to Homepage"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-make-appointment"))).click();

		//Reservation page 2
		Select select2 = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("combo_facility"))));
		select2.selectByValue("Seoul CURA Healthcare Center");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("chk_hospotal_readmission"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("radio_program_medicare"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txt_visit_date"))).sendKeys("13/04/2021");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txt_comment"))).sendKeys("Comentario de prueba");
		//Confirm the reservation
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-book-appointment"))).click();
		Thread.sleep(3000); //Delay
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Go to Homepage"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-make-appointment"))).click();
		
		//Reservation page 3
		Select select3 = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(By.id("combo_facility"))));
		select3.selectByValue("Seoul CURA Healthcare Center");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("chk_hospotal_readmission"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("radio_program_medicare"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txt_visit_date"))).sendKeys("13/04/2021");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("txt_comment"))).sendKeys("Comentario de prueba");
		//Confirm the reservation
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btn-book-appointment"))).click();
		Thread.sleep(3000); //Delay
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Go to Homepage"))).click();
		

		//Historical Consultation
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu-toggle"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("History"))).click();
		
		Thread.sleep(3000); //Delay
		driver.quit();
	}

}