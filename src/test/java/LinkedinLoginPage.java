import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginPage extends LinkedinBasePage {

    private WebElement emailField;
    private WebElement passwordField;
    private WebElement signinButton;

    public LinkedinLoginPage(WebDriver webDriver) {
        super (webDriver);
        initElements();
    }

    public void initElements(){
        emailField = webDriver.findElement(By.id("login-email"));
        passwordField = webDriver.findElement(By.id("login-password"));
        signinButton = webDriver.findElement(By.id("login-submit"));
    }

    public void login(String email, String password){
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        signinButton.click();
    }

    public boolean isSignInButtonDisplayed() {
        return signinButton.isDisplayed();
    }


}
