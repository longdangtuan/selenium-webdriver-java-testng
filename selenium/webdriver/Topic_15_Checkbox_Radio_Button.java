package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class Topic_15_Checkbox_Radio_Button {
    WebDriver driver;
   // Tường minh: trạng thái cụ thể cho element
    // Visible//Invisible/Presence/Number/Clickable/...
    WebDriverWait explicitWait;


    String firstName = "Long", lastName = "Dang", emailAddress = getEmailAddress(), password = "Bvb_1909";
    @BeforeClass
    public void beforeClass(){
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // ngầm định: không rõ ràng cho 1 trạng thái cụ thể nào của element
        // ngầm định cho việc tìm elements - Find Element(s)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }

    @Test
    public void TC_01_Fahasa_Button()  {
        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();

        WebElement loginButton = driver.findElement(By.cssSelector("button.fhs-btn-login"));

        // Verify login button is disabled
        Assert.assertFalse(loginButton.isEnabled());

        // Verify login button background

        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(),"#000000");

        // Nhập email/password
        driver.findElement(By.cssSelector("input#login_username")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#login_password")).sendKeys(password);

        //Verify đăng nhập button enabled
        Assert.assertTrue(loginButton.isEnabled());

        //Verfiy đăng nhập button background
        System.out.println(loginButton.getCssValue("background-color"));
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(),"#c92127");



    }
    @Test
    public void TC_02_Select_All_Checkboxes_Select_One_In_All()  {
        driver.get("https://automationfc.github.io/multiple-fields/");
        List <WebElement> allCheckboxes = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));
        // Chọn hết các checkbox trong màn hình
        for (WebElement checkbox: allCheckboxes){
            if (!checkbox.isSelected()){
                checkbox.click();

            }
        }

        // Verify hết taast cả các checkbox
        for (WebElement checkbox: allCheckboxes){
            Assert.assertTrue(checkbox.isSelected());
        }
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        allCheckboxes = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));
        // Chọn 1 checkbox/radio trong các checkbox
        for (WebElement checkbox: allCheckboxes){
            if (checkbox.getAttribute("value").equals("Heart Attack") && !checkbox.isSelected()){
                checkbox.click();
                sleepInSeconds(1);
            }
        }


    }

    @Test
    public void TC_06_Custom_Checkbox_Radio_Button()  {
    driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
    // Verify button is not selected
        Assert.assertFalse(driver.findElement(By.xpath("//div[@data-value='Cần Thơ']/parent::div")).isSelected());

    // Click button
        WebElement CanThoRadioButton = driver.findElement(By.xpath("//div[@data-value='Cần Thơ']/parent::div"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()",CanThoRadioButton);
        sleepInSeconds(1);

        // Verify button is selected
        Assert.assertTrue(CanThoRadioButton.isSelected());
//driver.findElement(By.xpath("//div[@data-value='Cần Thơ']/parent::div")).click();

    }

    @Test
    public void TC_04_Editable_Dropdown()  {


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
       // Những dữ liệu dùng để truyền vào xem là tham số
    public void selectItemInDropDown (String parentCss, String childCss, String itemTextExpected){
        driver.findElement(By.cssSelector(parentCss)).click();
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
        for (WebElement item: allItems){
            String textItem = item.getText();
            if(textItem.equals(itemTextExpected)){
                item.click();
                break;
            }
        }
    }

    public void selectItemInEditableDropDown (String parentCss, String childCss, String itemTextExpected){
        driver.findElement(By.cssSelector(parentCss)).clear();
        driver.findElement(By.cssSelector(parentCss)).sendKeys(itemTextExpected);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
        for (WebElement item: allItems){
            String textItem = item.getText();
            if(textItem.equals(itemTextExpected)){
                item.click();
                break;
            }
        }
    }
}
