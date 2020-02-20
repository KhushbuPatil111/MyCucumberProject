package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(id="Email")
	WebElement Username;
	
	@FindBy(id="Password")
	WebElement Password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement LoginButton;
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}	
	
	public void set_username(String uname)
	{
		Username.sendKeys(uname);
	}
	
	public void set_password(String pass)
	{
		Password.sendKeys(pass);
	}
	
	public void click_loginbutton()
	{
		LoginButton.click();
	}
	
	
}
