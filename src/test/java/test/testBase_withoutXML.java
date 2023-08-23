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
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;
import util.JSONHandler;
import automation.WebAutomator;
import browsers.Browser;
import config.SparkConfig;
import junit.framework.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import util.PropertiesHandler;

public class testBase_withoutXML {
	
	protected WebAutomator automator;
	protected PropertiesHandler mp;
    protected SoftAssert softAssert = new SoftAssert();
	protected SparkConfig spark = new SparkConfig();
	protected ExtentReports extent = new ExtentReports();
	
	// Logger
	private static final org.apache.logging.log4j.Logger logger=LogManager.getLogger(testBase_withoutXML.class);
	
	
	
	@BeforeMethod
	public void setUpDriver() throws Exception 
	{
		
		//Getting test parameters
		String browser = JSONHandler.getJSONContent("parameters.json","testParams.browser");
		Boolean isHeadless = Boolean.parseBoolean(JSONHandler.getJSONContent("parameters.json","testParams.isHeadless"));
		Long max_wait = Long.parseLong(JSONHandler.getJSONContent("parameters.json","testParams.max_wait"));
		//Initialize WebDriver
		Browser b = Browser.valueOf(browser);
		automator = new WebAutomator(b,isHeadless, true, max_wait);
		//Initialize SparkReporter
		spark.startSparkReporter(extent);
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
	public void tearDownDriver() throws Exception {
		Boolean closeBrowser = Boolean.parseBoolean(JSONHandler.getJSONContent("parameters.json","testParams.max_wait"));
		if (closeBrowser) {
			automator.closeBrowser();
			extent.flush();
			softAssert.assertAll();
		}
	}
	
	@AfterMethod
	public void tearDownAllDriver() throws Exception {
		automator.closeAll();
		extent.flush();
		softAssert.assertAll();
	}

	protected WebAutomator getAutomator(){
		return this.automator;
	}
	
}
