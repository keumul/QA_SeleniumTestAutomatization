import static org.junit.Assert.assertEquals;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.Web;

import java.time.Duration;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "InsertNewInformationTest.csv")
public class InsertNewInformationTest {

	private WebDriver controller = null;
	
	@Rule
	public TestName test = new TestName();

	@Before
	public void setUp() {
		controller = Web.createWebDriver();

		WebElement formSignInBox = controller.findElement(By.id("signinbox"));

		formSignInBox.findElement(By.name("login")).sendKeys("katemeow");

		formSignInBox.findElement(By.name("password")).sendKeys("1111");

		formSignInBox.findElement(By.linkText("Sign in")).click();

		formSignInBox.findElement(By.className("me")).click();

		formSignInBox.findElement(By.linkText("More information")).click();
	}

	@Test
	public void InsertNewInformationTest(@Param(name = "type") String type,
										 @Param(name = "contact") String contact,
										 @Param(name = "message") String message) {
		controller.findElement(By.xpath("//button[@data-target=\"addmoreinfo\"]")).click();

		WebElement formAddMoreData = controller.findElement(By.id("addmoreinfo"));

		WebElement typeField = formAddMoreData.findElement(By.name("type"));
		new Select(typeField).selectByVisibleText((type));

		formAddMoreData.findElement(By.name("contact")).sendKeys(contact);

		formAddMoreData.findElement(By.linkText("Save")).click();

		WebElement msgContainer = controller.findElement(By.id("toast-container"));
		String msg = msgContainer.getText();
		assertEquals(message, msg);

	}

//	@Test
	public void DeleteContactFromUser() {
		controller.findElement(By.xpath("//span[text()=\"+123456789100\"]/following-sibling::a")).click();
		controller.switchTo().alert().accept();

		WebElement msgContainer = controller.findElement(By.id("toast-container"));
		String msg = msgContainer.getText();
		assertEquals("AHAHAAHA, phone number is dead!", msg);

		WebDriverWait wait = new WebDriverWait(controller, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.stalenessOf(msgContainer));

		controller.findElement(By.linkText("Logout")).click();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown() command");
		controller.quit();
	}
}
