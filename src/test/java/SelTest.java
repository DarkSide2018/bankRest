import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelTest {
    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe ");
        WebDriver driver = new ChromeDriver();
        driver.get("https://it-ebooks.info");

        System.out.println(driver.getTitle());
    }
}
