package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
	
	protected WebDriver controller;
	
	public BasePage(WebDriver controller) {
		this.controller = controller;
	}

	public String capturingToastText() {
		return controller.findElement(By.id("toast-container")).getText();
	}
}
