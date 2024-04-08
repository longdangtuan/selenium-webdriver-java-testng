package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_07_WebBrowser_Command {
    //**: hay dùng
    //*: ít dùng
    // Cac cau lenh de thao tac voi Browser: driver.
    WebDriver driver;

    // Cac cau lenh thao tac voi Element
    // element.
    WebElement element;

    @Test
    public void Register_01_Emty_Data() throws MalformedURLException {
        driver = new FirefoxDriver(); //**
        // Set truc tiep
        driver.get("https://www.facebook.com/");//**
        // khia bao bien
        // Bien chi dung duy nhat 1 lan thi khong nen tao
        String homePageUrl = "https://www.facebook.com/";
        driver.get(homePageUrl);
        // dong 1 tab
        driver.close();//*
        //dong broswer
        driver.quit();//**
        //2 ham close, quit se bi anh huong boi timeout cua implicitWait
        //findElement/findElements

        //findElement
        // Nó sẽ đi tìm loại By nào và trả về element neu được tìm thấy (WebElement)
        // không được tìm thấy: Fail - throw exception: NoSuchElementException
        // Trả ve 1 element - nếu như tìm thấy nhieu hon 1 thì cũng chỉ lấy 1 (thao tac với cái đầu tiên)
        WebElement emailAddressTextbox = driver.findElement(By.id("email"));//**

        //findElements
        // Nó sẽ đi tìm với loại By no và trả veef 1 danh sách element neu như được tifm thay ( List WebElement)
        // ko tìm thấy - ko bị fail - trả veef list rỗng (0 element0
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@id='email']"));//**

        // Lấy dữ lieu de lam gi?
        // Dùng  để lấy ra url của page hiện taji đang đứng
        driver.getCurrentUrl();//*
        // Dùng để lấy ra title cura page hiện tại
        driver.getTitle();
        // lấy ra page source (HTML/CSS/JS) của page hieejn tại (verify 1 cách tương doi)
        driver.getPageSource();
        // laasy ra id của cửa sổ/ tab hiện tại
        driver.getWindowHandles();//*

        // Cooklies - Framework
        driver.manage().getCookies();//*

        //Get ra log o dev tool
        driver.manage().logs().get(LogType.DRIVER);//*

        // Apply cho việc tìm element (findElement/ findElements)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));//**

        // chowf cho page được load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        // Inject 1 đoạn code JS vafo trong Browser/ Element
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
        // Chạy full màn hình
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();//**

        // Test Responsive (Resolution)
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.manage().window().getSize();

        // Set cho browser o vi tro so voi do phan giai man hinh ( run tren man hinh co kich thuoc bao nhieu )
        driver.manage().window().setPosition(new Point(12, 30));
        driver.manage().window().getPosition();

        // Điều huong trang web
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();

        // Thao tác với history cua web page (back / forward)
        driver.navigate().to("https://www.facebook.com/");
        driver.navigate().to(new URL("https://www.facebook.com/"));
        driver.get("https/www.facebook.com/");

        // Alert/ Window (tab) / Frame (iFrame)
        driver.switchTo().alert().accept();//*
        driver.switchTo().alert().dismiss();//*
        driver.switchTo().alert().getText();//*
        driver.switchTo().alert().sendKeys("a");//*

        // lấy ra id của cuwra so/ tab hiện tại
        // Handle Window/ Tab
        String homePageWindowID = driver.getWindowHandle();//*
        driver.switchTo().window(homePageWindowID);//*

        // Switch/ handle frame (iframe)
        // Index/ ID (name)/ Element
        driver.switchTo().frame(0);//*
        driver.switchTo().frame("0");//*
        driver.switchTo().frame(driver.findElement(By.id("a")));//*

        // Switch ve HTML chứa frame trc đó
        driver.switchTo().defaultContent();

        // Từ frame trong đi ra frame ngoài
        driver.switchTo().parentFrame();
    }


}
