package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.TestBase;

public class TestRegisterFeature extends TestBase {

	@BeforeClass
	public void classSetUp() {

		menuBar.registerLink.click();
	}

	@AfterClass
	public void classTeardown() {

		menuBar.jobSearchLink.click();
	}

	// --------Test for FirstName Field-----------

	@Test
	public void testFirstNameFieldWithTwoChar() {

		registerPage.textFieldHelper(registerPage.firstNameField, "MD");

		String actualError = registerPage.getTargetWebElementText(registerPage.errorElementList, 0);

		Assert.assertEquals(actualError, "*");

	}

	@Test
	public void testFirstNameFieldWithThirtyChar() {

		registerPage.textFieldHelper(registerPage.firstNameField, "abcdefghijklmnopqrstuvwxyzasdf");

		String actualError = registerPage.getTargetWebElementText(registerPage.errorElementList, 0);

		Assert.assertEquals(actualError, "*");

	}

	@Test
	public void testFirstNameFieldWithCombinationOfStringAndInteger() {

		registerPage.textFieldHelper(registerPage.firstNameField, "Adward2");

		String actualError = registerPage.getTargetWebElementText(registerPage.errorElementList, 0);

		Assert.assertEquals(actualError, "*");

	}

	@Test
	public void testFirstNameFieldWithOneChar() {

		registerPage.textFieldHelper(registerPage.firstNameField, "A");

		Assert.assertEquals(registerPage.getTargetWebElementText(registerPage.errorElementList, 0),
				"* FirstName can not be less than 2 character.");

	}

	@Test
	public void testFirstNameFieldWithThirtyOneChar() {

		registerPage.textFieldHelper(registerPage.firstNameField, "Ahgfdertyuiolkjhgfdsaqwertyuikj");

		Assert.assertEquals(registerPage.getTargetWebElementText(registerPage.errorElementList, 0),
				"* FirstName can not be greater than 30 character.");

	}

	// ------Test For LastName Field---------

	@Test
	public void testLastNameFieldWithTwoChar() {

		registerPage.textFieldHelper(registerPage.lastNameField, "AM");

	}

	@Test
	public void testLastNameFieldWithThirtyChar() {

		registerPage.textFieldHelper(registerPage.lastNameField, "zxzxzxzxzxzxzxzxsxsxdcfvgbhnmj");

	}

	@Test
	public void testLastNameFieldWithCombinationOfStringAndInteger() {

		registerPage.textFieldHelper(registerPage.lastNameField, "Trump 2");

	}

	@Test
	public void testLastNameFieldWithOneChar() {

		registerPage.textFieldHelper(registerPage.lastNameField, "D");

		Assert.assertEquals(registerPage.getTargetWebElementText(registerPage.errorElementList, 1),
				"* LastName can not be less than 2 character.");

	}

	@Test
	public void testLastNameFieldWithThirtyOneChar() {

		registerPage.textFieldHelper(registerPage.lastNameField, "frfrfrfrfrfrfrfrfrfrftftgyhgvcs");

		Assert.assertEquals(registerPage.getTargetWebElementText(registerPage.errorElementList, 1),
				"* LastName can not be greater than 30 character.");

	}

	// -----------Date Of Birth Test -------------

	@Test
	public void testDateOFBirthFieldWithValidDateOfBirth() {

		registerPage.textFieldHelper(registerPage.dateOfBirthField, "2007-06-27");

		Assert.assertEquals(registerPage.getTargetWebElementText(registerPage.errorElementList, 3), "*");
	}

	@Test
	public void testDateOFBirthFieldWithInValidDateOfBirth() {

		registerPage.textFieldHelper(registerPage.dateOfBirthField, "20-06-2017");

		Assert.assertEquals(registerPage.getTargetWebElementText(registerPage.errorElementList, 3),
				"* Invalid DateOfBirth");
	}

	@Test
	public void testDateOFBirthFieldWithEmpty() {

		registerPage.textFieldHelper(registerPage.dateOfBirthField, "");

		Assert.assertEquals(registerPage.getTargetWebElementText(registerPage.errorElementList, 3),
				"* DateOfBirth can not be empty.");
	}

	// -------------- Phone Number Field Test -----------------

	@Test
	public void testPhoneNoFieldWithValidNumber() {

		registerPage.textFieldHelper(registerPage.phoneNoField, "3475538390");

		Assert.assertEquals(registerPage.getTargetWebElementText(registerPage.errorElementList, 4), "*");
	}

	@Test
	public void testPhoneNoFieldWithEmpty() {

		registerPage.textFieldHelper(registerPage.phoneNoField, "");

		Assert.assertEquals(registerPage.getTargetWebElementText(registerPage.errorElementList, 4),
				"* PhoneNo can not be empty.");
	}

	@Test
	public void testPhoneNoFieldWithInvalidNumber() {

		registerPage.textFieldHelper(registerPage.phoneNoField, "347553839035885");

		Assert.assertEquals(registerPage.getTargetWebElementText(registerPage.errorElementList, 4), "*");
	}

	//@Test(dependsOnMethods = {"testGenderDropdownWithOutSelectOption"},alwaysRun = true)
	
	@Test(priority = 1)
	public void testGenderDropdownWithRandomOption() {

		registerPage.randomlySelectFromDropdownList(registerPage.genderDropdownElement);
		registerPage.submitButton.click();

		Assert.assertEquals(registerPage.getTargetWebElementText(registerPage.errorElementList, 2), "*");
	}

	@Test
	public void testGenderDropdownWithOutSelectOption() {
		
		registerPage.submitButton.click();

		Assert.assertEquals(registerPage.getTargetWebElementText(registerPage.errorElementList, 2),
				"* Gender can not be empty.");
	}
}
