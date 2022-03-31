package test.sample;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import exceptions.MissingPropertyException;
import exceptions.NoSuchPropertyFileException;
import pages.sample.LoginPage;
import pages.sample.MainPageHealthcarePage;
import test.TestBase;

public class LoginDemo2_3 extends TestBase {
	
	LoginPage loginPage;
	MainPageHealthcarePage mainPage;
	
	private static final org.apache.logging.log4j.Logger logger=LogManager.getLogger(LoginDemo2_3.class);
	
	@Test
	@Parameters({"testUrl"})
	public void login(String testUrl) throws MissingPropertyException, NoSuchPropertyFileException {	
		this.automator.goTo(testUrl);
		this.mp.loadProperties("credentials");
		mainPage = new MainPageHealthcarePage(this.getAutomator());
		mainPage.clickMakeApp();
		
		loginPage = new LoginPage(this.getAutomator());
		loginPage.loginToMedicare(mp.getProp("loginCURAUser"), mp.getProp("loginCURAPass"));
	}

}
