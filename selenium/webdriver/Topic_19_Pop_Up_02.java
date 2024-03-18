package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_19_Pop_Up_02 {
    WebDriver driver;

    WebDriverWait explicitWait;
    Actions actions;
    JavascriptExecutor javascriptExecutor;

    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        actions = new Actions(driver);
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        javascriptExecutor = (JavascriptExecutor) driver;
        // ngầm định: không rõ ràng cho 1 trạng thái cụ thể nào của element
        // ngầm định cho việc tìm elements - Find Element(s)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }

    @Test
    public void TC_05_Random_Popup__Not_In_DOM_01()  {
    driver.get("https://www.javacodegeeks.com/");

    By newsletterPopup = By.xpath("//div[@class='lepopup-element lepopup-element-2 lepopup-element-rectangle lepopup-animated lepopup-fadeIn']");

    if(driver.findElements(newsletterPopup).size() > 0 && driver.findElements(newsletterPopup).get(0).isDisplayed()){
     // Có xuất hiện -> đóng pop up
        System.out.println("Pop up displays.");
        driver.findElement(By.xpath("//div[@data-animation-in='fadeIn']//a[@onclick='return lepopup_close();']")).click();
    }

    // Không xuất hiện -> nhập vào search box
    driver.findElement(By.cssSelector("input#search-input")).sendKeys("Agile Testing Explained");
    driver.findElement(By.cssSelector("button#search-submit>span.tie-icon-search")).click();

    // Kiểm tra bài viết đầu tiên xuất hiện chứa từ khóa Agile Testing Explained
    Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Agile Testing Explained']")).isDisplayed());
    }
    @Test
    public void TC_06_Random_Popup_In_DOM()  {
        driver.get("https://vnk.edu.vn/");
        sleepInSeconds(15);
        By popUp = By.cssSelector("div.tve-leads-conversion-object");

        if(driver.findElement(popUp).isDisplayed()){// Xuất hiện
            System.out.println("Pop Up");
            driver.findElement(By.cssSelector("svg.tcb-icon")).click();
        }

        // Không xuất hiện
        System.out.println("No Pop Up");


    }

    @Test
    public void TC_07_Random_Popup_In_DOM()  {
    driver.get("https://dehieu.vn/");
    sleepInSeconds(5);
    if(driver.findElement(By.cssSelector("div#modalPopupForm")).isDisplayed()){
        System.out.println("Pop Up");
        driver.findElement(By.cssSelector("button.close")).click();;
    }
        System.out.println(" No Pop Up");
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


}
