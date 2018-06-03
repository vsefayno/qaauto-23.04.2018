import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedinPasswordResetTest {
    WebDriver webDriver;


    @BeforeMethod
    public void before(){
        webDriver = new FirefoxDriver();
        webDriver.get("https://www.linkedin.com/");
    }

    @Test
    public void successfullPasswordResetTest() {
        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertTrue(linkedinLoginPage.isPageLoaded(),
                "Login Page is not loaded.");
        LinkedinPasswordResetPage linkedinPasswordResetPage = linkedinLoginPage.resetClick();

        Assert.assertTrue(linkedinPasswordResetPage.isPageLoaded(),
                "Password Reset Page is not loaded.");

        LinkedinPasswordResetSubmitPage linkedinPasswordResetSubmitPage = linkedinPasswordResetPage.resetSend("xobpak@gmail.com");
        Assert.assertTrue(linkedinPasswordResetSubmitPage.isPageLoaded(),
                "Password Reset Submit Page is not loaded.");
    }

    @AfterMethod
    public void after(){
        webDriver.close();
    }


}
