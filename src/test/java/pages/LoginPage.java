package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver controller) {
		super(controller);
	}

	public LoginFormPage clickSignIn() {
		controller.findElement(By.linkText("Sign in")).click();
		
		return new LoginFormPage(controller);
	}

}
