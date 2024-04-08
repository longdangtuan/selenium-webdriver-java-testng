package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
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

public class Topic_29_Wait_05_Explicit_Wait_Mixed_Wait {
    WebDriver driver;
    WebDriverWait explicitWait;

    Actions actions;
    JavascriptExecutor javascriptExecutor;

    FluentWait fluentWait;

    String projectPath = System.getProperty("user.dir");

    String character = Platform.getCurrent().is(Platform.WINDOWS) ? "\\" : "/";


    String image1Name = "back thickness, bicep.jpg";

    String image2Name = "Forearm, calves, hamstrings.jpg";

    // Lay ra duong dan cua file
    String image1FilePath = projectPath + File.separator + "uploadFiles" + File.separator + image1Name;
    String image2FilePath = projectPath + File.separator + "uploadFiles" + File.separator + image2Name;


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }


    @Test
    public void TC_04_Invisible() {
        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start>button")).click();


        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='loading']")));

        Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Hello World!']")).isDisplayed());

    }

    @Test
    public void TC_05_Visible() {

        driver.get("https://automationfc.github.io/dynamic-loading/");
        driver.findElement(By.cssSelector("div#start>button")).click();


        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));

    }

    @Test
    public void TC_06_Explicit_Wait() {

        driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

        // Wait Date Time display
        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='datesContainer']"))));

        System.out.println(driver.findElement(By.xpath("//div[@class='datesContainer']//span")).getText());

        driver.findElement(By.xpath("//td[@title='Tuesday, April 02, 2024']")).click();

        explicitWait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='raDiv']"))));

        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[contains(@class,'rcSelected')]//a[text()='2']"))));

        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='datesContainer']//span")).getText(), "Tuesday, April 2, 2024");


    }

    @Test
    public void TC_07_Explicit_Wait() {

        driver.get("https://gofile.io/welcome");
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/uploadFiless']/button")));


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
