package testscripts.regression;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;
import util.UtilKit;

public class ValidateLoginDataProvider extends BaseTest {
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		return UtilKit.getData("TC101", "Sheet1");
				
	}
	@Test(dataProvider="getData")
	public void validateLoginTest(String un,String pwd,String expTitle)
	{
		ApplicationKeywords app=new ApplicationKeywords();
		
		app.openBrowser();
		
		app.navigate();
		
		app.takeScreenShot();
		
		app.type("usernameTextBox_id", un);
		
		app.type("passwordTextBox_name", pwd);
		
		app.click("loginButton_xpath");
		
		app.takeScreenShot();
		
		app.validateTitle(expTitle);
		
		app.quit();
		
	}

}
