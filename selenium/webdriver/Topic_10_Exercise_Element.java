package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_10_Exercise_Element {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void TC_01_isDisplayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.name("user_email")).isDisplayed()) {
            driver.findElement(By.name("user_email")).sendKeys("Automation Testing");
            System.out.println("Email is displayed");
        } else {
            System.out.println("Email is not displayed");
        }

        if (driver.findElement(By.xpath("//input[@id='under_18']")).isDisplayed()) {
            driver.findElement(By.xpath("//input[@id='under_18']")).click();
            System.out.println("Under 18 button is displayed");
        } else {
            System.out.println("Under 18 button is not displayed");
        }

        if (driver.findElement(By.xpath("//textarea[@id='edu']")).isDisplayed()) {
            driver.findElement(By.xpath("//textarea[@id='edu']")).sendKeys("Automation Testing");
            System.out.println("Education is displayed");
        } else {
            System.out.println("Education is not displayed");
        }

        if (driver.findElement(By.xpath("//h5[text()='Name: User1']")).isDisplayed()) {
            System.out.println("User1 is displayed");
        } else {
            System.out.println("User1 is not displayed");
        }

    }


    @Test
    public void TC_02_isEnabled() {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        if (driver.findElement(By.name("user_email")).isEnabled()) {
            System.out.println("Email is enabled");
        } else {
            System.out.println("Email is disabled");
        }

        if (driver.findElement(By.xpath("//input[@id='under_18']")).isEnabled()) {
            System.out.println("Under 18 button is enabled");
        } else {
            System.out.println("Under 18 button is disabled");
        }

        if (driver.findElement(By.xpath("//textarea[@id='edu']")).isEnabled()) {
            System.out.println("Education is enabled");
        } else {
            System.out.println("Education is disabled");
        }

        if (driver.findElement(By.name("user_job1")).isEnabled()) {
            System.out.println("Job Role 1 is enabled");
        } else {
            System.out.println("Job Role 1 is disabled");
        }

        if (driver.findElement(By.name("user_job2")).isEnabled()) {
            System.out.println("Job Role 2 is enabled");
        } else {
            System.out.println("Job Role 2 is disabled");
        }

        if (driver.findElement(By.cssSelector("input#development")).isEnabled()) {
            System.out.println("Development Interest is enabled");
        } else {
            System.out.println("Development Interest is disabled");
        }

        if (driver.findElement(By.name("slider-1")).isEnabled()) {
            System.out.println("Slider 01 is enabled");
        } else {
            System.out.println("Slider 01 is disabled");
        }

        if (driver.findElement(By.cssSelector("input#disable_password")).isEnabled()) {
            System.out.println("Password is enabled");
        } else {
            System.out.println("Password is disabled");
        }

        if (driver.findElement(By.cssSelector("input#radio-disabled")).isEnabled()) {
            System.out.println("Radio button is enabled");
        } else {
            System.out.println("Radio button is disabled");
        }

        if (driver.findElement(By.cssSelector("textarea#bio")).isEnabled()) {
            System.out.println("Bio is enabled");
        } else {
            System.out.println("Bio is disabled");
        }

        if (driver.findElement(By.cssSelector("select#job3")).isEnabled()) {
            System.out.println("Job 03 is enabled");
        } else {
            System.out.println("Job 03 is disabled");
        }

        if (driver.findElement(By.cssSelector("input#check-disbaled")).isEnabled()) {
            System.out.println("Interest Checkbox is enabled");
        } else {
            System.out.println("Interest Checkbox is disabled");
        }

        if (driver.findElement(By.cssSelector("input#slider-2")).isEnabled()) {
            System.out.println("Slider 02 is enabled");
        } else {
            System.out.println("Slider 02 is disabled");
        }
    }

    @Test
    public void TC_03_isSelected() {

        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.id("under_18")).click();
        driver.findElement(By.name("java")).click();

        Assert.assertTrue(driver.findElement(By.id("under_18")).isSelected());
        Assert.assertTrue(driver.findElement(By.name("java")).isSelected());

        driver.findElement(By.name("java")).click();
        Assert.assertFalse(driver.findElement(By.name("java")).isSelected());

    }

    @Test
    public void TC_04_MailChimp() {
        driver.get("https://login.mailchimp.com/signup/");
        driver.findElement(By.id("email")).sendKeys("Reusmarco0706@gmail.com");


        // Case 1
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("12345");
        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // CAse 6 - Valid
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("12345qW@1");
        Assert.assertFalse(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());
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
