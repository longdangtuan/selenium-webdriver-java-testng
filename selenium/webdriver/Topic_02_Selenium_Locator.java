package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {
    WebDriver driver;



    @Test
    public void TC_01_ID() {
        // 8 loại locator
        // ID/ Class/ Name = Trng với 3 attribute của HTML
        // LinkText/ Paritial LinkText: chỉ làm việc voới HTML link
        // Tagname: HTML Tagname
        // Css/Xpath

        // Selenium version 4.x: GUI (GraphicUserInterface)
        // Class  - Relative Locator
        // above/ below/ near/ leftOf/ rightOf

        // UI Testing
        //
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.id("FirstName")).sendKeys("Jake");

    }
    @Test
    public void TC_02_Class() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.className("header-logo"));
    }

    @Test
    public void TC_03_Name() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.name("generator"));
    }
    @Test
    public void TC_04_TagName() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElements(By.tagName("input"));
    }
    @Test
    public void TC_05_LinkText() {
        // do chinh xac tuyet doi
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.linkText("Privacy notice"));
    }
    @Test
    public void TC_06_Partial_LinkText() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.findElement(By.partialLinkText("Conditions"));
    }
    @Test
    public void TC_07_Css() {

        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        // Css vs ID
        driver.findElement(By.cssSelector("input[id='LastName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));
       // Css vs Class
        driver.findElement(By.cssSelector("div[class='page-title"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));
       // Css vs Name
                driver.findElement(By.cssSelector("input[name='LastName']"));
        // Css vs tagname
        driver.findElement(By.cssSelector("input"));
        // Css vs link
        driver.findElement(By.cssSelector("a[href='/recentlyviewedproducts']"));
        // Css vs partial link
        //driver.findElement(By.cssSelector("a[href*='/viewedproducts']"));
    }
    @Test
    public void TC_08_XPath() {

        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        // XPhath vs ID
        driver.findElement(By.xpath("//input[@id='LastName']"));

        // Css vs Class
        driver.findElement(By.xpath("//div[@class='page-title']"));

                // Css vs Name
                driver.findElement(By.xpath("//input[@name='LastName']"));
        // Css vs tagname
        driver.findElement(By.xpath("//input"));
        // Css vs link
        driver.findElement(By.xpath("//a[@href='/recentlyviewedproducts']"));
        driver.findElement(By.xpath("//a[text()='Addresses']"));
        // Css vs partial link
        driver.findElement(By.xpath("//a[contains(@href,'address')]"));
    }
}
