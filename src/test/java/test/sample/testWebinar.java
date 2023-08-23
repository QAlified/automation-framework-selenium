package test.sample;

import org.testng.annotations.Test;

import exceptions.MissingPropertyException;
import pages.MainPage;
import pages.TestingAutomatizadoPage;
import test.testBase;

public class testWebinar extends testBase {
	MainPage mainPageQAlified;
	TestingAutomatizadoPage testAutPage;
	
	@Test
	public void test() throws Exception, MissingPropertyException {
		mp.loadProperties("parameters");
		this.getAutomator().goTo(mp.getProp("url_demo"));
		this.getAutomator().maximizeWindows();
		Thread.sleep(3000);
		
		mainPageQAlified = new MainPage(automator);
		mainPageQAlified.clickSaberMasTestAutomatizado();
		
		testAutPage = new TestingAutomatizadoPage(automator);
		testAutPage.clickBotonContactanos();
	}

}
