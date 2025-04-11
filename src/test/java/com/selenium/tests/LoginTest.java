package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeTest
    public void setup() {
        // Set the path to your ChromeDriver
        System.setProperty("webdriver.chrome.driver",
                "E:/SeleniumTestProject/SeleniumTestProject/chromedriver.exe");

        // Initialize the WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open the login page (local HTML file)
        driver.get("file:///E:/SeleniumTestProject/SeleniumTestProject/index.html");
    }

    @Test
    public void testLogin() {
        // Find username, password and login button elements
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login"));

        // Enter credentials and click login
        username.sendKeys("testuser");
        password.sendKeys("password123");
        loginButton.click();

        // Optional: Add an assertion here to verify login success
        // Example (if success message has id="success"):
        // WebElement successMessage = driver.findElement(By.id("success"));
        // Assert.assertTrue(successMessage.isDisplayed(), "Login was not successful!");
    }

    @AfterTest
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
