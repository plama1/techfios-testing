package test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Addcontact extends BasePage{
	WebDriver driver;
	
	@BeforeMethod
	
	public void startBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=admin/");
	}
		
	@Test(priority = 1)	
	
	public void validuserShouldBeAbleToAddcontact() throws InterruptedException {
	
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[contains(text(),'Sign')]")).click();
		//waitForElement(driver,10,By.xpath("//h2[contains(text(),'Dashboard']"));
		
	}
	
	@Test(priority = 2)
	
	public void invaliduserShouldNotAbleToAddcontact() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("bc123");
		driver.findElement(By.xpath("//button[contains(text(),'Sign')]")).click();
		By ALERT_MSG_LOCATOR = By.xpath("//div[@class='alert alert-danger fade in']");
		waitForElement(driver,10, ALERT_MSG_LOCATOR);
	}
	
	@AfterMethod
	public void close() {
			driver.close();
			driver.quit();
	}
	
	
	
	

}
