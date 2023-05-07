package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

	WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(linkText="Edit your account information")
	@FindBy(xpath="//a[contains(text(),'Edit your account information')]")
	WebElement editAccountInfo;
	
	public WebElement editAccountInfo() {
		return editAccountInfo;
	}
	
	
}
