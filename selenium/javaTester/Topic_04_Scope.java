package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_04_Scope {
    // các biến được khai baáo been ngoài hàm -> phajm vi là Class
    // Biến Global (toàn cujc)
    // C thể dùng cho taast cả các hàm ở trong 1 Class
WebDriver driver; // khai báo: Declare
    String fullName = "ABC"; // khai báo + khởi tạo (Initial)
@Test
    public void TC_01 (){
    // Các biến được khai báoở trong 1 hàm/block code -> phạm vi cục bộ (local)
    // Dùng trong cai hàm nó được khai báo / block code được sinh ra
    // Trong 1 hàm nếu như c 2 biến cng teen  (Global/Local) thì sẽ ưu tiên lấy biến local uufng
    // 1 bieesn Local nếu như gọi toới dùng mà chưa đc khởi tạo sẽ b lỗi
    // Biến local chưa khởi tạo mà gọi ra dùng sẽ báo lỗi ngay (compile code)
    driver = new FirefoxDriver();
    String homepageUrl = "https://www.facebook.com/";
    driver.get(homepageUrl);

   // Trong 1 hàm nếu như c 2 biến cng teen  (Global/Local) nếu muốn lấy bến Global ra để dùng thì dùng tu khóa this
    // Biến global chưa khởi tạo mà gọi ra dùng thì chưa báo loix ở level (compile code)
    // level runtime sẽ lỗi
    driver.get(this.fullName);


}


}
