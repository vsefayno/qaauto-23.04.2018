
/*
    @Test
    public void successfulLoginTest() throws InterruptedException {

        webDriver.get("https://www.linkedin.com/");
// check title and URL
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page wrong");
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "Not valid URL");

        Assert.assertTrue(isElementPresent(By.xpath("//input[@type='text' and @id='login-email']")), "NOT");

        WebElement loginemail = webDriver.findElement(By.xpath("//input[@type='text' and @id='login-email']"));
        WebElement loginpassword = webDriver.findElement(By.xpath("//input[@type='password' and @id='login-password']"));
        WebElement loginsubmit = webDriver.findElement(By.xpath("//input[@type='submit' and @id='login-submit']"));

        loginemail.sendKeys("vedmedyar@gmail.com");
        loginpassword.sendKeys("Pass_vedmed");
        loginsubmit.sendKeys(Keys.ENTER);

        sleep(2000);

        Assert.assertEquals(webDriver.getTitle(), "LinkedIn", "Home page wrong");
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Not valid URL");
*/


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

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

    @Test
    public void successfulLoginTest() throws InterruptedException {

        webDriver.get("https://www.linkedin.com/");

        Assert.assertEquals(webDriver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page wrong");
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/", "Not valid URL");

        By loginemail = By.xpath("//input[@type='text' and @id='login-email']");
        By loginPassword = By.xpath("//input[@type='password' and @id='login-password']");
        By loginsubmit = By.xpath("//input[@type='submit' and @id='login-submit']");

        Assert.assertTrue(isElementPresent(loginemail), "login email field NOT PRESENTS");
        Assert.assertTrue(isElementPresent(loginPassword), "login password field NOT PRESENTS");
        Assert.assertTrue(isElementPresent(loginsubmit), "submit button NOT PRESENTS");

        // logging in
        webDriver.findElement(loginemail).sendKeys("vedmedyar@gmail.com");
        webDriver.findElement(loginPassword).sendKeys("Pass_vedmed");
        webDriver.findElement(loginsubmit).sendKeys(Keys.ENTER);

        sleep(3000);

        // asserts for home page after login
        Assert.assertEquals(webDriver.getTitle(), "LinkedIn", "Home page wrong");
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/feed/", "Not valid URL");

        By homeFeed = By.xpath("//span[@id='feed-tab-icon']");
        By homeMe = By.xpath("//button[@id='nav-settings__dropdown-trigger']");
        By homeWork = By.xpath("//button[@data-control-name='nav.launcher']");
        Assert.assertTrue(isElementPresent(homeFeed), "HOME button NOT PRESENTS");
        Assert.assertTrue(isElementPresent(homeMe), "ME button NOT PRESENTS");
        Assert.assertTrue(isElementPresent(homeWork), "WORK button NOT PRESENTS");

        //wait 10 seconds and logout site and quit browser
        sleep(10000);
        webDriver.findElement(By.xpath("//button[@id='nav-settings__dropdown-trigger']")).sendKeys(Keys.ENTER);
        sleep(1000);
        webDriver.findElement(By.xpath("//a[@data-control-name='nav.settings_signout']")).sendKeys(Keys.ENTER);
        sleep(1000);
        webDriver.quit();


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








    }

    public boolean isSignInButtonDisplayes() {
        boolean result = false;
        try {
            //signinButton = webDriver.findElement(By.id("login-submit"));
            result = true;
        } finally {
            return result;
        }
    }

//      @Before Method - run each time for each
//      @Before Class - run once
//      @After

}