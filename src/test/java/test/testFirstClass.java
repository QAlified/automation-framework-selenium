package test;
import org.testng.annotations.Test;

public class testFirstClass extends testBase{
	
	@Test
	public void FirstTest() {
		String TestUrl = "https://qalified.com/";
		automator.goTo(TestUrl);
		automator.back();
		automator.forward();
		automator.refresh();
		automator.closeBrowser();
	}

}
