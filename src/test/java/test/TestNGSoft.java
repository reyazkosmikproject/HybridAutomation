package test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGSoft {
	SoftAssert softAssert;
	@BeforeTest
	public void beforeTEst()
	{
		softAssert = new SoftAssert();
	}
	
	@Test
	public void loginTest()
	{
		softAssert.assertEquals(false, true);
		System.out.println("In Login TEst");
	}
	
	@Test
	public void loginOutTest()
	{
		softAssert.assertEquals(true, true);
		System.out.println("In loginOutTest");
	}
	
	
	@Test
	public void registerTest()
	{
		softAssert.assertEquals(false, true);
		System.out.println("In registerTest");
	}
	
	@AfterTest
	public void afterTEst()
	{
		
		softAssert.assertAll();
	}

}
