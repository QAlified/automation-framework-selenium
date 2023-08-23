package test.sample;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import exceptions.MissingPropertyException;
import exceptions.NoSuchPropertyFileException;
import pages.sample.LoginPage;
import pages.sample.MainPageHealthcarePage;
import test.testBase_withoutXML;
import util.JSONHandler;
import util.ScreenshotAndCompare;


public class visualTestingLogin extends testBase_withoutXML {
	
	LoginPage loginPage;
	MainPageHealthcarePage mainPage;
	ScreenshotAndCompare screenshotAndCompare = new ScreenshotAndCompare();
	private static final org.apache.logging.log4j.Logger logger=LogManager.getLogger(visualTestingLogin.class);
	
	//Visual testing sin parámetros de TestNG
	@Test
	public void login() throws MissingPropertyException, NoSuchPropertyFileException, IOException, InterruptedException {	

		String testUrl = JSONHandler.getJSONContent("parameters.json","URLCura");
		this.automator.goTo(testUrl);
		screenshotAndCompare.takeScreenshotAndCompare("mainPage", this.automator, this.softAssert);
		this.mp.loadProperties("credentials");
		mainPage = new MainPageHealthcarePage(this.getAutomator());
		mainPage.clickMakeApp();
		screenshotAndCompare.takeScreenshotAndCompare("loginPage",this.automator,this.softAssert);
		loginPage = new LoginPage(this.getAutomator());
		loginPage.loginToMedicare(mp.getProp("loginCURAUser"), mp.getProp("loginCURAPass"));
		screenshotAndCompare.takeScreenshotAndCompare("appointmentPage",this.automator,this.softAssert);
	}
	
	//Visual testing sin parámetros de TestNG y con SparkReporter
	@Test
	public void loginSpark() throws MissingPropertyException, NoSuchPropertyFileException, IOException, InterruptedException {	
		ExtentTest test = extent.createTest("Visual testing");
		
		test.log(Status.INFO, "Obteniendo URL de archivo parameters.json");
		String testUrl = JSONHandler.getJSONContent("parameters.json","URLCura");
		test.log(Status.PASS, "Obtención de URL exitosa");

		test.log(Status.INFO, "Ingresando a sitio web con URL obtenida");
		this.automator.goTo(testUrl);
		test.log(Status.PASS, "Ingreso exitoso");
		
		test.log(Status.INFO, "Realizando captura de pantalla sobre página principal");
		screenshotAndCompare.sparkTakeScreenshotAndCompare("mainPage", this.automator, this.softAssert, test);
		
		test.log(Status.INFO, "Cargando credenciales desde el archivo credentials.properties");
		this.mp.loadProperties("credentials");
		test.log(Status.PASS, "Credenciales cargadas");
		
		test.log(Status.INFO, "Obteniendo el WebAutomator para clase MainHealtcarePage");
		mainPage = new MainPageHealthcarePage(this.getAutomator());
		test.log(Status.PASS, "Obtención de WebAutomator exitosa");
		
		test.log(Status.INFO, "Presionar botón 'Make Appointment'");
		mainPage.clickMakeApp();
		test.log(Status.PASS, "Botón presionado");
		
		test.log(Status.INFO, "Realizando captura de pantalla sobre login");
		screenshotAndCompare.sparkTakeScreenshotAndCompare("loginPage",this.automator,this.softAssert, test);
		
		test.log(Status.INFO, "Obteniendo el WebAutomator para clase LoginPage");
		loginPage = new LoginPage(this.getAutomator());
		test.log(Status.PASS, "Obtención de WebAutomator exitosa");

		test.log(Status.INFO, "Ingreso de datos y inicio de sesión");
		loginPage.loginToMedicare(mp.getProp("loginCURAUser"), mp.getProp("loginCURAPass"));
		test.log(Status.PASS, "Ingreso exitoso");

		test.log(Status.INFO, "Realizando captura de pantalla sobre vista para agendar cita");
		screenshotAndCompare.sparkTakeScreenshotAndCompare("appointmentPage",this.automator,this.softAssert, test);
	}
	

}
