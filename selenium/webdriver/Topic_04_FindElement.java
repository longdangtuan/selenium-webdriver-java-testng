package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_FindElement {
    WebDriver driver;


    @Test
    public void TC_01() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
        // Click vao My account o tren footer
        // My account link tren header khong hien thi nen se bi fail
        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
    }

    @Test
    public void TC_02() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://live.techpanda.org/index.php/customer/account/login/");
        // Click vao My account o tren footer
        // My account link tren header khong hien thi nen se bi fail
        driver.findElement(By.xpath("//div[@class='footer-container']//a[@title='My Account']")).click();
        driver.quit();
    }
}
