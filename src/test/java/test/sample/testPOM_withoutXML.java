package test.sample;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import automation.WebAutomator;
import browsers.Browser;
import pages.sample.AppointmentReservationPage;
import pages.sample.LoginPage;
import pages.sample.MainPageHealthcarePage;
import test.testBase_withoutXML;
import util.JSONHandler;

public class testPOM_withoutXML extends testBase_withoutXML {
	LoginPage loginPage;
	MainPageHealthcarePage mainPage;
	AppointmentReservationPage reservationPage;
	String titleExpected = "CURA Healthcare Service";
	
	
	
	@Test
	public void testLogin() throws Exception {
		String testUrl = JSONHandler.getJSONContent("parameters.json","URLCura");
		this.getAutomator().goTo(testUrl);
		this.automator.maximizeWindows();
		this.mp.loadProperties("credentials");
		mainPage = new MainPageHealthcarePage(this.getAutomator());
		mainPage.clickMakeApp();
		loginPage = new LoginPage(this.getAutomator());
		loginPage.loginToMedicare(mp.getProp("loginCURAUser"), mp.getProp("loginCURAPass"));
	}
	
	@Test
	public void realizarReserva() throws Exception {
		testLogin();
		reservationPage = new AppointmentReservationPage(this.getAutomator());
		//reservationPage.realizarReserva();
	}
	
	//String mainTitleActual = mainPage.getMainTitle();
	//assertEquals(mainTitleActual, titleExpected);
}
