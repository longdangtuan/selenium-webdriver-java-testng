package category;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Category_02_EditCategory {
    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        System.out.println("beforeClass");
    }

    @Test(groups = "category")
    public void testEditCategoryEmty1(){
        System.out.println("emty1");
    }

    @Test(groups = "category", priority = 2, description = "This is a description")
    public void testEditCategoryEmty2(){
        System.out.println("emty2");
    }

    @Test(groups = "category",priority = 1)
    public void testEditCategoryEmty3(){
        System.out.println("emty3");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass");
    }
}
