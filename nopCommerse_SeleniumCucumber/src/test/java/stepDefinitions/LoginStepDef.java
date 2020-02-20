package stepDefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LoginStepDef extends BaseClass {

	@Before
	public void setup() throws IOException {
		// WebDriver driver = null;
		// driver.manage().deleteAllCookies();

		logger = logger.getLogger("nopCommerse");
		PropertyConfigurator.configure("log4j.properties");
		configProp = new Properties();
		FileInputStream fileinputst = new FileInputStream("config.properties");
		configProp.load(fileinputst);

		String br = configProp.getProperty("Browser");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", configProp.getProperty("iepath"));
			driver = new InternetExplorerDriver();
		}
		
		loginPage = new LoginPage(driver);
	}

	@Given("open nopCommerse website")
	public void open_nopCommerse_website() {

		logger.info("********Launching URL********");
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("User is on login page");
	}

	@When("user enters {string} and {string}")
	public void user_enters_and(String username, String password) throws InterruptedException {

		Thread.sleep(2000);

		// WebElement uname = driver.findElement(By.id("Email"));
		// uname.sendKeys(string);

		// WebElement pass = driver.findElement(By.id("Password"));
		// pass.sendKeys(string2);
		logger.info("********Entering Username and Password*********" + username + password);
		loginPage.set_username(username);
		loginPage.set_password(password);

	}

	@When("user clicks on Login button")
	public void user_clicks_on_Login_button() {

		// WebElement button = driver.findElement(By.xpath("//input[@type='submit']"));
		// button.click();
		logger.info("******Clicking on Login Button******");
		loginPage.click_loginbutton();

	}

	@Then("login is successfull")
	public void login_is_successfull() {

		String actualtitle = driver.getTitle();
		System.out.println("Page Title is:" + actualtitle);
		String expectedtitle = "Dashboard / nopCommerce administration";
		logger.info("******Verifying title of the page********");
		if (actualtitle.equals(expectedtitle)) {
			System.out.println("User is logged in Successfully!");
		} else {
			System.out.println("User is not logged in");
		}
		logger.info("******Closing the browser******");
		driver.quit();
	}

}
