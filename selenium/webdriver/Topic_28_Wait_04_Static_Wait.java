package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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

public class Topic_28_Wait_04_Static_Wait {
    WebDriver driver;
    WebDriverWait explicitWait;

    Actions actions;
    JavascriptExecutor javascriptExecutor;

    FluentWait fluentWait;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();


    }



    @Test
    public void TC_01_Static_Wait() throws InterruptedException {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start>button")).click();
        Thread.sleep(5000);

        Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());

    }


    @AfterClass
    public void afterClass(){driver.quit();}

    public void sleepInSeconds(long timeInSecond){
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public String getDateTimeNow(){
        Date date =  new Date();
        return date.toString();
    }

}
