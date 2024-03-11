package webdriver;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Topic_17_Action {
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
    public void TC_01_Hover_To_Element_Tooltip()  {
driver.get("https://automationfc.github.io/jquery-tooltip/");
        WebElement ageTextbox = driver.findElement(By.cssSelector("input#age"));

        actions.moveToElement(ageTextbox).perform();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(),"We ask for your age only for statistical purposes.");

    }
    @Test
    public void TC_03_Hover_Menu()  {
driver.get("https://www.fahasa.com/");

actions.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
actions.moveToElement(driver.findElement(By.xpath("//a[@title='Bách Hóa Online - Lưu Niệm']"))).perform();

driver.findElement(By.xpath("//div[contains(@class,'fhs_menu_content')]//a[text()='Thiết Bị Số - Phụ Kiện Số']")).click();
sleepInSeconds(2);

Assert.assertEquals(driver.findElement(By.cssSelector("ol.breadcrumb strong")).getText(), "THIẾT BỊ SỐ - PHỤ KIỆN SỐ");
Assert.assertTrue(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text()='Thiết Bị Số - Phụ Kiện Số']")).isDisplayed());

    }

    @Test
    public void TC_04_Click_And_Hold()  {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        // Tống số chưa chọn
        List<WebElement> allNumbers = driver.findElements(By.cssSelector("li.ui-state-default"));
        Assert.assertEquals(allNumbers.size(),20);

        // Chọn theo Block - Ngang/Dọc
        // Chọn từ 1 -> 15
        actions.clickAndHold(allNumbers.get(0))// Click lên số 1 và giữ chuột
                .moveToElement(allNumbers.get(14)) // Di chuột đến số 15
                .release() // nhả chuột
                .perform(); // thực hiện các hành động trên

        List<String> allNumberTextExpected = new ArrayList<String>();
        allNumberTextExpected.add("1");
        allNumberTextExpected.add("2");
        allNumberTextExpected.add("3");
        allNumberTextExpected.add("5");
        allNumberTextExpected.add("6");
        allNumberTextExpected.add("7");
        allNumberTextExpected.add("9");
        allNumberTextExpected.add("10");
        allNumberTextExpected.add("11");
        allNumberTextExpected.add("13");
        allNumberTextExpected.add("14");
        allNumberTextExpected.add("15");

        // Tổng các số đã chọn
        List<WebElement> allNumbersSelected = driver.findElements(By.cssSelector("li.ui-state-default.ui-selected"));
        Assert.assertEquals(allNumbersSelected.size(), 12);

        List<String> allNumberTextActual = new ArrayList<String>();

        for (WebElement element : allNumbersSelected){
            allNumberTextActual.add(element.getText());
        }

        Assert.assertEquals(allNumberTextExpected, allNumberTextActual);



    }


    @Test
    public void TC_06_Double_Click()  {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        WebElement doubleClickButton = driver.findElement(By.xpath("//button[text()='Double click me']"));
        // Cần scroll tới element rồi mới click (Firefox)
        if (driver.toString().contains("firefox")){
            // scrollIntoView(true): kéo mép trên của element lên phía trên cùng của viewport
            // scrollIntoView(false): kéo mép dưới của element xuống phía dưới cùng của viewport
            javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", doubleClickButton);
        }

        actions.doubleClick(doubleClickButton).perform();
        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(),"Hello Automation Guys!" );
    }

    @Test
    public void TC_07_Right_Click()  {
driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
actions.contextClick(driver.findElement(By.cssSelector("span.context-menu-one"))).perform();
// Verify Quit Menu is displayed
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());

        // Hover to quit element
        actions.moveToElement(driver.findElement(By.cssSelector("li.context-menu-icon-quit"))).perform();
        // Verify quit element visible + hover
        Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit.context-menu-hover.context-menu-visible")).isDisplayed());
        // Click on quit and verify menu is not displayed
        actions.click(driver.findElement(By.cssSelector("li.context-menu-icon-quit"))).perform();
        driver.switchTo().alert().accept();
        sleepInSeconds(2);
        Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());

    }

    @Test
    public void TC_08_DragDropHTML4(){
driver.get("https://automationfc.github.io/kendo-drag-drop/");

WebElement smallCircle = driver.findElement(By.cssSelector("div#draggable"));
WebElement bigCircle = driver.findElement(By.cssSelector("div#droptarget"));


actions.dragAndDrop(smallCircle,bigCircle).perform();
Assert.assertEquals(bigCircle.getText(),"You did great!");
    }

    @Test
    public void TC_08_DragDropHTML5_Css(){

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


}
