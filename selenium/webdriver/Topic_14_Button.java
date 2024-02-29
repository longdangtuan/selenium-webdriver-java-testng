package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_14_Button {
    WebDriver driver;
   // Tường minh: trạng thái cụ thể cho element
    // Visible//Invisible/Presence/Number/Clickable/...
    WebDriverWait explicitWait;


    String firstName = "Long", lastName = "Dang", emailAddress = getEmailAddress(), password = "Bvb_1909";
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }

    @Test
    public void TC_01_Default_Telerik_Checkbox_Radio()  {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input");
        // Click vào checkbox
        // Case 1: Nếu mở app ra mà checkbox được chọn rồi
        // Case 2: Nếu mở app ra mà checkbox chưa được chọn
        checkToElement(dualZoneCheckbox);

        // Verify if element is selected
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());

        //uncheck
        uncheckToElement(dualZoneCheckbox);

        //Verify if element is not selected
        Assert.assertFalse(driver.findElement(dualZoneCheckbox).isSelected());

        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        By petrolRadio147 = By.xpath("//label[text()='2.0 Petrol, 147kW']//preceding-sibling::input");
        checkToElement(petrolRadio147);

        //Verify
        Assert.assertTrue(driver.findElement(petrolRadio147).isSelected());

    }

    @Test
    public void TC_02_Select_All()  {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");


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

    public void checkToElement(By byXpath){
        // Nếu như element chưa được chọn thì mới click
        if (!driver.findElement(byXpath).isSelected()){
            driver.findElement(byXpath).click();
            sleepInSeconds(2);
        }
    }

    public void uncheckToElement(By byXpath){
        // Nếu như element chưa được chọn thì mới click
        if (driver.findElement(byXpath).isSelected()){
            driver.findElement(byXpath).click();
            sleepInSeconds(2);
        }
    }
}
