package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.function.Function;

public class Topic_30_Wait_06_Fluent_Wait {
    WebDriver driver;
    WebDriverWait explicitWait;
    FluentWait<WebDriver> webDriverFluentWait;
    FluentWait<WebElement> webElementFluentWait;
    FluentWait<String> stringFluentWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        webDriverFluentWait = new FluentWait<>(driver);

    }
    @Test
    public void TC_08_Fluent_Wait() {
        driver.get("https://automationfc.github.io/fluent-wait/");
        WebElement countDownTime = driver.findElement(By.cssSelector("div#javascript_countdown_time"));

        webElementFluentWait = new FluentWait<WebElement>(countDownTime);

        webElementFluentWait.withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        webElementFluentWait.until(new Function<WebElement, Boolean>() {
            @Override
            public Boolean apply(WebElement webElement) {
                String text = webElement.getText();
                System.out.println(text);
                return text.endsWith("00");
            }
        });


    }

    @Test
    public void TC_09_Fluent_Wait() {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start>button")).click();

        // Chờ Hello World hiển thị trong vòng 10s

        //Setting fluentWait
        webDriverFluentWait.withTimeout(Duration.ofSeconds(10))
                           .pollingEvery(Duration.ofMillis(300))
                           .ignoring(NoSuchElementException.class);

        //Condition
        webDriverFluentWait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return driver.findElement(By.xpath("//div[@id='finish']/h4[text()='Hello World!']")).isDisplayed();
            }
        });

        String helloText = webDriverFluentWait.until(new Function<WebDriver, String>() {
            @Override
            public String apply(WebDriver webDriver) {
                return driver.findElement(By.xpath("//div[@id='finish']/h4")).getText();
            }
        });
    }



    @Test
    public void TC_06_Explicit_Wait() {




    }

    @Test
    public void TC_07_Explicit_Wait() {



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
