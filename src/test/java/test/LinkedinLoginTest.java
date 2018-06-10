package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.LinkedinHomePage;
import page.LinkedinLoginSubmitPage;

import static java.lang.Thread.sleep;

public class LinkedinLoginTest extends LinkedinBaseTest{

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "iteatest@i.ua", "1q2w3e_4r5t" },
                // { "ITEATEST@I.UA", "1q2w3e_4r5t" }
        };
    }

    @Test(dataProvider="validDataProvider")
    public void successfulLoginTest(String email, String password) {
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page Title is wrong");
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
    public void negativeReturnedToLoginSubmitTest(String email, String password) throws InterruptedException {
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login Page is not loaded.");
        linkedinLoginPage.login(email, password);
        sleep (3000);
        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(webDriver);
        Assert.assertTrue(linkedinLoginSubmitPage.isPageLoaded(),
                "Login-Submit page is not loaded.");
        Assert.assertEquals(linkedinLoginSubmitPage.getErrorMessageText(),
                "There were one or more errors in your submission. Please correct the marked fields below.",
                "Error message text is incorrect.");

    }

    @DataProvider
    public Object[][] emptyDataProvider() {
        return new Object[][]{
                { "111", "" },
                { "", "111" },
                { "", "" }
        };
    }

/*    @Test(dataProvider = "emptyDataProvider")
    public void negativeStayLoginPageTest(String email, String password) throws InterruptedException {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up", "Login page wrong");
        linkedinLoginPage.loginTry(email, password);
        sleep(3000);

        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up", "Login page wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "sign in Button is not Displayed.");
    }*/




}