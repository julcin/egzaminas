package lt.vtmc.jc.exam;

import com.codeborne.selenide.CollectionCondition;
import org.junit.Before;
import org.junit.Test;

public class TabletsPageTest {
    NavigationPage navigation = new NavigationPage();
    ProductsPage products = new ProductsPage();

    @Before
    public void setupMainPage() {
        navigation.openMainPage();
    }

    @Test
    public void tabletsExists() {
        navigation.clickTabletsMenu();
        products.getProductElements().shouldHave(CollectionCondition.sizeGreaterThan(0));
    }
}
