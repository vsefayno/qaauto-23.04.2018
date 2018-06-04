import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void before(){
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");
    }

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "xobpak@gmail.com", "QwS1qaz2wsx" },
     //          { "XOBPAK@GMAIL.COM", "QwS1qaz2wsx" },
        };
    }

    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String email, String password) {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up","Login page wrong");

        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login Page is not loaded.");

        LinkedinHomePage linkedinHomePage = linkedinLoginPage.login(email, password);

        Assert.assertTrue(linkedinHomePage.isPageLoaded(),
                "Login Page is not loaded.");

    }

    @DataProvider
    public Object[][] notValidDataProvider() {
        return new Object[][]{
                { "11111", "11111" },
                { "mail@mail.com", "password" },
        };
    }

    @Test(dataProvider = "notValidDataProvider")
    public void negativeReturnedToLoginSubmit(String email, String password) throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up", "Login page wrong");
        //Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
              //  "sign in Button is not Displayed.");

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = linkedinLoginPage.login(email, password);

        sleep(3000);
        Assert.assertEquals(linkedinLoginSubmitPage.getCurrentUrl(),
                "https://www.linkedin.com/uas/login-submit","login-submit URL is wrong.");
        Assert.assertEquals(linkedinLoginSubmitPage.getCurrentTitle(),
                "Sign In to LinkedIn","login-submit URL is wrong.");
        Assert.assertEquals(linkedinLoginSubmitPage.getErrorMessage(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Wrong error message displayed");
        Assert.assertTrue(linkedinLoginSubmitPage.isPageLoaded(),
                "Login-Submit page is not loaded");
    }

    @DataProvider
    public Object[][] emptyDataProvider() {
        return new Object[][]{
                { "111", "" },
                { "", "111" },
                { "", "" }
        };
    }

    @Test(dataProvider = "emptyDataProvider")
    public void negativeStayLoginPageTest(String email, String password) throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up", "Login page wrong");
        linkedinLoginPage.login(email, password);
        sleep(3000);

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up", "Login page wrong");
        //Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
              //  "sign in Button is not Displayed.");
    }


    @AfterMethod
    public void after(){
        webDriver.close();
    }

}
