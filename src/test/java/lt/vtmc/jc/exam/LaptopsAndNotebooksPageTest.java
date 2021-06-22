package lt.vtmc.jc.exam;

import com.codeborne.selenide.CollectionCondition;
import org.junit.Before;
import org.junit.Test;

public class LaptopsAndNotebooksPageTest {
    NavigationPage navigation = new NavigationPage();
    ProductsPage products = new ProductsPage();

    @Before
    public void setupMainPage() {
        navigation.openMainPage();
    }

    @Test
    public void laptopsAndNotebooksExists() {
        navigation.clickLaptopsAndNotebooksMenu();
        navigation.clickAllLaptopsAndNotebooksMenu();
        products.getProductElements().shouldHave(CollectionCondition.sizeGreaterThan(0));
//        System.out.println(products.getProductNames().get(0).getText());
    }
}
