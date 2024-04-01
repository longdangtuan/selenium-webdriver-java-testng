package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_25_Wait_01_Element_Status {
    WebDriver driver;
    WebDriverWait explicitWait;

    Actions actions;
    JavascriptExecutor javascriptExecutor;

    By reconfirmEmailTextbox = By.cssSelector("input[name='reg_email_confirmation__']");





    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://www.facebook.com/");

    }



    @Test
    public void TC_01_Visible()  {
driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
sleepInSeconds(3);

driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("reusmarco0706@gmail.com");
sleepInSeconds(3);

// Tại bước này thì Confirm Email Textbox đang visible/displayed
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(reconfirmEmailTextbox));

        // Kiiểm tra 1 element đang hiển thị
        Assert.assertTrue(driver.findElement(reconfirmEmailTextbox).isDisplayed());

    }

    @Test
    public void TC_02_Invisible()  {
// Element không xuất hiện trên UI và vẫn có trong cây HTML
        driver.findElement(By.cssSelector("input[name='reg_email__']")).clear();

        // Tại thời điểm này element đang invisible ( Invisible in DOM )
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(reconfirmEmailTextbox));

        // Kiểm tra element không hiển thị
        // Chạy nhanh -> kết quả step này Passed
        Assert.assertFalse(driver.findElement(reconfirmEmailTextbox).isDisplayed());

        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();

        // Tại thời điểm này element đang invisible ( Invisible not in DOM )
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(reconfirmEmailTextbox));

        // Kiểm tra element không hiển thị
        // Chạy lâu -> step bị failed vì không tìm thấy element trong DOM ở bước find element
       // Assert.assertFalse(driver.findElement(reconfirmEmailTextbox).isDisplayed());

    }

    @Test
    public void TC_03_Presence()  {
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInSeconds(3);

        driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("reusmarco0706@gmail.com");
        sleepInSeconds(3);

        // Tại thời điểm này thì confirm email textbox đang visible/dislayed/presence (hiển thị trong DOM và trên UI)
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(reconfirmEmailTextbox));

        // Element không xuất hiện trên UI và vẫn có trong cây HTML (presence)
        driver.findElement(By.cssSelector("input[name='reg_email__']")).clear();
        sleepInSeconds(3);

        explicitWait.until(ExpectedConditions.presenceOfElementLocated(reconfirmEmailTextbox));



    }

    @Test
    public void TC_04_Staleness()  {
        driver.findElement(By.cssSelector("a[data-testid='open-registration-form-button']")).click();
        sleepInSeconds(3);

        // Taji thơi điểm này element có xuất hiện và mình sẽ find element
        WebElement reconfirmEmail = driver.findElement(reconfirmEmailTextbox);

        // Đóng pop up
        driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/preceding-sibling::img")).click();

        // Tại thời điểm này, Element không xuất hiện trên UI và cũng không có trong cây HTML
        explicitWait.until(ExpectedConditions.stalenessOf(reconfirmEmail));


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

    public void switchToWindowByID (String parentID) {
        // Lấu ra ID của window/tab đang có
        Set<String> allIDs = driver.getWindowHandles();

        // Dùng vòng lặp duyệt qua từng id
        for(String id : allIDs){
            if(!id.equals(parentID)){
                // Nếu ID nào khác parentID thì switch vào
                driver.switchTo().window(id);
                break;
            }
        }
    }

    public void switchToWindowByTitle (String expectedTitle){
        // lấy tất cả id
        Set<String> allIDs = driver.getWindowHandles();

        // DFUNGF VÒNG LẶP duyệt qua set ID
        for (String id : allIDs){
            // cho switch vào từng id trước
            driver.switchTo().window(id);
            sleepInSeconds(3);
            // lấy ra title của window hiện tại
            String actualTitle = driver.getTitle();
            if(actualTitle.equals(expectedTitle)){
                break;
            }
        }
    }

    public boolean closeAllWindowsWithoutParent (String parentID){
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindows : allWindows){
            if(!runWindows.equals(parentID)){
                driver.switchTo().window(runWindows);
                driver.close();
            }
        }
        driver.switchTo().window(parentID);
        if(driver.getWindowHandles().size() == 1)
            return true;
        else
            return false;
    }


}
