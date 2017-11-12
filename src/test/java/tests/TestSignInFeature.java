package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TestSignInFeature extends TestBase {

	@BeforeClass
	public void classSetUp() {

		menuBar.signInLink.click();
	}
	
	@AfterClass
	public void classTeardown(){
		
		menuBar.jobSearchLink.click();
	}

	@Test
	public void testSignInWithValidCredential() {

		signInPage.signIn("shakil_ipe@yahoo.com", "365827");

		// Assert.assertEquals(driver.getTitle(), "ipeans | EliteCareer");

		Assert.assertTrue(driver.getCurrentUrl().contains("elitecareer.net/profile"));

		menuBar.logoutLink.click();
		menuBar.signInLink.click();
	}
	
	@Test
	public void testSignInWithInvalidEmailAndValidPassword() {

		signInPage.signIn("InValidshakil_ipe@yahoo.com", "365827");

		Assert.assertTrue(driver.getCurrentUrl().contains("elitecareer.net/signin"));

		Assert.assertEquals(signInPage.getTargetWebElementText(signInPage.errorElementList, 0),
				"* Email or Password is incorrect.");
	}

	@Test
	public void testSignInWithValidEmailAndInvalidPassword() {

		signInPage.signIn("shakil_ipe@yahoo.com", "36582726");

		Assert.assertTrue(driver.getCurrentUrl().contains("elitecareer.net/signin"));

		Assert.assertEquals(signInPage.getTargetWebElementText(signInPage.errorElementList, 0),
				"* Email or Password is incorrect.");
	}
	
	@Test
	public void testSignInWithInvalidEmailAndInvalidPassword() {

		signInPage.signIn("Invalidshakil_ipe@yahoo.com", "36582726");

		Assert.assertTrue(driver.getCurrentUrl().contains("elitecareer.net/signin"));

		Assert.assertEquals(signInPage.getTargetWebElementText(signInPage.errorElementList, 0),
				"* Email or Password is incorrect.");
	}

}
