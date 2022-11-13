package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecretPage {
	
	private WebDriver controller;
	
	public SecretPage(WebDriver controller) {
		this.controller = controller;
	}
	
	public MyPage clickMe() {
		controller.findElement(By.className("me")).click();
		return new MyPage(controller);
	}

}
