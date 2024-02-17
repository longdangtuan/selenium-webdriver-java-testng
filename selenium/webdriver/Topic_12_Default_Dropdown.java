package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Topic_12_Default_Dropdown {
    WebDriver driver;
    String firstName = "Long", lastName = "Dang", emailAddress = getEmailAddress(), password = "Bvb_1909";
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demo.nopcommerce.com/");

    }

    @Test
    public void TC_01_Register()  {
        // Register


        driver.findElement(By.cssSelector("a.ico-register")).click();
        driver.findElement(By.cssSelector("input#gender-male")).click();
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#LastName")).sendKeys(lastName);

        new Select(driver.findElement(By.name("DateOfBirthDay"))).selectByVisibleText("1");
        // Verify số lượng item trong dropdown
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getOptions().size(),32);
        // Verify dropdown là single
        Assert.assertFalse(new Select(driver.findElement(By.name("DateOfBirthDay"))).isMultiple());
        new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText("May");
        // Verify số lượng item trong dropdown
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getOptions().size(),13);
        new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText("1980");
        // Verify số lượng item trong dropdown
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getOptions().size(),112);

        driver.findElement(By.id("Email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(password);
        driver.findElement(By.id("register-button")).click();
        sleepInSeconds(3);

       Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(),"Your registration completed");
        // Login
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector("a.ico-login")).click();
        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("button.login-button")).click();
        sleepInSeconds(3);
       // Verify
       driver.findElement(By.cssSelector("a.ico-account")).click();
       sleepInSeconds(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"), lastName);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(),"1");


        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"), emailAddress);

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
    public String getEmailAddress(){
        Random random = new Random();
        return  "Bvb" + random.nextInt() + "@gmail.com";
    }
}
