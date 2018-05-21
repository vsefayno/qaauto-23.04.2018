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
    public void successfulLoginTest() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up","Login page wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "sign in Button is not Displayed.");
        linkedinLoginPage.login("vedmedyar@gmail.com","Pass_vedmed");

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);
        Assert.assertEquals(linkedinHomePage.getCurrentUrl(),
                "https://www.linkedin.com/feed/", "Homepage URL is wrong.");
        Assert.assertTrue(linkedinHomePage.getCurrentTitle().contains("LinkedIn"),
                "Homepage Title is wrong.");
    }

    @Test
    public void negativeLoginBadPassTest() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up", "Login page wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "sign in Button is not Displayed.");
        linkedinLoginPage.login("vedmedyar@gmail.com","Wrong_Pass");
        sleep(3000);

        LinkedinLoginErrorPage linkedinLoginErrorPage = new LinkedinLoginErrorPage(webDriver);
        Assert.assertEquals(linkedinLoginErrorPage.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit","login-submit URL is wrong.");
        Assert.assertEquals(linkedinLoginErrorPage.getCurrentTitle(),
                "Sign In to LinkedIn","login-submit URL is wrong.");
        Assert.assertEquals(linkedinLoginErrorPage.getErrorMessage(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Wrong error message displayed");
    }

    @Test
    public void negativeLoginBadMailBadPassTest() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up", "Login page wrong");
        linkedinLoginPage.login("11111","11111");
        sleep(3000);

        LinkedinLoginErrorPage linkedinLoginErrorPage = new LinkedinLoginErrorPage(webDriver);
        Assert.assertEquals(linkedinLoginErrorPage.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit","login-submit URL is wrong.");
        Assert.assertEquals(linkedinLoginErrorPage.getSmallErrorMessage(),
                "The password you provided must have at least 6 characters.",
                "Wrong error message displayed");
    }

    @Test
    public void negativeLoginNoPassTest() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up", "Login page wrong");
        linkedinLoginPage.login("111111","");
        sleep(3000);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up", "Login page wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "sign in Button is not Displayed.");
    }

    @Test
    public void negativeLoginNoMailTest() throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up", "Login page wrong");
        linkedinLoginPage.login("","111111");
        sleep(3000);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up", "Login page wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "sign in Button is not Displayed.");
    }


















    @AfterMethod
    public void after(){
        webDriver.close();
    }

}
