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
        navigation.clickTabletsMenu();
    }

    @Test
    public void tabletsExists() {
        products.getProductElements().shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    @Test
    public void checkTabletsAvailability() throws CustomException {
        //file reading not implemented yet
        String tabletsExceptionString = "";
        for (int i = 0; products.getProductElements().size() > i; i++) {
            products.getProductElements().get(i).click();
            if (!products.getProductAvailabilityString().getText().equals("Availability: In Stock")) {
                tabletsExceptionString += "\nSkiltyje Tablets prekės " + products.getProductNameInsideCard().getText() + " pasiekiamumas yra \"" + products.getProductAvailabilityString().getText().replace("Availability: ", "") + "\", ";
            }
            navigation.clickTabletsMenu();
        }
        if (tabletsExceptionString.length() > 1) {
            throw new CustomException(tabletsExceptionString);
        }
    }
}
