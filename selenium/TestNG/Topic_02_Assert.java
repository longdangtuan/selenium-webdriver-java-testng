package TestNG;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_02_Assert {
    WebDriver driver;
@Test
    public void test01(){
    // Equals = kiểm tra 2 dữ liệu bằng nhau
    String fullName = "Automation FC";
    Assert.assertEquals(fullName,"Automation FC");

    // True - False: Điều kiện nhận vào là boolean
    // Mong đơi kết quả trả về là đúng
}

}
