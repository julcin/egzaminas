package lt.vtmc.jc.exam;

import com.codeborne.selenide.CollectionCondition;
import org.junit.Before;
import org.junit.Test;

public class MP3PlayersPageTest {
    NavigationPage navigation = new NavigationPage();
    ProductsPage products = new ProductsPage();

    @Before
    public void setupMainPage() {
        navigation.openMainPage();
    }

    @Test
    public void mp3PlayersExists() {
        navigation.clickMP3PlayersMenu();
        navigation.clickAllMP3PlayersMenu();
        products.getProductElements().shouldHave(CollectionCondition.sizeGreaterThan(0));
    }
}
