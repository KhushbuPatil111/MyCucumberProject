package stepDefinitions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
	
public class LoginStepDef extends BaseClass {
	
	public WebDriver driver;
	
	@Given("open nopCommerse website")
	public void open_nopCommerse_website() {
		
		System.setProperty("webdriver.chrome.driver",
							"D:\\Eclipse workspace\\Driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		lp = new LoginPage(driver);
		
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("User is on login page");
	}

	@When("user enters {string} and {string}")
	public void user_enters_and(String string, String string2) throws InterruptedException {
		Thread.sleep(2000);
		
		//WebElement uname = driver.findElement(By.id("Email"));
		//uname.sendKeys(string);
		
		//WebElement pass = driver.findElement(By.id("Password"));
		//pass.sendKeys(string2);
		
		lp.set_username(string);
		lp.set_password(string2);
			    
	}

	@When("user clicks on Login button")
	public void user_clicks_on_Login_button() {
		
		//WebElement button = driver.findElement(By.xpath("//input[@type='submit']"));
		//button.click();
		lp.click_loginbutton();
	   
	}

	@Then("login is successfull")
	public void login_is_successfull() {
		
		String actualtitle = driver.getTitle();
		System.out.println("Page Title is:"+ actualtitle);
		String expectedtitle = "Dashboard / nopCommerce administration";
		
		if(actualtitle.equals(expectedtitle))
		{
			System.out.println("User is logged in Successfully!");
		}
		else
		{
			System.out.println("User is not logged in");
		}
	   driver.quit();
	}
	


}
