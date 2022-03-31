package test.sample;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import exceptions.MissingPropertyException;
import exceptions.NoSuchPropertyFileException;
import test.TestBase;

public class LoginFallido extends TestBase {
  @Test
  @Parameters({"testUrl"})
  public void testLoginFallido(String testUrl) throws MissingPropertyException, NoSuchPropertyFileException {
	  
	  this.automator.goTo(testUrl);
	  this.automator.find(By.cssSelector("error")).click();
  }
}

