import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SelTest {

    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver/chromedriver.exe ");
        WebDriver driver = new ChromeDriver();
        driver.get("https://dclite.ru/");


        driver.findElement(By.id("c-header__reg-btn")).click();
        Thread.sleep(5000);
        System.out.println(driver.getCurrentUrl());
        ((ChromeDriver) driver).findElementById("email").sendKeys("pop");
        Thread.sleep(5000);
        ((ChromeDriver) driver).findElementByXPath("html/body/header/div[1]/div/a[3]").click();
 
        for(String winHandle : driver.getWindowHandles()){
            System.out.println(winHandle);
        }
        System.out.println(driver.getCurrentUrl());
    }
}
