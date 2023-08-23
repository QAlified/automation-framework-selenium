package test.sample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import exceptions.MissingPropertyException;
import exceptions.NoSuchPropertyFileException;
import test.testBase_withoutXML;
import util.JSONHandler;

public class loginFallido extends testBase_withoutXML {
  
	//Test de login hardcodeado para que falle
	@Test
  public void testLoginFallido() throws MissingPropertyException, NoSuchPropertyFileException {
	  
	  this.automator.goTo(JSONHandler.getJSONContent("parameters.json", "URLCura"));
	  this.automator.find(By.cssSelector("error")).click();
  }
}

