import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinPasswordResetPage extends LinkedinBasePage {

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id="reset-password-submit-button")
    private WebElement resetPasswordButton;

    public LinkedinPasswordResetPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    boolean isPageLoaded() {
        return usernameField.isDisplayed();
    }

    public <T> T resetSend(String email){
        usernameField.sendKeys(email);
        resetPasswordButton.click();
        return (T) new LinkedinPasswordResetSubmitPage(webDriver);
    }

    public GMailService getGmailService(String testEmail, String testPass, String testSubject) {
        GMailService gmailService = new GMailService(testEmail, testPass, testSubject);
        gmailService.connect();
        return gmailService;
    }
}

