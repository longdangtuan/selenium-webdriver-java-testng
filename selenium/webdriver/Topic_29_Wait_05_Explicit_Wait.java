package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class Topic_29_Wait_05_Explicit_Wait {
    WebDriver driver;
    WebDriverWait explicitWait;

    Actions actions;
    JavascriptExecutor javascriptExecutor;

    FluentWait fluentWait;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }



    @Test
    public void TC_01_Invisible()  {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start>button")).click();


        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']")));

        Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());

    }

    @Test
    public void TC_02_Visible()  {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start>button")).click();


        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));



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
