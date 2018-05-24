

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.Thread.sleep;

public class LinkedinLoginAlter {
    WebDriver webDriver = new FirefoxDriver();


    public boolean isElementPresent(By by) {
        boolean result = false;
        try {
            webDriver.findElement(by);
            result = true;
        } finally {
            return result;
        }
    }


        By homeFeed = By.xpath("//span[@id='feed-tab-icon']");
        By homeMe = By.xpath("//button[@id='nav-settings__dropdown-trigger']");
        By homeWork = By.xpath("//button[@data-control-name='nav.launcher']");

        //wait 10 seconds and logout site and quit browser
        //webDriver.findElement(By.xpath("//button[@id='nav-settings__dropdown-trigger']")).sendKeys(Keys.ENTER);
        //webDriver.findElement(By.xpath("//a[@data-control-name='nav.settings_signout']")).sendKeys(Keys.ENTER);
        //webDriver.quit();

/*
        // negative testing
        webDriver.get("https://www.linkedin.com/");
        signinButton.click();
        sleep(3000);
        Assert.assertNotEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Security fail. Login with empty credentials");

        webDriver.get("https://www.linkedin.com/");
        emailField.sendKeys("email@domain.com");
        signinButton.click();
        sleep(3000);
        Assert.assertNotEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Security fail. Login with empty password");

        webDriver.get("https://www.linkedin.com/");
        passwordField.sendKeys("P@ssw0rd");
        signinButton.click();
        sleep(3000);
        Assert.assertNotEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Security fail. Login with empty email");

        webDriver.get("https://www.linkedin.com/");
        emailField.sendKeys("nonExisting@email.com");
        passwordField.sendKeys("wrongPassword");
        signinButton.click();
        sleep(3000);
        Assert.assertNotEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Security fail. Login with non existing credentials");
*/



    public boolean isSignInButtonDisplayes() {
        boolean result = false;
        try {
            //signinButton = webDriver.findElement(By.id("login-submit"));
            result = true;
        } finally {
            return result;
        }
    }
    }



//      @Before Method - run each time for each
//      @Before Class - run once
//      @After


/*
    @DataProvider
    public Object[][] mixedDataProvider() {
        return new Object[][] {
                { "vedmedyar@gmail.com", "Pass_wrong" }
        };
    };

@Test(dataProvider = "mixedDataProvider")
public void successfulSecondTryLoginTest(String email, String password) {
        String correctPassword = "Pass_correct";

        LinkedinLoginPage linkedinLoginPage = new LinkedinLoginPage(webDriver);
        Assert.assertEquals(linkedinLoginPage.getCurrentTitle(),
        "LinkedIn: Log In or Sign Up", "Login page wrong");
        Assert.assertTrue(linkedinLoginPage.isSignInButtonDisplayed(),
        "sign in Button is not Displayed.");
        linkedinLoginPage.login(email, password);

        LinkedinLoginSubmitPage linkedinLoginSubmitPage = new LinkedinLoginSubmitPage(webDriver);
        Assert.assertEquals(linkedinLoginSubmitPage.getCurrentUrl(),
        "https://www.linkedin.com/uas/login-submit","login-submit URL is wrong.");
        Assert.assertEquals(linkedinLoginSubmitPage.getCurrentTitle(),
        "Sign In to LinkedIn","login-submit URL is wrong.");

        //create method
        linkedinLoginPage.loginFromSubmit (email, correctPassword);

        LinkedinHomePage linkedinHomePage = new LinkedinHomePage(webDriver);
        // add asserts
        }*/
