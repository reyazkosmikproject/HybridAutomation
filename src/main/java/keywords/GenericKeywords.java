package keywords;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericKeywords {

	public WebDriver driver;

	public Properties configProp;

	public Properties locatorsProp;

	public static ExtentTest test;

	public void openBrowser() {

		String browserName = configProp.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();

		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Long.parseLong(configProp.getProperty("implicitWait"))));

	}

	// Central method to get element
	// element presence in dom
	// visibilty

	public WebElement getElement(String locatorKey) {

		

		// check presence of element

		// check visibilty of element

		//check the presence
		
        if(!isElementPresent(locatorKey))
        {
      	  //report failure
      	  
      	  System.out.println("Element is not present "+locatorKey);
        }
      //check the visibility
        
        if(!isElementVisible(locatorKey))
        {
      	  //report failure
      	  
      	  System.out.println("Element is not visible "+locatorKey);
        }
		
	    WebElement element=driver.findElement(getLocator(locatorKey));


		return element;
		
	}

	// to check presence of Element in DOM

	public boolean isElementPresent(String locatorKey) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));

			return true;

		} catch (Exception e) {
			return false;
		}

	}

	// to check visibility of Element

	public boolean isElementVisible(String locatorKey) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorKey)));

			return true;

		} catch (Exception e) {
			return false;
		}

	}

	// to retrive By class object

	public By getLocator(String locatorKey) {

		By by = null;

		if (locatorKey.endsWith("_id")) {
			by = By.id(locatorsProp.getProperty(locatorKey));
		} else if (locatorKey.endsWith("_name")) {
			by = By.name(locatorsProp.getProperty(locatorKey));
		} else if (locatorKey.endsWith("_xpath")) {
			by = By.xpath(locatorsProp.getProperty(locatorKey));
		} else if (locatorKey.endsWith("_css")) {
			by = By.cssSelector(locatorsProp.getProperty(locatorKey));
		}

		return by;

	}

	public void click(String locatorKey) {

		getElement(locatorKey).click();

	}

	public void clickEnterButton() {

		Actions action = new Actions(driver);

		action.sendKeys(Keys.ENTER);
	}

	public void clear(String locatorKey) {

		getElement(locatorKey).clear();
	}

	public void navigate() {

		driver.get(configProp.getProperty("url"));

	}

	public String getText(String locatorKey) {
		return getElement(locatorKey).getText();
	}

	public void quit() {
		driver.quit();
	}

	public void type(String locatorKey, String text) {

		log("Entering the text "+text+ "into textbox "+locatorKey);
		getElement(locatorKey).sendKeys(text);
		log("Entered the text "+text+ "into textbox "+locatorKey);
	}

	public void selectByVisibleText(String locatorKey, String text)
	{
		
		new Select(getElement(locatorKey)).selectByVisibleText(text);
		
	}
	
	public String getTitle()
	{
		return driver.getTitle();
		
	}
	
	
	public void wait(int time)
	{
		
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void waitForPageToLoad()
	{
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		int i=0;
		
		while(i<10)
		{
		String status=(String) js.executeScript("return document.readyState");
		
		if(status.equals("complete"))
		{
			break;
		}
		
		wait(2);
		
		}
		
	}
	
	
	public void takeScreenShot()
	{
		
		
		System.out.println(System.getProperty("user.dir"));
		
		String screenshotDirPath=System.getProperty("user.dir")+"\\screenshots";
		   File screenshotDir= new File(screenshotDirPath);
		   screenshotDir.mkdir();
		
		
		Date d=new Date();
		
		System.out.println(d.toString().replace(":", "-"));
		
		String date=d.toString().replace(":", "-");
		
		File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File(screenshotDirPath+"\\"+date+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(screenshotDirPath+"\\"+date+".png");
		
	}
	
	
	public void log(String message)
	{
		test.log(Status.INFO, message);
	}
	
	
	
	
	
	
	
	
	
	
	
}
