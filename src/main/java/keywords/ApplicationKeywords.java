package keywords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;

public class ApplicationKeywords extends ValidationKeywords {

	
	
	public SoftAssert softAssert;
	
	public ApplicationKeywords() 
	{
		
		
		try {
			FileInputStream fis1 = new FileInputStream("properties\\config.properties");
			configProp=new Properties();
			configProp.load(fis1);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			FileInputStream fis2 = new FileInputStream("properties\\locators.properties");
			locatorsProp=new Properties();
			locatorsProp.load(fis2);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		 softAssert=new SoftAssert();
		
		
		
		
	}
	
	public void setReport(ExtentTest test)
	{
		this.test=test;
	}
	
	
	
	
	
}
