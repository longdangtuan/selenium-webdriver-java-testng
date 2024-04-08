package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Topic_08_WebElement_Commands {
    WebDriver driver;

    @Test
    public void TC_01_Element() {
        // HTML Element: Textbox/ TextArea/Dropdown/Checkbox/Link/Button...
        // Tifm chưa tương tác lên
        driver.findElement(By.id(""));

        // Tìm và tương tác  lên
        driver.findElement(By.id("")).click();
        //  Dng để xóa dữ lệu trong 1 field cho phép nhập (editable)
        // Thường được  sử dụng trước hàm sendKey để đảm bảo tính toàn vẹn của dữ liệu
        driver.findElement(By.id("")).clear(); //*
        // Dùng để nhập liệu vào các field
        driver.findElement(By.id("")).sendKeys("a");//**
        // Dùng để click ln element
        driver.findElement(By.id("")).click();//**
        // Tìm từ node cha vào node con
        driver.findElement(By.id("")).findElement(By.name(""));

        // Tìm  và lưu vào 1 biến WebElement (chưa tương tác)
        // Khi có  dùng biến này ít nhất 2 lần trở lên
        WebElement fullNameTextBox = driver.findElement(By.id(""));
        fullNameTextBox.clear();
        fullNameTextBox.getAttribute("");

        // Trả về nhiều element khớp với điều kiện
        List<WebElement> textboxes = driver.findElements(By.cssSelector("")); // Java Generic: ràng buộc kiểu dữ liệu

        // Verify 1 checkbox/ radio/ dropdown đã được chọn hay chưa
        Assert.assertTrue(driver.findElement(By.id("")).isSelected());//*

        // Dùng để verify 1 element bất kì có hiển thị hay không
        Assert.assertTrue(driver.findElement(By.id("")).isDisplayed());//**

        // Dùng để verify 1 element có được thao tác lên hay không (không phải read-only)
        Assert.assertTrue(driver.findElement(By.id("")).isEnabled());//*

        // HTML Element
        driver.findElement(By.id("")).getAttribute("title");//*

        // Tab Accessibility/Properties trong Element
        driver.findElement(By.id("")).getAccessibleName();//*
        driver.findElement(By.id("")).getDomProperty("");//*
        driver.findElement(By.id("")).getAttribute("");//*

        // Tab Styles trong Element (font, color,...)
        driver.findElement(By.id("")).getCssValue("");//*

        //Vị trí của element so với độ phân giải màn hình
        Point nameTextboxLocation = driver.findElement(By.id("")).getLocation();

        //Location + Size
        driver.findElement(By.id("")).getRect();

        //Shadow element
        driver.findElement(By.id("")).getShadowRoot();

        // Chiều cao và rộng
        Dimension adddressSize = driver.findElement(By.id("")).getSize();

        // Dropdown (default/ custom)
        Select select = new Select(driver.findElement(By.id("")));

        // Từ id/ clas/ name/ css/ xpath có thể truy  ra ngược lại tagname HTML
        driver.findElement(By.id("")).getTagName();

        driver.findElement(By.id("")).getText();//**

        // Chụp hình và lưu dưới dạng Byte hoặc Base64
        driver.findElement(By.id("")).getScreenshotAs(OutputType.BASE64); // Dạng text //*
        driver.findElement(By.id("")).getScreenshotAs(OutputType.FILE); // file trong ổ cứng //*
        driver.findElement(By.id("")).getScreenshotAs(OutputType.BYTES); //*

        //Form (element nào là thẻ form hoặc nằm trong thẻ form) -> hành vi giống phím enter
        //Register/Login/Search
        driver.findElement(By.id("")).submit();

        // Java non Generic: không ràng buộc kiểu dữ liệu
        ArrayList name = new ArrayList();
        name.add("a");
        name.add(16);


    }
}
