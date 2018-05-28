import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedinLoginSubmitPage extends LinkedinBasePage {

    @FindBy(xpath="//div[@role='alert']")
    private WebElement errorMessage;

    @FindBy(id="session_key-login")
    private WebElement userEmailField;

    public LinkedinLoginSubmitPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public boolean isPageLoaded (){
        return userEmailField.isDisplayed();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

}
