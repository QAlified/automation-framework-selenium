package util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import automation.WebAutomator;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class ScreenshotAndCompare {
	
	public void takeScreenshotAndCompare(String name, WebAutomator automator, SoftAssert softAssert) throws IOException, InterruptedException{
		WebDriver driverScr = automator.getDriver();
		File dir = new File("./screenshots/");
		File screenshotFileGet = new File("./screenshots/"+name+".png");
		if(!dir.exists()) dir.mkdirs();
		if(!screenshotFileGet.exists()) {
			Thread.sleep(2000);
		    Screenshot screenshot = new AShot().takeScreenshot(driverScr);
		    ImageIO.write(screenshot.getImage(),"PNG",new File("./screenshots/"+name+".png"));
		    Thread.sleep(2000);
		    softAssert.fail("Archivo "+name+".png"+" inexistente. Ejecuta el test nuevamente");
		    
		}else {
			Thread.sleep(2000);
		    Screenshot screenshot = new AShot().takeScreenshot(driverScr);
		    ImageIO.write(screenshot.getImage(),"PNG",new File("./screenshots/"+name+"Comparison.png"));
		    BufferedImage actualImage = screenshot.getImage();
		    BufferedImage expectedImage = ImageIO.read(screenshotFileGet);
		    Thread.sleep(2000);
	        ImageDiffer imgDiff = new ImageDiffer();
	        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		    try {
			    Assert.assertFalse(diff.hasDiff(),"Comparación de imagen"+name+".png");
		    }catch(AssertionError e) {
		    	ImageIO.write(diff.getMarkedImage(),"PNG",new File("./screenshots/"+name+"Diff.png"));
		    	softAssert.fail("La imagen "+name+".png"+" es distinta a la capturada actualmente");
		    	
		    }

		}

		
	}
	
	public void sparkTakeScreenshotAndCompare(String name, WebAutomator automator, SoftAssert softAssert, ExtentTest test) throws IOException, InterruptedException{
		WebDriver driverScr = automator.getDriver();
		File dir = new File("./screenshots/");
		File screenshotFileGet = new File("./screenshots/"+name+".png");
		if(!dir.exists()) dir.mkdirs();
		if(!screenshotFileGet.exists()) {
			Thread.sleep(1000);
		    Screenshot screenshot = new AShot().takeScreenshot(driverScr);
		    ImageIO.write(screenshot.getImage(),"PNG",new File("./screenshots/"+name+".png"));
		    Thread.sleep(1000);
		    test.log(Status.FAIL, "Archivo "+name+".png"+" inexistente. Ejecuta el test nuevamente")
		    .fail("Nueva captura de pantalla creada:")
		    .fail(MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"/screenshots/"+name+".png").build());		    
	    	softAssert.fail("Archivo "+name+".png"+" inexistente. Ejecuta el test nuevamente");
		}else {
			Thread.sleep(1000);
		    Screenshot screenshot = new AShot().takeScreenshot(driverScr);
		    ImageIO.write(screenshot.getImage(),"PNG",new File("./screenshots/"+name+"Comparison.png"));
		    BufferedImage actualImage = screenshot.getImage();
		    BufferedImage expectedImage = ImageIO.read(screenshotFileGet);
		    Thread.sleep(1000);
	        ImageDiffer imgDiff = new ImageDiffer();
	        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);
		    try {
			    Assert.assertFalse(diff.hasDiff(),"Comparación de imagen"+name+".png");
			    test.log(Status.PASS,
			    		"Imagen "+name+".png coincide con la captura de pantalla"
			    		).pass(MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"/screenshots/"+name+".png").build());
		    }catch(AssertionError e) {
		    	ImageIO.write(diff.getMarkedImage(),"PNG",new File("./screenshots/"+name+"Diff.png"));
			    test.log(Status.FAIL, 
			    		"La imagen "+name+".png"+" es distinta a la capturada actualmente"
			    ).fail("Imagen esperada:")
			    .fail(MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"/screenshots/"+name+".png").build())
			    .fail("Imagen obtenida:")
			    .fail(MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"/screenshots/"+name+"Comparison.png").build())
			    .fail("Diferencia:")
			    .fail(MediaEntityBuilder.createScreenCaptureFromPath(System.getProperty("user.dir")+"/screenshots/"+name+"Diff.png").build());	
		    	softAssert.fail("La imagen "+name+".png"+" es distinta a la capturada actualmente");

		    }

		}

		
	}
}
