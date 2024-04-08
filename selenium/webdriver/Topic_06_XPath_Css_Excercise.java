package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_06_XPath_Css_Excercise {
    WebDriver driver;

    @Test
    public void Register_01_Emty_Data() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Action
        driver.findElement(By.id("txtFirstname")).clear();
        driver.findElement(By.id("txtEmail")).clear();
        driver.findElement(By.id("txtCEmail")).clear();
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtCPassword")).clear();
        driver.findElement(By.id("txtPhone")).clear();
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        //Verify
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");

        driver.quit();
    }

    @Test
    public void Register_02_Invalid_Email_Address() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Action
        driver.findElement(By.id("txtFirstname")).sendKeys("Jake");
        driver.findElement(By.id("txtEmail")).sendKeys("Invalid@@@");
        driver.findElement(By.id("txtCEmail")).sendKeys("Invalid@@@");
        driver.findElement(By.id("txtPassword")).sendKeys("12345678");
        driver.findElement(By.id("txtCPassword")).sendKeys("12345678");
        driver.findElement(By.id("txtPhone")).sendKeys("0388031618");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        //Verify

        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúngTopic_06_XPath_Css_Excercise");
        driver.quit();
    }

    @Test
    public void Register_03_Invalid_Confirm_Email_Address() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Action
        driver.findElement(By.id("txtFirstname")).sendKeys("Jake");
        driver.findElement(By.id("txtEmail")).sendKeys("reusmarco0706@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("Invalid@@@");
        driver.findElement(By.id("txtPassword")).sendKeys("12345678");
        driver.findElement(By.id("txtCPassword")).sendKeys("12345678");
        driver.findElement(By.id("txtPhone")).sendKeys("0388031618");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        //Verify

        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
        driver.quit();
    }

    @Test
    public void Register_04_Password_Invalid_SmallerThan_6characters() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Action
        driver.findElement(By.id("txtFirstname")).sendKeys("Jake");
        driver.findElement(By.id("txtEmail")).sendKeys("reusmarco0706@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("reusmarco0706@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123");
        driver.findElement(By.id("txtCPassword")).sendKeys("123");
        driver.findElement(By.id("txtPhone")).sendKeys("0388031618");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        //Verify
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
        driver.quit();
    }

    @Test
    public void Register_05_Password_Invalid() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Action
        driver.findElement(By.id("txtFirstname")).sendKeys("Jake");
        driver.findElement(By.id("txtEmail")).sendKeys("reusmarco0706@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("reusmarco0706@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("12345678");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.id("txtPhone")).sendKeys("0388031618");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        //Verify
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
        driver.quit();
    }

    @Test
    public void Register_06_Invalid_Phone_Number() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");

        //Action
        driver.findElement(By.id("txtFirstname")).sendKeys("Jake");
        driver.findElement(By.id("txtEmail")).sendKeys("reusmarco0706@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("reusmarco0706@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.id("txtPhone")).sendKeys("038803161");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        //Verify
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");

        //Action
        driver.findElement(By.id("txtFirstname")).clear();
        driver.findElement(By.id("txtEmail")).clear();
        driver.findElement(By.id("txtCEmail")).clear();
        driver.findElement(By.id("txtPassword")).clear();
        driver.findElement(By.id("txtCPassword")).clear();
        driver.findElement(By.id("txtPhone")).clear();

        //Action
        driver.findElement(By.id("txtFirstname")).sendKeys("Jake");
        driver.findElement(By.id("txtEmail")).sendKeys("reusmarco0706@gmail.com");
        driver.findElement(By.id("txtCEmail")).sendKeys("reusmarco0706@gmail.com");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("txtCPassword")).sendKeys("123456");
        driver.findElement(By.id("txtPhone")).sendKeys("123");
        driver.findElement(By.xpath("//button[text()='ĐĂNG KÝ' and @type='submit']")).click();

        //Verify
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
        driver.quit();

    }
}
