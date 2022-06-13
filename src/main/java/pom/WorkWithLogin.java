package pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;

import automation.WebAutomator;

public class WorkWithLogin {
	
	//Locators	
	//QAlified
	private By link_contact = By.linkText("CONTACT");
	private By input_name = By.name("txtName");
	private By textArea_msg = By.name("txtMsg");

	//CURA Healthcare Service
	private By buttonLogin = By.id("btn-login");
	private By inputUsername = By.id("txt-username");
	private By inputPassoword = By.id("txt-password");
	private By buttonMakeAppoint = By.id("btn-make-appointment");
	private By titleMakeAppointment = By.xpath("//h2[contains(text(),'Make Appointment')]");
	
	
	//Logger
	private static final org.apache.logging.log4j.Logger logger=LogManager.getLogger(WorkWithLogin.class);
	
	//Driver
	private WebAutomator automator;
	
	public WorkWithLogin(WebAutomator a){
		this.automator = a;
	}
	
	
	//QAlified
	public void clickContact(){
		this.automator.waitUntilClickable(link_contact);
		this.automator.find(link_contact).click();
	}
	
	public void setName(String name){
		this.automator.waitUntilVisible(input_name); 
        logger.info("The person's name is entered - {}", name);
        this.automator.find(input_name).setText(name); 
		
	}
	
	public void setMessage(String message){
        this.automator.waitUntilVisible(textArea_msg); 
        logger.info("The message is entered - {}", message);		
		this.automator.find(textArea_msg).setText(message);
	}
	
    public void contactInformation(String name, String message){  
       this.setName(name);
       this.setMessage(message);
    }
    
    
    
    //CURA Healthcare Service
    public void clickMakeAppointment(){
		this.automator.waitUntilClickable(buttonMakeAppoint);
		logger.info("Click on the MakeAppoint button");
		this.automator.find(buttonMakeAppoint).click();
	}

    public void setUsername(String username) {
	  this.automator.waitUntilVisible(inputUsername); 
      logger.info("The person's username is entered - {}", username);
      this.automator.find(inputUsername ).setText(username); 	
    }
    
    public void setPassword(String password) {
    	this.automator.waitUntilVisible(inputPassoword); 
        logger.info("The person's password is entered");		
  		this.automator.find(inputPassoword).setText(password);   	
    }
    
    public void clickLogin(){
  		this.automator.waitUntilClickable(buttonLogin);
  		logger.info("Click on the Login button");
  		this.automator.find(buttonLogin).click();
  	}
    
    public void loginCURA(String username, String password){  
       this.setUsername(username);
       this.setPassword(password);
    }
    
    
	//Verify
	public void verifyEnteredName() {
		assertEquals(this.automator.find(input_name).getValue(), "James Bond", "The text entered does not match!");
	}
	
	public void verifyMessage() {
		assertTrue(this.automator.find(textArea_msg).isDisplayed(), "The 'Message' field is empty");
	}

	public void verifyLogin() {
		assertTrue(this.automator.find(titleMakeAppointment).isDisplayed(), "Sign in not successful");
	}
}
