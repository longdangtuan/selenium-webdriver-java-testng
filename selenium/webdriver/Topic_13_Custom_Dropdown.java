package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_13_Custom_Dropdown {
    WebDriver driver;
    // Tường minh: trạng thái cụ thể cho element
    // Visible//Invisible/Presence/Number/Clickable/...
    WebDriverWait explicitWait;


    String firstName = "Long", lastName = "Dang", emailAddress = getEmailAddress(), password = "Bvb_1909";

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // ngầm định: không rõ ràng cho 1 trạng thái cụ thể nào của element
        // ngầm định cho việc tìm elements - Find Element(s)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }

    @Test
    public void TC_01_Jquery() {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        // Click vào 1 thẻ để nó xổ hết các item bên trong dropdown ra
        /*driver.findElement(By.cssSelector("span#number-button")).click();
        // 2.1 Nó sẽ xổ ra chứa hết tất cả các item
        // 2.2 Nó sẽ xổ ra nhưng chỉ chữa 1 phần và đang load thêm
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu div")));  // Xuất hiện đầy đủ trong HTML
        List<WebElement> allItems = driver.findElements(By.cssSelector("ul#number-menu div")); // Đang lưu trữ các item bên trong
        // Kiểm tra text của từng item rồi click vào
        for (WebElement item: allItems){
            String textItem = item.getText();
            if(textItem.equals("8")){
                item.click();
                break; // 9 -> 19 không được kiểm tra
            }
        }*/
        selectItemInDropDown("span#number-button", "ul#number-menu div", "10");
        // 3.1 Nếu như item cần chọn nó hiển thị thì click vào
        // 3.2 Nếu như item càn chọn nằm bên dưới thì 1 số trường hợp cần scroll xuống để hiển thị lên rồi mới chọn (Angular/ React/ Vuejs/,,,)
        // 4 Trước khi click cần kiểm tra nếu như text của item bằng với item cần chọn thì click vào


    }

    @Test
    public void TC_02_React() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
        selectItemInDropDown("i.dropdown.icon", "div.item>span.text", "Christian");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Christian");
        sleepInSeconds(3);

    }

    @Test
    public void TC_03_Vuejs() {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");
        selectItemInDropDown("li.dropdown-toggle", "ul.dropdown-menu a", "Second Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Second Option");
        sleepInSeconds(3);

    }

    @Test
    public void TC_04_Editable_Dropdown() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
        selectItemInEditableDropDown("input.search", "div.item span", "Algeria");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Algeria");
        sleepInSeconds(3);

    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSeconds(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public String getEmailAddress() {
        Random random = new Random();
        return "Bvb" + random.nextInt() + "@gmail.com";
    }

    // Những dữ liệu dùng để truyền vào xem là tham số
    public void selectItemInDropDown(String parentCss, String childCss, String itemTextExpected) {
        driver.findElement(By.cssSelector(parentCss)).click();
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
        for (WebElement item : allItems) {
            String textItem = item.getText();
            if (textItem.equals(itemTextExpected)) {
                item.click();
                break;
            }
        }
    }

    public void selectItemInEditableDropDown(String parentCss, String childCss, String itemTextExpected) {
        driver.findElement(By.cssSelector(parentCss)).clear();
        driver.findElement(By.cssSelector(parentCss)).sendKeys(itemTextExpected);
        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childCss)));
        for (WebElement item : allItems) {
            String textItem = item.getText();
            if (textItem.equals(itemTextExpected)) {
                item.click();
                break;
            }
        }
    }
}
