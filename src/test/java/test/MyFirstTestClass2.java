package test;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import exceptions.MissingPropertyException;
import exceptions.NoSuchPropertyFileException;
import pom.WorkWithLogin;

public class MyFirstTestClass2 extends TestBase {
	
	
	//Logger
	private static final org.apache.logging.log4j.Logger logger=LogManager.getLogger( MyFirstTestClass2.class);
	
	
	@Test
	@Parameters({"testUrl"})
	public void loginTestCase(String testUrl) throws NoSuchPropertyFileException, MissingPropertyException {
		
		logger.info("Navigate to the url of CURA Healthcare Service{}",testUrl);
		this.automator.goTo(testUrl);
		this.automator.maximizeWindows();
		mp.loadProperties("credentials");

		WorkWithLogin LoginCURA = new WorkWithLogin(automator);
		LoginCURA.clickMakeAppointment();
		LoginCURA.loginCURA(mp.getProp("loginCURAUser"), mp.getProp("loginCURAPass"));
		LoginCURA.clickLogin();
		LoginCURA.verifyLogin();
		 
	}
	
	

}
