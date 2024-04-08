package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Topic_27_Wait_03_Implicit_Wait {
    WebDriver driver;
    WebDriverWait explicitWait;

    Actions actions;
    JavascriptExecutor javascriptExecutor;

    FluentWait fluentWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        // Implicit Wait Selenium Version 4.x
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        // Explicit Wait Selenium Ver 4
        // explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Fluent Wait Selenium Ver 4
        /*fluentWait = new FluentWait(driver);

        fluentWait.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500));
*/
    }


    @Test
    public void TC_01_Implicitwait() {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start>button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public String getDateTimeNow() {
        Date date = new Date();
        return date.toString();
    }

}
