package util;


import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebElement;

import automation.UIElement;
import automation.WebAutomator;
import config.Config;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;


public class Camera {
	
	WebAutomator automator;
	
	public Camera(WebAutomator automator) {
		this.automator = automator;
	}
	
	public void captureAllPage() {
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(automator.getDriver());             
		try {                 
			ImageIO.write(screenshot.getImage(), "PNG", new File(Config.SCREENSHOT_PATH + "img_" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {                 
			e.printStackTrace();   
		}                                   
	}
	
	public void captureElement(UIElement element) throws IOException, InterruptedException {
		Thread.sleep(2000);
		WebElement ele = element.getWebElement();
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(automator.getDriver(), ele);
		Thread.sleep(2000);
		ImageIO.write(screenshot.getImage(),"PNG",new File(Config.SCREENSHOT_PATH + "img_" + System.currentTimeMillis() + ".png"));
	}
	
	
			

}
