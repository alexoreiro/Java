package com.herokuapp.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testing.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class PositiveTests {

    @Test
    public void loginTest() {
	// Create driver
	System.setProperty("webdriver.chorme.driver", "src/main/resources/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	//maximize browser window
	driver.manage().window().maximize();

	//open test page
	String url = "http://the-internet.herokuapp.com/login";
	driver.get(url);
	System.out.println("Page is opened.");

	
	//enter username
	WebElement username = driver.findElement(By.id("username"));
	username.sendKeys("tomsmith");
	
	//enter password
	WebElement password = driver.findElement(By.name("password");
	password.sendKeys("SuperSecretPassword");

	//click login button
	WebElement logInButton = driver.findElement(By.tagName("Button"));
	logInButton.click();

	//verification
	//new url
	String expectedUrl = "http://the-internet.herokuapp.com/secure";
	String actualUrl = driver.getCurrentUrl();
	Assert.assertEquals(actualUrl, expectedUrl, "Actual page url is not the same as expected");

	//logout button is visible
	WebElement logOutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']")
	Assert.assertTrue(logOutButton.isDisplayed(), "Log out button is not visible");					     

	//succesful login message
	WebElement successMessage = driver.findElement(By.cssSelector("#flash"));
	String expectedMessage = "You logged into a secure area!";
	String actualMessage = successMessage.getText();
	Assert.assertTrues(actualMessage.contains(expectedMessage), "Actual message does not contain expected message.\n");

	//close browser
	driver.quit();
    }

}
