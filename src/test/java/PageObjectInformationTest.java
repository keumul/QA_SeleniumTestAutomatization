import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

import pages.LoginPage;
import support.Web;

public class PageObjectInformationTest {
	
	private WebDriver controller = null;
	
	@Before
	public void setUp() {
		controller = Web.createWebDriver();
	}
	
	@Test
	public void testAddAdditionalUserInformation() {
		String userLoginPage = new LoginPage(controller)
			.clickSignIn()
			.doLogin("katemeow", "1111")
			.clickMe()
			.clickTabForMoreInformationAboutYou()
			.clickButtonToAddMoreInformationAboutYou()
			.addContact("PhoneNumber", "+123456789100")
			.capturingToastText();
		
		assertEquals("Your contact has been added!", userLoginPage);
	}
	
	@Test
	public void testDeleteAdditionalUserInformation() {
		new LoginPage(controller)
			.clickSignIn()
			.doLogin("katemeow", "1111")
			.clickMe();
	}

	@After
	public void tearDown() {
//		controller.quit();
	}
}
