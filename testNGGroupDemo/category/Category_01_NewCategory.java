package category;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Category_01_NewCategory {
    WebDriver driver;

    @Test
    public void testCreateNewCategoryEmty(){
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.quit();
    }

    @Test
    public void testCreateNewCategory(){
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");
        driver.quit();
    }
}
