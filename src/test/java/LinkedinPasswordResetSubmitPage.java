import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinPasswordResetSubmitPage extends LinkedinBasePage {

    @FindBy(id="resend-url")
    private WebElement resendUrl;

    public LinkedinPasswordResetSubmitPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    boolean isPageLoaded() {
        return resendUrl.isDisplayed();
    }
}
