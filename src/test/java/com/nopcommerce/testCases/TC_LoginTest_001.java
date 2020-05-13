package com.nopcommerce.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.nopcommerce.pageObjects.LoginPage; //Loginpage imported from page objects class so that we can use login page here
import com.nopcommerce.testBase.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() throws IOException	{
		
	logger.info("**************** Starting TC_LoginTest_01 ************* ");
	
	driver.get(configPropObj.getProperty("baseURL"));
	
	
	logger.info("**************** Providing login details ************* ");
	LoginPage lp = new LoginPage(driver); // invoke the constructor from page object class and driver will be initiated
										
	lp.setUserName(configPropObj.getProperty("useremail"));
	lp.setPassword(configPropObj.getProperty("password"));
	lp.clickLogin();
	
	logger.info("**************** Validating Login ************* ");
		String exp_title="Dashboard / nopCommerce administration";
		String act_title=driver.getTitle();
		
		if(exp_title.equals(act_title))	{
			logger.info("**************** LoginTest is successful ************* ");
			Assert.assertTrue(true);
			}
		else
			{
			logger.error("**************** LoginTest is un-successfull********");
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			
			}	

		logger.info("**************** Finished TC_LoginTest_001 ************* ");
	}
}
	

