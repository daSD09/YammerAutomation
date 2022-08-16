package com.yammer.testing;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import static com.yammer.utility.Util.EMAIL;

public class YammerTest {

	WebDriver driver = null;

	@Before
	public void setUp() {
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\SHRAMANA DAS\\CAPGEMINI_JSWorkspace\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://web.yammer.com/main/capgemini.com/");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {

			driver.findElement(By.id("i0116")).sendKeys(EMAIL);
			Thread.sleep(3000);

			driver.findElement(By.id("idSIButton9")).click();
			Thread.sleep(7000);
			driver.findElement(By.xpath("//*[@id=\"mobilepass-div\"]/a")).click();
			Thread.sleep(7000); // email next button

			WebElement passCode = driver.findElement(By.id("password"));
			String value = passCode.getAttribute("value");
			/*
			 * while(value.isEmpty()) { //Thread.sleep(17000);
			 * 
			 * } while(!value.isEmpty()) { if(value.length()==6) { break; }
			 * 
			 * }
			 */

			driver.findElement(By.id("signOnButton")).click();
			Thread.sleep(5000);

			driver.findElement(By.id("KmsiCheckboxField")).click();

			driver.findElement(By.id("idSIButton9")).click();
			Thread.sleep(18000);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void postContentTest() {

		try {
			driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div/div[2]/div/div[1]/div/div/div/div[1]/div[2]/div/div/div/div/nav/div[2]/div/div/div[1]/div[2]/div/div/div/div[2]/ul/li[1]/div/div/div/div/a/div/div/div[2]/div/div/div/div"))
					.click();
			Thread.sleep(7000);

			driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div/div[1]/div/div/div/div/div[1]/div/div/div[2]/div/button/div/div"))
					.click();
			Thread.sleep(3000);

			driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div/span/div/div[2]/div/div/div/div"))
					.sendKeys("Happy Independence Day");

			// driver.findElement(By.className("public-DraftStyleDefault-block
			// public-DraftStyleDefault-ltr")).sendKeys("Happy Independence Day");
			Thread.sleep(15000);

			driver.findElement(By.xpath(
					"//*[@id=\"root\"]/div/div[2]/div/div[2]/div/div/div/div/div/div[2]/div[1]/div/div/div/div/div/div[5]/div[2]/div/div/div/div/div[1]/button"))
					.click();
			Thread.sleep(7000);

		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			Assert.fail("postContent test fail");
		}
	}

	@After
	public void closeDriver() {

		driver.close();
	}
}
