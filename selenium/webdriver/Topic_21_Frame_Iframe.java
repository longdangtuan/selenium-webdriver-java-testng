package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_21_Frame_Iframe {
    WebDriver driver;

    WebDriverWait explicitWait;
    Actions actions;
    JavascriptExecutor javascriptExecutor;

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
    public void TC_10_Iframe_Kyna() {
        driver.get("https://skills.kynaenglish.vn/");
        driver.switchTo().frame(driver.findElement(By.cssSelector("div.face-content>iframe")));

        // Verify follower
        Assert.assertEquals(driver.findElement(By.xpath("//a[@title='Kyna.vn']/parent::div/following-sibling::div")).getText(), "178K followers");

        // Click vào chat iframe
        driver.switchTo().defaultContent();
        driver.switchTo().frame("cs_chat_iframe");
        driver.findElement(By.xpath("//body[@ng-app='csChatApp']")).click();
        driver.findElement(By.cssSelector("input.input_name")).sendKeys("Yanma");

        // Sendkey vói từ khóa excel vào click vào search icon
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("input#live-search-bar")).sendKeys("excel");
        driver.findElement(By.cssSelector("button.search-button")).click();

        // Verify chuyển page
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='card-popup' and @href='/hoc-excel-tu-cong-viec-thuc-te']")).isDisplayed());
    }

    @Test
    public void TC_11_IFrame_formsite() {
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");
        driver.findElement(By.cssSelector("div#imageTemplateContainer>img")).click();
        driver.switchTo().frame(driver.findElement(By.cssSelector("div#formTemplateContainer>iframe")));

        // Nhập dữ liệu vào 3 fields và ấn submit
        new Select(driver.findElement(By.name("RESULT_RadioButton-2"))).selectByVisibleText("Freshman");
        new Select(driver.findElement(By.name("RESULT_RadioButton-3"))).selectByVisibleText("East Dorm");
        WebElement radioBtn4_1 = driver.findElement(By.id("RESULT_RadioButton-4_1"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].checked = true;", radioBtn4_1);

        driver.findElement(By.cssSelector("input.submit_button")).click();
        sleepInSeconds(3);

        // Click vào login button
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//a[@title='Log in']")).click();

        //Verify error message
        driver.findElement(By.cssSelector("button#login")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(), "Username and password are both required.");


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
