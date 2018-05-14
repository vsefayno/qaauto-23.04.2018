import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {

    @Test
    public void successfulLoginTest() throws InterruptedException {
        WebDriver webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");

//        String actualLoginPageTitle = webDriver.getTitle();
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page wrong");

        WebElement emailField = webDriver.findElement(By.id("login-email"));
        WebElement passwordField = webDriver.findElement(By.id("login-password"));
        WebElement signinButton = webDriver.findElement(By.id("login-submit"));

        Assert.assertTrue(signinButton.isDisplayed(),"sign in Button is not Displayed.");

        emailField.sendKeys("vedmedyar@gmail.com");
        passwordField.sendKeys("Pass_vedmed");
        signinButton.click();

//        String actualHomePageTitle = webDriver.getTitle();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "Homepage URL is wrong.");
//        Assert.assertNotEquals(actualLoginPageTitle,actualHomePageTitle,"Page title not change after Sign In");





    }

}
