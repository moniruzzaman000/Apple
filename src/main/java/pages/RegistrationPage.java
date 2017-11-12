package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.PageBase;

public class RegistrationPage extends PageBase {

	@FindBy(name = "PhoneNo")
	public WebElement phoneNoField;

	@FindBy(name = "DateOfBirth")
	public WebElement dateOfBirthField;

	@FindBy(name = "Gender")
	public WebElement genderDropdownElement;

	@FindBy(name = "LastName")
	public WebElement lastNameField;

	@FindBy(name = "FirstName")
	public WebElement firstNameField;

	@FindBy(id = "submit")
	public WebElement submitButton;

	@FindBy(id = "error")
	public List<WebElement> errorElementList;

	public void textFieldHelper(WebElement element, String value) {

		element.clear();

		element.sendKeys(value);

		submitButton.click();
		// submitButton.submit();
	}

}
