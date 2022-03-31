package pages;

import org.openqa.selenium.By;

import automation.WebAutomator;

public class TestingAutomatizadoPage {
	WebAutomator automator;
	
	By btnContactanos = By.linkText("CONTÁCTANOS");
	By campoNombre = By.name("txtName");
	By campoTelefono = By.name("txtPhone");
	By campoEmail = By.name("txtEmail");
	By campoMessage = By.name("txtMsg");
	By btnSend = By.xpath("//div[@class='btnSend']");
	
	public TestingAutomatizadoPage(WebAutomator automator) {
		this.automator = automator;
	}
	
	public void clickBotonContactanos() {
		automator.find(btnContactanos).click();
	}
	
	private void ingresarNombre() {
		automator.find(campoNombre).setText("test");
	}
	
	private void ingresarTelefono() {
		automator.find(campoTelefono).setText("098000000");
	}
	
	private void ingresarEmail() {
		automator.find(campoEmail).setText("test@qalified.com");
	}
	
	private void ingresarMessage() {
		automator.find(campoMessage).setText("test message");
	}
	
	private void sendMessageClick() {
		automator.find(btnSend).click();
	}
	
	public void completarFormulario() {
		this.ingresarNombre();
		this.ingresarTelefono();
		this.ingresarEmail();
		this.ingresarMessage();
		this.sendMessageClick();
	}
}
