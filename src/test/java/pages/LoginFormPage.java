package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginFormPage extends BasePage {

	public LoginFormPage(WebDriver controller) {
		super(controller);
	}

	public LoginFormPage typeUsername(String username) {
		controller.findElement(By.id("signinbox")).findElement(By.name("login")).sendKeys(username);
		return this;
	}
	
	public LoginFormPage typePassword(String password) {
		controller.findElement(By.id("signinbox")).findElement(By.name("password")).sendKeys(password);
		return this;
	}
	
	public SecretPage clickOnSignIn() {
		controller.findElement(By.linkText("Sign in")).click();
		return new SecretPage(controller);
	}
	
	public SecretPage doLogin(String username, String password) {
		typeUsername(username);
		typePassword(password);
		return clickOnSignIn();
	}
}
