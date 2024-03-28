package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Topic_22_Window_Tab {
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
    public void TC_13_Window_Tab()  {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        // lấy ra ID của tab hiện tại
        String basicformID = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        switchToWindowByID(basicformID);
        sleepInSeconds(3);
        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("Racules");

        // Kiểm tra title của window mới
        Assert.assertEquals(driver.getTitle(),"Google");

        // Switch về parent window
        String googleID = driver.getWindowHandle();
        sleepInSeconds(3);
        switchToWindowByID(googleID);
        Assert.assertEquals(driver.getTitle(),"Selenium WebDriver");

        // Click Facebook
        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();

        // Switch ve facebook window
        switchToWindowByID(basicformID);
        sleepInSeconds(3);
        String facebookID = driver.getWindowHandle();
        // kiểm tra title window mới
        Assert.assertEquals(driver.getTitle(),"Facebook – log in or sign up");

       // Switch ve parent window
        switchToWindowByID(facebookID);
        sleepInSeconds(3);
        driver.findElement(By.xpath("//a[text()='TIKI']")).click();

        //Switch ve tiki window
        switchToWindowByID(basicformID);
        sleepInSeconds(3);
        String tikiID = driver.getWindowHandle();

        // Kiểm tra title window mới
        Assert.assertEquals(driver.getTitle(),"Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");

        closeAllWindowsWithoutParent(basicformID);
        sleepInSeconds(3);

    }

    @Test
    public void TC_14_Window_Tab()  {
        driver.get("https://skills.kynaenglish.vn/");
        // lấy ra id của tab hiện tại
        String kynaID = driver.getWindowHandle();

        driver.findElement(By.xpath("//div[@id='k-footer']//img[@alt='facebook']")).click();
        switchToWindowByTitle("Kyna.vn | Ho Chi Minh City | Facebook");
        sleepInSeconds(3);
        String kynaFacebookID = driver.getWindowHandle();

        // Kiểm tra đã switch  thành công
        Assert.assertEquals(driver.getTitle(),"Kyna.vn | Ho Chi Minh City | Facebook");

        //Switch về tab skill kyna
        switchToWindowByTitle("Kyna.vn - Học online cùng chuyên gia");

        // Kiem tra da swtich thafnh cong
        Assert.assertEquals(driver.getTitle(),"Kyna.vn - Học online cùng chuyên gia");

        driver.findElement(By.xpath("//div[@id='k-footer']//img[@alt='youtube']")).click();
        String kynaYoutubeID = driver.getWindowHandle();
        switchToWindowByTitle("Kyna.vn - YouTube");
        sleepInSeconds(3);


        // Kiểm tra đã switch thành công
        Assert.assertEquals(driver.getTitle(),"Kyna.vn - YouTube");

        // Đóng tất cả các tab trừ tab kyna
        closeAllWindowsWithoutParent(kynaID);
        sleepInSeconds(3);


    }

    @Test
    public void TC_15_Window_Tab()  {
        driver.get("http://live.techpanda.org/");
        // lấy ra id của tab hiện tại
        String livetechpandaID = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();

        switchToWindowByID(livetechpandaID);

        String livetechpandamobileID = driver.getWindowHandle();

        // Kiểm tra đã switch  thành công
        Assert.assertEquals(driver.getTitle(),"Mobile");

        // Thêm sony xperia vào compare
        driver.findElement(By.xpath("//a[@title='Xperia']/following-sibling::div[@class='product-info']//a[text()='Add to Compare']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText(),"The product Sony Xperia has been added to comparison list.");

    }

    @Test
    public void TC_16_Window_Tab()  {
        driver.get("https://dictionary.cambridge.org/vi/");
        // lấy ra id của tab hiện tại
        String dictionaryID = driver.getWindowHandle();

        driver.findElement(By.xpath("//header[@id='header']//span[text()='Đăng nhập']")).click();

        switchToWindowByID(dictionaryID);



        // Kiểm tra đã switch  thành công
        Assert.assertEquals(driver.getTitle(),"Login");

        driver.findElement(By.xpath("//input[@value='Log in']")).click();

        // Verify error message
        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Email *']/following-sibling::span")).getText(),"This field is required");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@placeholder='Password *']/following-sibling::span")).getText(),"This field is required");

        // Close window
        closeAllWindowsWithoutParent(dictionaryID);

        switchToWindowByTitle("Cambridge Dictionary | Từ điển tiếng Anh, Bản dịch & Từ điển từ đồng nghĩa");
        Assert.assertEquals(driver.getTitle(),"Cambridge Dictionary | Từ điển tiếng Anh, Bản dịch & Từ điển từ đồng nghĩa");

        // Thêm từ khóa vào thanh search
        driver.findElement(By.cssSelector("input#searchword")).sendKeys("automation");
        driver.findElement(By.xpath("//button[@title='Tìm kiếm']")).click();

        // Verify trang search chứa từ khóa mới tìm kiếm
        String bodyText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(bodyText.contains("automation"), "automation");
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
