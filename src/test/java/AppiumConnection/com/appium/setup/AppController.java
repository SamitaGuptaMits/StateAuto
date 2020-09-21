package AppiumConnection.com.appium.setup;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class AppController {

	private static AppController ourInstance = null;
	WebDriver driver;

	static AppController getInstance() {
		if (ourInstance == null)
			ourInstance = new AppController();
		return ourInstance;
	}

	private AppController() {

	}

	/**
	 * Open Browser
	 * 
	 * @throws MalformedURLException
	 * @throws InterruptedException
	 */
	void openBrowser(String browserType, boolean isHeadLessReq) throws MalformedURLException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		if (browserType.equals("MOBILE")) {
			Map<String, Object> deviceMetrics = new HashMap<>();
			deviceMetrics.put("width", 510);
			deviceMetrics.put("height", 640);
			deviceMetrics.put("pixelRatio", 3.0);

			Map<String, Object> mobileEmulation = new HashMap<>();
			mobileEmulation.put("deviceMetrics", deviceMetrics);
			mobileEmulation.put("userAgent",
					"Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");

			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			driver = new ChromeDriver(chromeOptions);

		} else {

			Map<String, String> mobileEmulation = new HashMap<>();
			mobileEmulation.put("deviceName", "Galaxy S5");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			chromeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			chromeOptions.merge(chromeOptions);
			driver = new ChromeDriver(chromeOptions);
		}

		Dimension dm = new Dimension(360, 800);
		driver.manage().window().setSize(dm);
		driver.get("https://www.stateauto.com/");

	}

	public void Test1() throws InterruptedException {
		// TODO Auto-generated method stub
		// Thread.sleep(10000);

		try {

			
			MenuClick();
			
			WebElement weClaims = driver.findElement(By.xpath("//*[@href='/Insurance/']"));
			weClaims.click();
			
			MenuClick();

			weClaims = driver.findElement(By.xpath("//*[@href='/FindAnAgent/']"));
			weClaims.click();
			
			MenuClick();
			
			weClaims = driver.findElement(By.xpath("//*[@href='/Claims/']"));
			weClaims.click();
			
			Thread.sleep(5000);
			PageFactory.initElements(driver, this);

			WebElement weCookies = driver.findElement(By.xpath("//*[@value='ACCEPT']"));
			weCookies.click();

			Thread.sleep(5000);
			PageFactory.initElements(driver, this);

			WebElement weScrole = driver.findElement(By.xpath("//*[@href='tel:8885044527']"));
			Actions actions = new Actions(driver);
			actions.moveToElement(weScrole).perform();
			Thread.sleep(2000);
			PageFactory.initElements(driver, this);

			WebElement weDropdown = driver.findElement(By.xpath("(//*[@class='dropdown-toggle'])[2]"));

			weDropdown.click();
			Thread.sleep(3000);
			PageFactory.initElements(driver, this);

			WebElement weDropdownVAlue = driver.findElement(By.xpath("//*[@claimtype='Homeowners']"));
			weDropdownVAlue.click();

			Thread.sleep(1000);

			WebElement weGo = driver.findElement(By.xpath("(//*[@class='btn primary-button go-button'])[1]"));
			weGo.click();

			Thread.sleep(2000);

			WebElement weName = driver.findElement(By.xpath("//*[@name='firstName']"));
			weName.sendKeys("Thanks for watching...!");

			Thread.sleep(5000);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void MenuClick() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(5000);
		PageFactory.initElements(driver, this);
		WebElement weManu = driver.findElement(By.xpath("//*[@class='fa fa-bars']"));
		weManu.click();
		Thread.sleep(5000);
		PageFactory.initElements(driver, this);

	}

	public void closeBrowser() {
		// TODO Auto-generated method stub
		driver.quit();
	}
}