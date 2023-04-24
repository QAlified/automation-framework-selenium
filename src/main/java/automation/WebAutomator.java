package automation;
import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browsers.Browser;
import config.Config;
import exceptions.NoValidBrowserException;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class WebAutomator {
	
	//WebDriver Wrapper
	private WebDriver driver;
	//WebDriver wait
	private WebDriverWait wait;
	
	//Logger
    private static final org.apache.logging.log4j.Logger logger=LogManager.getLogger(WebAutomator.class);
	
    @SuppressWarnings("deprecation")
	public WebAutomator(Browser browser,boolean isHeadless, boolean isIncognito, Duration max_wait) throws NoValidBrowserException {
		switch (browser) {
		case CHROME: {		
			ChromeOptions options = new ChromeOptions();
			if(isHeadless) {
				options.addArguments("--headless", "--window-size=1920,1200");
			}
			if(isIncognito) {
				options.addArguments("--incognito");
			}
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver(options);
			break;
		}
		case FIREFOX:{			
			DriverManagerType  firefox = DriverManagerType.FIREFOX;
			WebDriverManager.firefoxdriver().setup();		
			FirefoxDriver driver = new FirefoxDriver();
			break;
		}
			
		case EDGE:{
			DriverManagerType edge = DriverManagerType.EDGE;
			WebDriverManager.edgedriver().setup();	
			EdgeDriver driver = new EdgeDriver();
			break;
		}
			
		case IEXPLORER:{
			DriverManagerType iexplore = DriverManagerType.IEXPLORER;
			WebDriverManager.iedriver().setup();		
			InternetExplorerDriver driver = new InternetExplorerDriver();
			break;
		}
			
			
		default:
			throw new NoValidBrowserException(browser.toString());
			
		}
		wait = new WebDriverWait(driver, max_wait);
	}
	
	//Getters y Setters
	public WebDriver getDriver() {
		return this.driver;
	}
	
	//Browser API
	public void maximizeWindows() {
		this.driver.manage().window().maximize();
	}
	
	
	//Method that closes the browser and ends the active session of the WebDriver
	public void closeAll(){
		if(driver!=null)
		{
			logger.info("The active WebDriver closes");
			this.driver.quit();
		}
		else
		{
			logger.warn("No WebDriver is currently active to close");
		}
		
	}

	public void back() {
		this.driver.navigate().back();
	}
	
	public void forward() {
		this.driver.navigate().forward();
	}
	
	public void refresh() {
		this.driver.navigate().refresh();
	}
	
	public void goTo(String url) {
		this.driver.get(url);
	}
	
	public void closeBrowser() {
		this.driver.quit();
	}
	
	public void closeCurrentTab() {
		this.driver.close();
	}
	
	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}
	
	//Elements API
	public UIElement find(By by) {
		return this.waitUntilPresent(by);
	}
	
	public UIElement findChild(By parent, By child) {
		return this.wait(ExpectedConditions.presenceOfNestedElementLocatedBy(parent, child));
	}
		
	private UIElement waitUntilPresent(By by) {
		return this.wait(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	private UIElement wait(ExpectedCondition<WebElement> conditions) {
		return new UIElement(this, this.wait.until(conditions));
	}
	
	public UIElement waitUntilVisible(By by) {
		return this.wait(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public UIElement waitUntilClickable(By by) {
		return this.wait(ExpectedConditions.elementToBeClickable(by));
	}
	
	//Cookies API
	public void deleteAllCookies() {
		this.driver.manage().deleteAllCookies();
	}
	
	public Set<Cookie> getAllCookies() {
		return this.driver.manage().getCookies();
	}
	
	public Cookie getCookie(String cookie) {
		return this.driver.manage().getCookieNamed(cookie);
	}
	
	public void addCookie(Cookie cookie) {
		this.driver.manage().addCookie(cookie);
	}
	
	//TakeScreenshot
	public void takeScreenshot() {
		TakesScreenshot camera = (TakesScreenshot) this.driver;
		File file = camera.getScreenshotAs(OutputType.FILE);
		String path = String.format("%s%s-%s.png", Config.SCREENSHOT_PATH, "screenshot", System.currentTimeMillis());
		file.renameTo(new File(path));
	}	
	
	
}
