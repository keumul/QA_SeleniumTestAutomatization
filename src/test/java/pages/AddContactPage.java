package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddContactPage extends BasePage {

	public AddContactPage(WebDriver controller) {
		super(controller);
	}
	
	public AddContactPage typeContact(String type) {
		WebElement typeContact = controller.findElement(By.id("addmoreinfo")).findElement(By.name("type"));
		new Select(typeContact).selectByVisibleText((type));
		return this;
	}
	
	public AddContactPage typeNumber(String number) {
		controller.findElement(By.id("addmoreinfo")).findElement(By.name("contact")).sendKeys(number);
		return this;
	}
	
	public MyPage clickSave() {
		controller.findElement(By.id("addmoreinfo")).findElement(By.linkText("Save")).click();
		return new MyPage(controller);
	}
	
	public MyPage addContact(String type, String number) {
		typeContact(type);
		typeNumber(number);
		return clickSave();
	}

}
