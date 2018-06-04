import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinPasswordSetPage extends LinkedinBasePage {
    @FindBy(id="newPassword")
    private WebElement newPassword;

    @FindBy(id="confirmPassword")
    private WebElement confirmPassword;

    @FindBy(id="reset-password-submit-button")
    private WebElement setNewPasswordButton;

    public LinkedinPasswordSetPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    boolean isPageLoaded() {
        return newPassword.isDisplayed();
    }

    public LinkedinLoginTest setNewPassword(String password){
        newPassword.sendKeys(password);
        confirmPassword.sendKeys(password);
        setNewPasswordButton.click();
        return new LinkedinLoginTest();
    }
}
