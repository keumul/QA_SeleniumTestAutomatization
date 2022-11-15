package support;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {
	
	public static WebDriver createWebDriver() {
		System.setProperty("webdriver.chrome.driver", "D:/WebDriver/chromedriver.exe");
		WebDriver controller = new ChromeDriver();
		controller.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		controller.get("http://www.juliodelima.com.br/taskit");
		
		return controller;
	}

}
