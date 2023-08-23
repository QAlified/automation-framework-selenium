package test.sample;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import exceptions.MissingPropertyException;
import exceptions.NoSuchPropertyFileException;
import pages.sample.LoginPage;
import pages.sample.MainPageHealthcarePage;
import test.testBase;

public class loginDemo3 extends testBase {
	
	LoginPage loginPage;
	MainPageHealthcarePage mainPage;
	
	private static final org.apache.logging.log4j.Logger logger=LogManager.getLogger(loginDemo3.class);
	
	/* Test de login parametrizado y con uso del testBase (No es posible correr tests parametrizados desde la línea de
	 * comandos. Se debe hacer click derecho en el archivo testng.xml y presionar Run As > TestNG Suite)*/
	@Test
	@Parameters({"testUrl"})
	//Se trae el parámetro "testUrl" del archivo testng.xml	
	public void login(String testUrl) throws MissingPropertyException, NoSuchPropertyFileException {	
		this.automator.goTo(testUrl);
		this.mp.loadProperties("credentials");
		mainPage = new MainPageHealthcarePage(this.getAutomator());
		mainPage.clickMakeApp();
		
		loginPage = new LoginPage(this.getAutomator());
		loginPage.loginToMedicare(mp.getProp("loginCURAUser"), mp.getProp("loginCURAPass"));
	}

}
