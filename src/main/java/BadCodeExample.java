import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import static java.lang.Thread.sleep;

public class BadCodeExample {

    public static void main(String args []) {
        System.out.println("Hello World!!");
        WebDriver webDriver = new FirefoxDriver();

        // go to google.com
        webDriver.get("https://www.google.com");
        // find 'search' field
        WebElement searchfield = webDriver.findElement(By.id("lst-ib"));
        // send 'Selenium'
        searchfield.sendKeys("Selenium");
        // variant 1 - press Enter
        //searchfield.sendKeys(Keys.ENTER);
        // variant 2 - click web button


        WebElement searchbutton = webDriver.findElement(By.xpath("//input[@type='button' and contains(@value,'Google')]"));
        try {
            sleep (1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // alternate locators for HOMETASK 2
        //div[@class='srg'] //div[@class='rc']
        //div[@data-hveid>'46'] //div[@class='rc']

/*      HOMETASK 2. VARIANT 1 with array
        List<WebElement> searchresults = webDriver.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));
        System.out.println(searchresults.size());

        for (WebElement searchresult : searchresults){
            String searchresultText = searchresult.getText();
            if (searchresultText.contains("Selenium")) {
                System.out.println("SearchTerm found!");
            }
            System.out.println(searchresultText);
        }
*/

/*      HOMETASK 2. VARIANT 2 with cycle
        for (int i = 1; i <=10; i++) {
            WebElement searchresult = webDriver.findElement(By.xpath("//div[@class='srg']/div["+i+"]"));
            String searchresultText = searchresult.getText();
            if (searchresultText.contains("Selenium")) {
                System.out.println("SearchTerm found!");
            }
            System.out.println(searchresultText);
        }
*/


        //System.out.println(searchresults);

        webDriver.quit();
        // webDriver.close();











    }


}
