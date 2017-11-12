package base;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import pages.MenuBar;
import pages.RegistrationPage;
import pages.SignInPage;

@Listeners(listener.EliteListener.class)
public class TestBase extends SauceLabs {
	
	public static RegistrationPage registerPage;
	
	public static SignInPage signInPage;
	
	public static MenuBar menuBar;

	@BeforeSuite
	public void setup() {

		if (Boolean.valueOf(getProperty("saucelabs"))) {
			// to run test in saucelabs
			setSaucelabs();
		} else {
			// To run test in local machine
			setDriver();
		}

		setDriverProperties();
		
		registerPage = PageFactory.initElements(driver, RegistrationPage.class);
		
		signInPage = PageFactory.initElements(driver, SignInPage.class);
		
		menuBar = PageFactory.initElements(driver, MenuBar.class);
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
