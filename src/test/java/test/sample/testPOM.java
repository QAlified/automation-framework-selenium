package test.sample;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.WebAutomator;
import browsers.Browser;
import pages.sample.AppointmentReservationPage;
import pages.sample.LoginPage;
import pages.sample.MainPageHealthcarePage;
import test.testBase;

public class testPOM extends testBase {
	LoginPage loginPage;
	MainPageHealthcarePage mainPage;
	AppointmentReservationPage reservationPage;
	String titleExpected = "CURA Healthcare Service";
	
	
	//Test de Login con parámetros (Correr con testng.xml o testPOMSuite.xml)
	@Test
	@Parameters({"testUrl"})
	public void testLogin(String testUrl) throws Exception {
		automator = new WebAutomator(Browser.CHROME,true, false, 30);
		this.getAutomator().goTo(testUrl);
		this.automator.maximizeWindows();
		this.mp.loadProperties("credentials");
		mainPage = new MainPageHealthcarePage(this.getAutomator());
		mainPage.clickMakeApp();
		loginPage = new LoginPage(this.getAutomator());
		loginPage.loginToMedicare(mp.getProp("loginCURAUser"), mp.getProp("loginCURAPass"));
	}
	
	@Test
	public void realizarReserva(String testUrl) throws Exception {
		testLogin(testUrl);
		reservationPage = new AppointmentReservationPage(this.getAutomator());
		//reservationPage.realizarReserva();
	}
	
	//String mainTitleActual = mainPage.getMainTitle();
	//assertEquals(mainTitleActual, titleExpected);
}
