package test.sample;

import org.testng.annotations.Test;

import exceptions.MissingPropertyException;
import pages.MainPage;
import pages.TestingAutomatizadoPage;
import test.TestBase;

public class TestWebinar extends TestBase {
	MainPage mainPageQAlified;
	TestingAutomatizadoPage testAutPage;
	
	@Test
	public void test() throws MissingPropertyException {
		this.getAutomator().goTo(mp.getProp("username"));
		this.getAutomator().maximizeWindows();
		
		mainPageQAlified = new MainPage(automator);
		mainPageQAlified.clickSaberMasTestAutomatizado();
		
		testAutPage = new TestingAutomatizadoPage(automator);
		testAutPage.clickBotonContactanos();
	}

}
