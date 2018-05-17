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
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
                "LinkedIn: Log In or Sign Up",
                "Login page wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
                "sign in Button is not Displayed.");
        linkedinLoginPage.login("vedmedyar@gmail.com","Pass_vedmed");

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);
        Assert.assertEquals(linkedinHomePage.getCurrentUrl(),
                "https://www.linkedin.com/feed/",
                "Homepage URL is wrong.");
        Assert.assertTrue(linkedinHomePage.getCurrentTitle().contains("LinkedIn"),
                "Homepage Title is wrong.");
    }


    @Test
    public void negativeLoginTest () throws InterruptedException {

        String actualLoginPageTitle = webDriver.getTitle();
        Assert.assertEquals(actualLoginPageTitle, "LinkedIn: Log In or Sign Up", "Login page wrong");

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);

        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),"sign in Button is not Displayed.");

        linkedinLoginPage.login("vedmedyar@gmail.com","Wrong_Pass");

        sleep(3000);

        String currentPageUrl = webDriver.getCurrentUrl();
        String currentPageTitle = webDriver.getTitle();
        Assert.assertEquals(currentPageUrl,"https://www.linkedin.com/uas/login-submit","login-submit URL is wrong.");
        Assert.assertEquals(currentPageTitle, "Sign In to LinkedIn","login-submit URL is wrong.");

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
