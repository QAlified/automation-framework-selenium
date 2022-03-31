package test.sample;

import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;


import automation.UIElement;
import test.TestBase;
import util.Camera;

public class SampleDemo1 extends TestBase {
	Camera camera;

	@Test
	public void login() throws Exception {
		//Navigate to the web url
		this.getAutomator().goTo(mp.getProp("url_demo"));
		//Click on the Make Appointment button...
		UIElement btnMakeApp = getAutomator().find(By.id("btn-make-appointment"));
		btnMakeApp.click();
		//User input in the Username field...
		UIElement inputUser = getAutomator().find(By.id("txt-username"));
		inputUser.setText(mp.getProp("username"));
		//Enter password in the Password field...
		UIElement inputPsw = getAutomator().find(By.id("txt-password"));
		inputPsw.setText(mp.getProp("password"));
		//Click on the Login button
		UIElement btnLogin = getAutomator().find(By.id("btn-login"));
		camera = new Camera(this.automator);
		camera.captureAllPage();
		btnLogin.submit();
		
		UIElement formAppointment = getAutomator().find(By.cssSelector("form.form-horizontal"));
		//Verify that the form is visible.
		assertTrue(formAppointment.isDisplayed());
	}
	
	//Sample TestNG Annotations
	/*@BeforeMethod
	public void setUpPage() throws MissingPropertyException {
		this.getAutomator().goTo(properties.getUrlDemo());
		this.getAutomator().maximizeWindows();
	}
	
	@Test
	public void loginTest() throws Exception {
		//Verifico Url.
		assertEquals(this.getAutomator().getCurrentUrl(), properties.getUrlDemo(), "La URL esperada no coincide con la actual");
		
		UIElement btnMakeApp = getAutomator().find(By.id("btn-make-appointment"));
		btnMakeApp.click();
		UIElement inputUser = getAutomator().find(By.id("txt-username"));
		inputUser.setText(properties.getUsername());
		UIElement inputPsw = getAutomator().find(By.id("txt-password"));
		inputPsw.setText(properties.getPassword());
		UIElement btnLogin = getAutomator().find(By.id("btn-login"));
		btnLogin.submit();
		UIElement formAppointment = getAutomator().find(By.cssSelector("form.form-horizontal"));
		//Verifico que el formulario este visible.
		assertTrue(formAppointment.isDisplayed());
	}
	
	@AfterMethod
	public void endTest() {
		this.getAutomator().closeBrowser();
	}*/
	
}
