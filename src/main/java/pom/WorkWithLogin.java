package pom;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;

import automation.UIElement;
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
	
    public void contactInformation(String name, String msg){  
        this.automator.waitUntilVisible(input_name); 
        logger.info("The person's name is entered - {}", name);
        this.automator.find(input_name).setText(name); 
        
        this.automator.waitUntilVisible(textArea_msg); 
        logger.info("The message is entered - {}", msg);		
		this.automator.find(textArea_msg).setText(msg);
    }
	
    
    //CURA Healthcare Service
    public void clickMakeAppointment(){
		this.automator.waitUntilClickable(buttonMakeAppoint);
		logger.info("Click on the MakeAppoint button");
		this.automator.find(buttonMakeAppoint).click();
	}
    
    public void clickLoginCURA(){
		this.automator.waitUntilClickable(buttonLogin);
		logger.info("Click on the Login button");
		this.automator.find(buttonLogin).click();
	}
    
    public void loginCURA(String username, String password){  
        this.automator.waitUntilVisible(inputUsername); 
        logger.info("The person's username is entered - {}", username);
        this.automator.find(inputUsername ).setText(username); 
        
        this.automator.waitUntilVisible(inputPassoword); 
        logger.info("The person's password is entered");		
		this.automator.find(inputPassoword).setText(password);
    }
    
    
	//Verify
	public void verifyEnteredName() {
		assertEquals(this.automator.find(input_name).getValue(), "James Bond", "The text entered does not match!");
	}
	
	public void verifyMessage() {
		assertTrue(this.automator.find(textArea_msg).isDisplayed(), "The 'Message' field is empty");
	}

}
