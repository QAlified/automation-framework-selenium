package test.sample;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import exceptions.MissingPropertyException;
import exceptions.NoSuchPropertyFileException;
import pages.sample.LoginPage;
import pages.sample.MainPageHealthcarePage;
import test.testBase;
import util.JSONHandler;

public class loginDemo4 extends testBase {
	
	LoginPage loginPage;
	MainPageHealthcarePage mainPage;
	
	private static final org.apache.logging.log4j.Logger logger=LogManager.getLogger(loginDemo4.class);
	
	
	//Test de login utilizando el POM y parámetros a través de archivo JSON
	/*El testBase utiliza parámetros del archivo testng.xml, por lo que este test debe ejecutarse haciendo click derecho en el archivo testng.xml y presionar Run As > TestNG Suite)*/
	@Test
	public void login() throws MissingPropertyException, NoSuchPropertyFileException {	
		String testUrl = JSONHandler.getJSONContent("parameters.json","URLCura");
		this.automator.goTo(testUrl);
		this.mp.loadProperties("credentials");
		mainPage = new MainPageHealthcarePage(this.getAutomator());
		mainPage.clickMakeApp();
		
		loginPage = new LoginPage(this.getAutomator());
		loginPage.loginToMedicare(mp.getProp("loginCURAUser"), mp.getProp("loginCURAPass"));
	}

}
