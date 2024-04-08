package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_20_Shadow_DOM {
    WebDriver driver;

    WebDriverWait explicitWait;
    Actions actions;
    JavascriptExecutor javascriptExecutor;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        actions = new Actions(driver);
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        javascriptExecutor = (JavascriptExecutor) driver;
        // ngầm định: không rõ ràng cho 1 trạng thái cụ thể nào của element
        // ngầm định cho việc tìm elements - Find Element(s)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }


    @Test
    public void TC_08_Shadow_DOM() {
        driver.get("https://automationfc.github.io/shadow-dom/");

        // Shadow DOM 1
        WebElement shadowHost = driver.findElement(By.cssSelector("div#shadow_host"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        String someText = shadowRoot.findElement(By.cssSelector("span#shadow_content>span")).getText();
        System.out.println(someText);
        Assert.assertEquals(someText, "some text");

        WebElement checkboxShadow = shadowRoot.findElement(By.cssSelector("input[type='checkbox']"));
        Assert.assertFalse(checkboxShadow.isSelected());


        // Shadow DOM 2
        WebElement nestedShadowHost = shadowRoot.findElement(By.cssSelector("div#nested_shadow_host"));
        SearchContext nestedShadowRoot = nestedShadowHost.getShadowRoot();

        String nestedText = nestedShadowRoot.findElement(By.cssSelector("div#nested_shadow_content>div")).getText();
        System.out.println(nestedText);
        Assert.assertEquals(nestedText, "nested text");
    }

    @Test
    public void TC_09_Shadow_DOM_Popup() {
        driver.get("https://shopee.vn");
        sleepInSeconds(3);
        WebElement shadowHost = driver.findElement(By.cssSelector("shopee-banner-popup-stateful"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        if (shadowRoot.findElement(By.cssSelector("div.home-popup")).isDisplayed()) { // Step 2: Nếu hiển thị
            System.out.println("Shadow DOM is displayed");
            shadowRoot.findElement(By.cssSelector("div.shopee-popup__close-btn")).click();
        }

        // Step 2: Nếu không hiển thị
        driver.findElement(By.cssSelector("div.shopee-searchbar-input")).sendKeys("iphone 15 Pro Max");
        driver.findElement(By.cssSelector("button.shopee-searchbar__search-button")).click();


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


}
