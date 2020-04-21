package test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import junit.framework.Assert;




public class inValidUserNotAbleToAddContact {
	@Test
	public void userShouldBeAbleToAddcontact() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		// set certain properties
		// driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// 2. GO TO THE TECHFIOS SITE
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		// 3. Type user name and password and submit

		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[contains(text(),'Sign')]")).click();

		// Library an Element
		By PAGE_TITLE_LOCATOR = By.xpath("//h2[contains(text(),'Dashboard')]");
		// WebElement PAGE_TITLE_ELEMENT= driver.findElement(PAGE_TITLE_LOCATOR);
		

		By CRM_SIDE_NAV_LOCATOR = By.xpath("//ul[@id ='side-menu']/descendant::span[text()='CRM']");
		By ADD_CONTACT_SIDE_NAV_LOCATOR = By
				.xpath("//span[text() ='CRM']/parent::*/following-sibling::ul/descendant::a[contains(@href,'add')]");

		By FULL_NAME_INPUT_FIELD_LOCATOR = By.id("account");
		By COMPANY_NAME_INPUT_FIELD_LOCATOR = By.id("company");
		By EMAIL_INPUT_FIELD_LOCATOR = By.id("email");
		By PHONE_INPUT_FIELD_LOCATOR = By.id("phone");
		By ADDRESS_INPUT_FIELD_LOCATOR = By.id("address");
		By CITY_INPUT_FIELD_LOCATOR = By.id("city");
		By STATE_INPUT_FIELD_LOCATOR = By.id("state");
		By ZIP_INPUT_FIELD_LOCATOR = By.id("zip");
		By SUBMIT_BUTTON_LOCATOR = By.id("submit");
		By LIST_CONTACT_SIDE_NAV_LOCATOR = By.linkText("List Contacts");
		By NEWLY_ADDED_DISPLAYED_CONTACT_LOCATOR = By.xpath("//table/tbody/descendant::tr[1]/td[2]/a");

		// how do create random class?

		Random rnd = new Random();
		int randomNumber = rnd.nextInt(999);

		String fullName = "Deepika" + randomNumber;
		String companyName = "Techfios" + randomNumber;
		String email = "techfios" + randomNumber + "@gmail.com";
		String phone = "123456" + randomNumber;
		String address = randomNumber + "Street";
		String city = "Irving" + randomNumber;
		String state = "TX";
		String zip = "75062";

		// Explicit wait given to the driver
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PAGE_TITLE_LOCATOR));

		// 4. Open CRM
		driver.findElement(CRM_SIDE_NAV_LOCATOR).click();

		waitForElement(driver, 10, ADD_CONTACT_SIDE_NAV_LOCATOR);

		// 5. click on Add contact,

		driver.findElement(ADD_CONTACT_SIDE_NAV_LOCATOR).click();

		Thread.sleep(3000);
		// 6.Fill out the form and submit,
		waitForElement(driver, 60, FULL_NAME_INPUT_FIELD_LOCATOR);

		driver.findElement(FULL_NAME_INPUT_FIELD_LOCATOR).sendKeys(fullName);
		driver.findElement(COMPANY_NAME_INPUT_FIELD_LOCATOR).sendKeys(companyName);
		driver.findElement(EMAIL_INPUT_FIELD_LOCATOR).sendKeys(email);
		driver.findElement(PHONE_INPUT_FIELD_LOCATOR).sendKeys(phone);
		driver.findElement(ADDRESS_INPUT_FIELD_LOCATOR).sendKeys(address);
		driver.findElement(CITY_INPUT_FIELD_LOCATOR).sendKeys(city);
		driver.findElement(STATE_INPUT_FIELD_LOCATOR).sendKeys(state);
		driver.findElement(ZIP_INPUT_FIELD_LOCATOR).sendKeys(zip);
		driver.findElement(SUBMIT_BUTTON_LOCATOR).click();

		/*
		 * // 7. Click on List Contact
		 * 
		 * driver.findElement(LIST_CONTACT_SIDE_NAV_LOCATOR).click(); // 8 Verify that
		 * Contact added. String dispalyedContactName =
		 * driver.findElement(NEWLY_ADDED_DISPLAYED_CONTACT_LOCATOR).getText();
		 * 
		 * // Print to see // System.out.println("Expected Name"+fullName); //
		 * System.out.println("Actual name"+dispalyedContactName);
		 * Assert.assertEquals("Revelent contact name not found!", fullName,
		 * dispalyedContactName);
		 * 
		 * // to stop and observe, but do not use unless you have to Thread.sleep(3000);
		 */

		// Close the browser
		driver.close();
		// Ends the webdriver session
		driver.quit();
	}

	public void waitForElement(WebDriver driver, int timeInSeconds, By locator) {

		WebDriverWait wait = new WebDriverWait(driver,timeInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
