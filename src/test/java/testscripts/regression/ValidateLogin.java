package testscripts.regression;

import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;

public class ValidateLogin extends BaseTest {
	
	@Test
	public void validateLoginTest()
	{
		ApplicationKeywords app=new ApplicationKeywords();
		
		app.openBrowser();
		
		app.navigate();
		
		app.takeScreenShot();
		
		app.type("usernameTextBox_id", "reyaz0617");
		
		app.type("passwordTextBox_name", "reyaz123");
		
		app.click("loginButton_xpath");
		
		app.takeScreenShot();
		
		app.validateTitle("Adactin.com - Search Hotel");
		
		app.quit();
		
	}

}
