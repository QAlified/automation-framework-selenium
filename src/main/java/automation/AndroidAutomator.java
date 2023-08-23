package automation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import util.JSONHandler;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.junit.Test;

public class AndroidAutomator {
	protected AndroidDriver androidDriver;
	@Test
	
	public AndroidDriver driverAndroid() throws MalformedURLException {
		//Parámetros JSON utilizados
		String localAddress = JSONHandler.getJSONContent("androidParameters.json","localAddress");
		String deviceName = JSONHandler.getJSONContent("androidParameters.json","deviceName");
		String fileName = JSONHandler.getJSONContent("androidParameters.json","fileName");
		
		
		//Obtención de la aplicación a utilizar
		String pathApk = new File("app/"+fileName).getAbsolutePath();
		
		//Configuración del driver
		URL urlLocalAddress = new URL(localAddress);
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(deviceName);
		options.setApp(pathApk);
		
		androidDriver = new AndroidDriver(urlLocalAddress,options);
		androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return androidDriver;
		
	}
	
	public void OpenApp() {
		
	}

}
