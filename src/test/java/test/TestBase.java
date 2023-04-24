package test;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import automation.WebAutomator;
import browsers.Browser;
import util.PropertiesHandler;

public class TestBase {
	
	protected WebAutomator automator;
	protected PropertiesHandler mp;
	
	
	// Logger
	private static final org.apache.logging.log4j.Logger logger=LogManager.getLogger(TestBase.class);
	
	
	
	@BeforeMethod
	@Parameters({"browser","isHeadless", "max_wait"})
	public void setUpDriver(@Optional("CHROME") String browser, Boolean isHeadless, @Optional("30") Duration max_wait) throws Exception 
	{
		//Initialize WebDriver
		Browser b = Browser.valueOf(browser);
		automator = new WebAutomator(b,isHeadless, true, max_wait);
		//Initialize property Manager
		mp = new PropertiesHandler();
	}
	
	public void setUpDriverParaIncognito(String browser, @Optional("30") Duration max_wait) throws Exception 
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
		}
	}
	
	@AfterMethod
	public void tearDownDriver() throws Exception {
		automator.closeAll();
	}

	protected WebAutomator getAutomator(){
		return this.automator;
	}
}
