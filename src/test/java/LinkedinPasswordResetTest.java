import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LinkedinPasswordResetTest {
    WebDriver webDriver;


    @BeforeMethod
    public void before(){
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");
    }

    @Test

    public void successfullPasswordResetTest() throws InterruptedException {
        String testEmail = "xobpak@gmail.com";
        String testNewPass = "Qw56Ser1qaz2wsx";
        String testMailPass = "sec22daf44";
        String testSubject = "link to reset your password";
        String testFrom = "LinkedIn <security-noreply@linkedin.com>";

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login Page is not loaded.");

        LinkedinPasswordResetPage linkedinPasswordResetPage = linkedinLoginPage.resetClick();
        Assert.assertTrue(linkedinPasswordResetPage.isPageLoaded(),
                "Password Reset Page is not loaded.");

        GMailService gmailService = linkedinPasswordResetPage.getGmailService(testEmail, testMailPass, testSubject);

        LinkedinPasswordResetSubmitPage linkedinPasswordResetSubmitPage = linkedinPasswordResetPage.resetSend(testEmail);
        Assert.assertTrue(linkedinPasswordResetSubmitPage.isPageLoaded(),
                "Password Reset Submit Page is not loaded.");

        String message = gmailService.waitMessage(testSubject, testEmail, testFrom, 20);
        String link = StringUtils.substringBetween(message, "To change your LinkedIn password, click <a href=\"", "\" style").replace("&amp;","&");

        LinkedinPasswordSetPage linkedinPasswordSetPage = linkedinPasswordResetSubmitPage.goResetLink(link);
        Assert.assertTrue(linkedinPasswordSetPage.isPageLoaded(),
                "Set a new password Page is not loaded.");
        LinkedinLoginTest linkedinLoginTest = linkedinPasswordSetPage.setNewPassword(testNewPass);
        sleep(3000);
        webDriver.get("https://www.linkedin.com/");
        linkedinLoginTest.successfulLoginTest(testEmail, testNewPass);
    }

    /*@AfterMethod
    public void after(){
        webDriver.close();
    }*/


}
