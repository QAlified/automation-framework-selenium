package test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.Map;

import javax.imageio.ImageIO;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import automation.WebAutomator;
import browsers.Browser;
import junit.framework.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import util.PropertiesHandler;
import config.SparkConfig;

public class testBase {
	
	protected WebAutomator automator;
	protected PropertiesHandler mp;
	protected SoftAssert softAssert = new SoftAssert();
	SparkConfig spark;
	ExtentReports extent = new ExtentReports();

	
	// Logger
	private static final org.apache.logging.log4j.Logger logger=LogManager.getLogger(testBase.class);
	
	
	
	@BeforeMethod
	@Parameters({"browser","isHeadless", "max_wait"})
	public void setUpDriver(@Optional("CHROME") String browser, Boolean isHeadless, @Optional("30") long max_wait) throws Exception 
	{
		//Initialize WebDriver
		Browser b = Browser.valueOf(browser);
		//Initialize SparkReporter
		spark.startSparkReporter(extent);
		//Declare automator with his parameters
		automator = new WebAutomator(b,isHeadless, true, max_wait);
		//Initialize property Manager
		mp = new PropertiesHandler();
	}
	
	public void setUpDriverParaIncognito(String browser, @Optional("30") long max_wait) throws Exception 
	{
		logger.info("Se abre un nuevo driver con el navegador incognito");
		Browser b = Browser.valueOf(browser);
		automator = new WebAutomator(b, true, true, max_wait);		
	}
	
	@AfterClass
	@Parameters({"close_browser_after_execution"})
	public void tearDownDriver(@Optional("true") boolean closeBrowser) throws Exception {
		if (closeBrowser) {
			automator.closeBrowser();
			extent.flush();
			softAssert.assertAll();
		}
	}
	
	@AfterMethod
	public void tearDownDriver() throws Exception {
		automator.closeAll();
		extent.flush();
		softAssert.assertAll();
	}

	protected WebAutomator getAutomator(){
		return this.automator;
	}
	
	
}
