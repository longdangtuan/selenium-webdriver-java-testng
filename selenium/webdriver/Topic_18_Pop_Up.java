package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Topic_18_Pop_Up {
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
    public void TC_01_Fixed_Popupp_In_DOM_01()  {
driver.get("https://ngoaingu24h.vn/");
driver.findElement(By.cssSelector("button.login_ ")).click();

By loginPopup = By.cssSelector("div[id='modal-login-v1'][style]>div");

// Kiểm tra login popup đang hiển thị
Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] input#account-input")).sendKeys("Dortmund");
        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] input#password-input")).sendKeys("Dortmund");
        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] button.btn-login-v1")).click();

        // Verify message
        Assert.assertEquals(driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] div.error-login-panel")).getText(),"Tài khoản không tồn tại!");

        driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] button.close")).click();

        // Kiểm tra login popup không hiển thị
        Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
    }
    @Test
    public void TC_02_Fixed_Popup_In_DOM_02()  {
        driver.get("https://skills.kynaenglish.vn/");
        driver.findElement(By.cssSelector("a.login-btn")).click();

        By loginPopup = By.xpath("//div[@class='k-popup-account-mb-content']");

        // Kiểm tra login popup hiển thị
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());

        // Nhập thông tin
        driver.findElement(By.cssSelector("input#user-login")).sendKeys("automation@gmail.com");
        driver.findElement(By.cssSelector("input#user-password")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@id='btn-submit-login']")).click();
        sleepInSeconds(3);

        //Verify message
        Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(),"Sai tên đăng nhập hoặc mật khẩu");

        driver.findElement(By.cssSelector("button.k-popup-account-close")).click();

        // Kiểm tra login popup không hiển thị
        Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());


    }

    @Test
    public void TC_04_Click_And_Hold()  {

    }


    @Test
    public void TC_06_Double_Click()  {

    }

    @Test
    public void TC_08_DragDropHTML4(){

    }

    @Test
    public void TC_08_DragDropHTML5_Css(){
       
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
