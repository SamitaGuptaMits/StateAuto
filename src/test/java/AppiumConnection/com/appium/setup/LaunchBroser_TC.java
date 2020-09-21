package AppiumConnection.com.appium.setup;

import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class LaunchBroser_TC {

	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException {
		AppController.getInstance().openBrowser("MOBILE", false);// Open Browser

	}
	@Test(priority = 1, groups = "Login Page")
	private void LoginScreenCheckLogoTC() throws Exception {
		AppController.getInstance().Test1();
	}
	@AfterTest
	private void closeBrowser() throws Exception {
		//AppController.getInstance().executeEmailReport(); // Send Email
		AppController.getInstance().closeBrowser(); // Close Browser
	}
	
}
