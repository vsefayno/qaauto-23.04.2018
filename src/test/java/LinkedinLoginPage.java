import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginPage {
    WebDriver webDriver;

    private WebElement emailField;
    private WebElement passwordField;
    private WebElement signinButton;



    public LinkedinLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        emailField = webDriver.findElement(By.id("login-email"));
        passwordField = webDriver.findElement(By.id("login-password"));
        signinButton = webDriver.findElement(By.id("login-submit"));
    }

    public WebElement getSigninButton() {
        //signinButton = webDriver.findElement(By.id("login-submit"));
        return signinButton;
    }

    public void login(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signinButton.click();
    }

    public boolean isSignInButtonDisplayed() {
        boolean result = false;
        try {
            signinButton = webDriver.findElement(By.id("login-submit"));
            result = true;
        } finally {
            return result;
        }
    }

}
