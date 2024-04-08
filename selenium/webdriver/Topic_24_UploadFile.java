package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Topic_24_UploadFile {
    WebDriver driver;

    WebDriverWait explicitWait;
    Actions actions;
    JavascriptExecutor javascriptExecutor;

    // lay ra duong dan cua project
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
        actions = new Actions(driver);
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        javascriptExecutor = (JavascriptExecutor) driver;
        // ngầm định: không rõ ràng cho 1 trạng thái cụ thể nào của element
        // ngầm định cho việc tìm elements - Find Element(s)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }


    @Test
    public void TC_01_Upload_Files() {
        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        By uploadBy = By.cssSelector("input[name='files[]']");

        driver.findElement(uploadBy).sendKeys(image1FilePath + "\n" + image2FilePath);


        // Verify file is loaded
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + image1Name + "']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text()='" + image2Name + "']")).isDisplayed());

        List<WebElement> startButtons = driver.findElements(By.cssSelector("td>button.start"));

        // for each
        for (WebElement button : startButtons) {
            button.click();
            sleepInSeconds(2);
        }


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


}
