package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_05_Assert {
WebDriver driver;
    @Test
    public void verfyTestNG(){
        driver = new FirefoxDriver();
        driver.get("hhtps://www.facebook.com/");
        // Trong Java có nhieu thư viện để verify dữ liệu
        // Testing Framework (Unit/ Intergration/ UI automation test
        // JUnit4/ TestNG/ JUnit 5/ Hamcrest/ AssertJ

        // Kiểu dữ liệu nhận vào  là boolean (true/false)
        // Khi mong muoosn điều kieejn trả về là đúng thì dùng assertTrue để verify
        Assert.assertTrue(driver.getPageSource().contains("Facebook helps you connect and share with people in your life."));
        // Mong muoosn trả veef là sai thif dùng assertFalse
        // Các hàm trar veef kiểu dữ lieeku là boolean thì dùng
        // Quy tắc: bawst đầu vói tiền tố là isXXX
        // WebElement

        driver.findElement(By.id("")).isDisplayed();
        // Mong đợi 1 điều kiện gioosng thực tees ( Actual = Expected )
        Assert.assertEquals(driver.getCurrentUrl(),"https://facebook.com/");
        // Unit Test
        Object name = null;
        Assert.assertNull(name);
    }
}
