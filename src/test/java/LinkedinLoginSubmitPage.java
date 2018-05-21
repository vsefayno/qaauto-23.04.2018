import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkedinLoginSubmitPage {
    private WebDriver webDriver;
    private WebElement errorMessage;
    private WebElement userEmailField;

    public LinkedinLoginSubmitPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements();
    }

    public void initElements() {
        errorMessage = webDriver.findElement(By.xpath("//div[@role='alert']"));
        userEmailField = webDriver.findElement(By.id("session_key-login"));
    }
    public boolean isPageLoaded (){
        return userEmailField.isDisplayed();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public String getSmallErrorMessage() {
        return webDriver.findElement(By.id("session_password-login-error")).getText();
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public String getCurrentTitle() {
        return webDriver.getTitle();
    }
}
