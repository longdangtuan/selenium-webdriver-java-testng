package webdriver;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Headers;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class Topic_16_Handle_Alert {
    WebDriver driver;

    WebDriverWait explicitWait;

    By resultText = By.cssSelector("p#result");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // ngầm định: không rõ ràng cho 1 trạng thái cụ thể nào của element
        // ngầm định cho việc tìm elements - Find Element(s)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }

    @Test
    public void TC_07_Accept_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        // Chờ cho alert present
        // Nếu trong thời gian chờ mà xuất hiện thì tự swtich vào
        // Nếu hết thời gian chờ mà chưa xuất hiện thì fail
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        sleepInSeconds(3);

        Assert.assertEquals(alert.getText(), "I am a JS Alert");

        // Khi mình accept/cacnel rồi thì alert sẽ mất
        alert.accept();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(resultText).getText(), "You clicked an alert successfully");


    }

    @Test
    public void TC_08_Confirm_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "I am a JS Confirm");
        alert.dismiss();
        sleepInSeconds(3);
        Assert.assertEquals(driver.findElement(resultText).getText(), "You clicked: Cancel");


    }

    @Test
    public void TC_09_Promt_Alert() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(), "I am a JS prompt");
        alert.sendKeys("Kingohger");
        alert.accept();
        Assert.assertEquals(driver.findElement(resultText).getText(), "You entered: Kingohger");

    }

    @Test
    public void TC_11_Authentication_Alert_Pass_To_Url() {
        String username = "admin";
        String password = "admin";
        // Thư viện alert không dùng cho Authentication Alert được
        // Chrome Devtool Protocol (CDP) - Chrome/ Edge (Chromium)
        // Cách 1: Truyền user/pass vào Url
        driver.get("http://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth");
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());
        // Cách 2: Từ page A thao tác lên 1 element sẽ qua page B ( Cần phải thao tác voới Authen Alert trước )
        driver.get("http://the-internet.herokuapp.com/");
        String authenLinkURL = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");

        String[] authenArray = authenLinkURL.split("//");
        driver.get((authenArray[0] + "//" + username + ":" + password + "@" + authenArray[1]));
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());


    }

    @Test
    public void TC_12_Authentication_Alert_Selenium_4x() {
        // Get DevTool object
        DevTools devTools = ((HasDevTools) driver).getDevTools();

        // Start new session
        devTools.createSession();

        // Enable the Network domain of devtools
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Encode username/ password
        Map<String, Object> headers = new HashMap<String, Object>();
        String basicAuthen = "Basic " + new String(new Base64().encode(String.format("%s:%s", "admin", "admin").getBytes()));
        headers.put("Authorization", basicAuthen);

        // Set to Header
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

        driver.get("https://the-internet.herokuapp.com/basic_auth");
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
