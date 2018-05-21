import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinkedinLoginErrorPage {
    WebDriver webDriver;

    public LinkedinLoginErrorPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getCurrentUrl (){
        return webDriver.getCurrentUrl();
    }

    public String getCurrentTitle () {
        return webDriver.getTitle();
    }

    public String getErrorMessage () {
        return webDriver.findElement(By.xpath("//div[@role='alert']")).getText();
    }
    public String getSmallErrorMessage () {
        return webDriver.findElement(By.id("session_password-login-error")).getText();
    }

}
