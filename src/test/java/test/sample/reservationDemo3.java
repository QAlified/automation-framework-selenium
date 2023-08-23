package test.sample;

import java.io.IOException;

import org.apache.commons.csv.CSVRecord;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import config.Config;
import exceptions.MissingPropertyException;
import exceptions.NoSuchPropertyFileException;
import pages.sample.AppointmentConfirmationPage;
import pages.sample.AppointmentReservationPage;
import pages.sample.LoginPage;
import pages.sample.MainPageHealthcarePage;
import test.testBase;
import util.CSVHandler;

public class reservationDemo3 extends testBase {
	
	LoginPage loginPage;
	MainPageHealthcarePage mainPage;
	AppointmentReservationPage reservationPage;
	AppointmentConfirmationPage confirmationPage;
	CSVHandler fileHandler;
	
	/* Test de reserva de citas en la página de CURA parametrizado y usando el archivo CSV
	 * (No es posible correr tests parametrizados desde la línea de
	 * comandos. Se debe hacer click derecho en el archivo testng.xml o reservationSuite.xml y presionar Run As > TestNG Suite)*/
	@Test
	@Parameters({"testUrl"})
	//Se trae el parámetro "testUrl" del archivo testng.xml	
	public void makeMultipleAppointments(String testUrl) throws MissingPropertyException, IOException, InterruptedException, NoSuchPropertyFileException {	
		this.automator.goTo(testUrl);
		this.getAutomator().maximizeWindows();
		this.mp.loadProperties("credentials");
		
		//Homepage
		mainPage = new MainPageHealthcarePage(this.getAutomator());
		mainPage.clickMakeApp();
		
		//Login on the web
		loginPage = new LoginPage(this.getAutomator());
		loginPage.loginToMedicare(mp.getProp("loginCURAUser"), mp.getProp("loginCURAPass"));
	
		//Reservation page
		reservationPage = new AppointmentReservationPage(this.getAutomator());
		
		//Booking confirmation page
		confirmationPage = new AppointmentConfirmationPage(this.getAutomator());
		
		fileHandler = new CSVHandler(Config.FILES_PATH + "datos.csv");
		fileHandler.loadDataFromCSVWithHeader();
		for (CSVRecord record : fileHandler.getRecords()) {
			reservationPage.makeAppointment(
					record.get("facility"),
					Boolean.parseBoolean(record.get("readmission")),
					record.get("program"),
					record.get("visit_date"),
					record.get("comment"));
			confirmationPage.goToHomePage();
			mainPage.clickMakeApp();  
			Thread.sleep(3000); //Delay
		}
		
		mainPage.goToHistory();
		Thread.sleep(3000); //Delay
	}

}