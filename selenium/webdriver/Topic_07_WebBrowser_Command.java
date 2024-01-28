package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_07_WebBrowser_Command {
    // Cac cau lenh de thao tac voi Browser: driver.
    WebDriver driver;

    // Cac cau lenh thao tac voi Element
    // element.
WebElement element;
    @Test
    public void Register_01_Emty_Data(){
        driver = new FirefoxDriver();
        // Set truc tiep
        driver.get("https://www.facebook.com/");
        // khia bao bien
        // Bien chi dung duy nhat 1 lan thi khong nen tao
        String homePageUrl = "https://www.facebook.com/";
        driver.get(homePageUrl);
        // dong 1 tab
        driver.close();
        //dong broswer
        driver.quit();
        //2 ham close, quit se bi anh huong boi timeout cua implicitWait
        //findElement/findElements

        //findElement
        // Nó sẽ đi tìm loại By nào và trả về element neu được tìm thấy (WebElement)
        // không được tìm thấy: Fail - throw exception: NoSuchElementException
        // Trả ve 1 element - nếu như tìm thấy nhieu hon 1 thì cũng chỉ lấy 1 (thao tac với cái đầu tiên)
        WebElement emailAddressTextbox = driver.findElement(By.id("email"));

        //findElements
        // Nó sẽ đi tìm với loại By no và trả veef 1 danh sách element neu như được tifm thay ( List WebElement)
        // ko tìm thấy - ko bị fail - trả veef list rỗng (0 element0
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@id='email']"));

    }


}
