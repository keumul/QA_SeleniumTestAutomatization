package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyPage extends BasePage {
	
	
	public MyPage(WebDriver controller) {
		super(controller);
	}
	
	public MyPage clickTabForMoreInformationAboutYou() {
		controller.findElement(By.linkText("More information")).click();
		return this;
	}
	
	public AddContactPage clickButtonToAddMoreInformationAboutYou() {
		controller.findElement(By.xpath("//button[@data-target=\"addmoreinfo\"]")).click();
		return new AddContactPage(controller);
	}
}
