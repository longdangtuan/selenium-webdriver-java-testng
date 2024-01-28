package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_05_Selenium_Text {
    WebDriver driver;


    @Test
    public void TC_01() {

        driver = new FirefoxDriver();

        driver.get("https://automationfc.github.io/basic-form/");
        // 1 Truyen text vao trong locator de kiem tra hien thi
        // nen su dung vi tuyet doi
        driver.findElement(By.xpath("//h1[text()='Selenium WebDriver API']")).isDisplayed();
        // han che vi tuong doi
        driver.findElement(By.xpath("//p[contains(text(),'Mail Personal or Business Check')]")).isDisplayed();
        // Get text roi verify sau
     String text =   driver.findElement(By.xpath("//h5[@id='nine']/p[1]")).getText();
        Assert.assertTrue(text.contains("Mail Personal or Business Check"));
        // demo contains(string(),'...')

    }
}
