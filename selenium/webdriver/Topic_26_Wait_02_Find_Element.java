package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Topic_26_Wait_02_Find_Element {
    WebDriver driver;
    WebDriverWait explicitWait;

    Actions actions;
    JavascriptExecutor javascriptExecutor;

    FluentWait fluentWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        // Implicit Wait Selenium Version 4.x
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.facebook.com/");

        // Explicit Wait Selenium Ver 4
        // explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Fluent Wait Selenium Ver 4
        /*fluentWait = new FluentWait(driver);

        fluentWait.withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(500));
*/
    }


    @Test
    public void TC_01_FindElement() {
        // Case 1 - Element được tìm thấy trong khỏoảng thời gian được set
        // Sẽ không cần chờ hết timeout
        // Tìm thấy sẽ trả về 1 Web Element
        // Qua step tiếp theo
        driver.findElement(By.cssSelector("input#email"));

        // Case 2 - Element được tìm thấy nhưng có hơn 1
        // Sẽ không chờ hết timeout
        // Lấy element đầu tiên dù có n node
        driver.findElement(By.cssSelector("input[type='text'],[type='password']")).sendKeys("haha@email.com");

// Case 3 - Element không được tìm thấy
        // Chờ hết timeout 10s
        // Trong thời gian timeout 10s cứ mỗi nửa giây sẽ tìm lại 1 lần
        // Nếu tìm lại mà thấy thì cũng trả về element rồi qua step tiếp theo
        // Nếu tìm lại mà không thấy thì đánh fail và throw exception: NoSuchElement
        // các step sau không chạy nữa
        driver.findElement(By.cssSelector("input#notfound"));
    }

    @Test
    public void TC_02_Find_Elements() {
        List<WebElement> elementList;
        // Case 1 - Element được tìm thấy chỉ có 1
        // Không cần chờ hết timeout
        // Trả về 1 List Elements
        /*System.out.println("Start step: " + getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input#email"));
        System.out.println("List has: " + elementList.size());
        System.out.println("End step: " + getDateTimeNow());*/


        // Case 2 - Element được tìm thấy nhưng có hơn 1
        // Không cần chờ hết timeout
        // Trả về List Element chứa nhiều element
        /*System.out.println("Start step: " + getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input[type='text'],[type='password']"));
        System.out.println("List has: " + elementList.size());
        System.out.println("End step: " + getDateTimeNow());*/

        // Case 3 - Element không được tìm thấy
        // Chờ hết timeout
        // Mỗi nửa s cũng tìm lại 1 lần
        // Nếu trong thời gian tìm lại mà thấy element thì cũng trả về list chứa element
        // Nếu hết thời gian tìm lại mà không thấy thì trả về list rỗng, không đánh fail test case và qua step tiếp theo

        System.out.println("Start step: " + getDateTimeNow());
        elementList = driver.findElements(By.cssSelector("input[type='notfound']"));
        System.out.println("List has: " + elementList.size());
        System.out.println("End step: " + getDateTimeNow());


    }

    @Test
    public void TC_03() {


    }

    @Test
    public void TC_04() {


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
