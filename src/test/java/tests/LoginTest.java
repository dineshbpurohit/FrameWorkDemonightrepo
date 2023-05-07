package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import resources.Base;


public class LoginTest extends Base{
	public WebDriver driver;
	Logger log;
	@BeforeMethod
	public void openApplication() throws IOException {
		 log = LogManager.getLogger(LoginTest.class.getName());

	    driver = initializeDriver();
	    log.debug("Browser get launched");
		driver.get(prop.getProperty("Url"));
		 log.debug("Navigated to Application URL");
	}
	
	@Test(dataProvider="getLoginData")
	public void login(String email,String password,String expected) throws IOException, InterruptedException {
		
		
		LandingPage landing = new LandingPage(driver);
		landing.myAccount().click();
		 log.debug("Clicked on My Account Dropdown");
		landing.loginOption().click();
		 log.debug("Clicked on Login Option");
		
		LoginPage loginPage = new LoginPage(driver);
		/*
		 * loginPage.emailAddress().sendKeys(prop.getProperty("email"));
		 * loginPage.password().sendKeys(prop.getProperty("pwd"));
		 */
		loginPage.emailAddress().sendKeys(email);
		log.debug("Entered Email address");
		loginPage.password().sendKeys(password);
		log.debug("Entered password");
		loginPage.loginBtn().click();
		log.debug("Clicked on Login Btn");
		
		MyAccountPage map = new MyAccountPage(driver);
		String actual=null;
		//Assert.assertTrue(map.editAccountInfo().isDisplayed());
	   Thread.sleep(3000);
		try {
		if(map.editAccountInfo().isDisplayed()) {
			actual="Success";
			log.debug("Login is Successful");
		}
		}catch(Exception e) {
			actual="Failure";
			log.debug("Login is Failed");
		}
		Assert.assertEquals(actual, expected);
		log.info("Login test got passed");
		}
	@AfterMethod
	public void tearDown() {
		driver.close();
		log.debug("Browser got closed");
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = {{"din@gmail.com","din123","Success"},{"din@yahoomail.com","din123","Failure"}};
		return data;
	}

}
