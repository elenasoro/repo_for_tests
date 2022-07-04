import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class SignUpTest {

    @Test
    public void fiveDigitZipCodeTest() {
        // Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Open url of zipcode page
        driver.get("https://sharelane.com/cgi-bin/register.py");


        // Input 5 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("12345");

        // Click on Continue button
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        // Add check
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        boolean isRegisterDisplayed = registerButton.isDisplayed();
        driver.quit();
        Assert.assertTrue(isRegisterDisplayed, "'Register' button isn't displayed");

    }

    @Test
    public void fourDigitZipCodeTest() {
        // Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Open url of zipcode page
        driver.get("https://sharelane.com/cgi-bin/register.py");

        // Input 4 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("1234");

        // Click on Continue button
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        // Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorMessageDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorMessageDisplayed, "Error message isn't displayed");
    }

    @Test
    public void sixDigitZipCodeTest() {
        // Open Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Open url of zipcode page
        driver.get("https://sharelane.com/cgi-bin/register.py");

        // Input 6 digits into input field
        driver.findElement(By.name("zip_code")).sendKeys("123456");

        // Click on Continue button
        driver.findElement(By.cssSelector("[value=Continue]")).click();

        // Add check
        WebElement errorMessage = driver.findElement(By.className("error_message"));
        boolean isErrorMessageDisplayed = errorMessage.isDisplayed();
        driver.quit();
        Assert.assertTrue(isErrorMessageDisplayed, "Error message isn't displayed");
    }
}
