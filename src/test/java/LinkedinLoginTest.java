import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;






public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before(){
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");
    }

    @Test
    public void successfulLoginTest() throws InterruptedException {

        String actualLoginPageTitle = webDriver.getTitle();
        Assert.assertEquals(actualLoginPageTitle, "LinkedIn: Log In or Sign Up", "Login page wrong");

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        WebElement signinButton = linkedinLoginPage.getSigninButton();
        Assert.assertTrue(signinButton.isDisplayed(),"sign in Button is not Displayed.");

        linkedinLoginPage.login("vedmedyar@gmail.com","Pass_vedmed");

        Assert.assertFalse(linkedinLoginPage.isSignInButtonDisplayed(), "sign in Button displays.");
        String actualHomePageTitle = webDriver.getTitle();
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Homepage URL is wrong.");
        Assert.assertNotEquals(actualLoginPageTitle,actualHomePageTitle,"Page title not change after Sign In");
    }


    @Test
    public void negativeLoginTest () throws InterruptedException {

        String actualLoginPageTitle = webDriver.getTitle();
        Assert.assertEquals(actualLoginPageTitle, "LinkedIn: Log In or Sign Up", "Login page wrong");

        WebElement emailField = webDriver.findElement(By.id("login-email"));
        WebElement passwordField = webDriver.findElement(By.id("login-password"));
        WebElement signinButton = webDriver.findElement(By.id("login-submit"));

        Assert.assertTrue(signinButton.isDisplayed(),"sign in Button is not Displayed.");

        emailField.sendKeys("vedmedyar@gmail.com");
        passwordField.sendKeys("1");
        signinButton.click();

        sleep(3000);

//        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "Homepage URL is wrong.");

        String currentPageUrl = webDriver.getCurrentUrl();
        String currentPageTitle = webDriver.getTitle();
        Assert.assertEquals(currentPageUrl, "https://www.linkedin.com/uas/login-submit", "login-submit URL is wrong.");
        Assert.assertEquals(currentPageTitle, "Sign In to LinkedIn", "login-submit URL is wrong.");

        WebElement errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));

        Assert.assertEquals(errorMessage.getText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Wrong error message displayed");


    }



    @AfterMethod
    public void after(){
        webDriver.close();
    }



}
