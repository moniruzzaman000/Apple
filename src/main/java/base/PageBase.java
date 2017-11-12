package base;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageBase extends Driver {

	public String getTargetWebElementText(List<WebElement> elementList, int index) {
		String text = null;

		text = elementList.get(index).getText();

		return text;
	}

	public String randomlySelectFromDropdownList(WebElement dropdownElement) {
		String selectedOption = null;
		Select select = new Select(dropdownElement);

		int minIndex = 1;
		int maxIndex = select.getOptions().size() - 1;
		int index = getRandomNumber(minIndex, maxIndex);
		select.selectByIndex(index);

		selectedOption = select.getFirstSelectedOption().getText();
		return selectedOption;
	}
	
	public void deselectDropdownOption(WebElement dropdownElement){
		Select select = new Select(dropdownElement);
		select.deselectAll();
		
	}
	
	public void pageRefresh(){
		driver.navigate().refresh();
	}
	
	

	public int getRandomNumber(int min, int max) {
		int randomNumber = 0;
		Random random = new Random();
		randomNumber = random.nextInt(max + 1 - min) + min;
		return randomNumber;
	}

}
