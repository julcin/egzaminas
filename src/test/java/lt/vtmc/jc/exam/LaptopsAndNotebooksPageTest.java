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
        navigation.openLaptopsPage();
    }

    @Test
    public void laptopsAndNotebooksExists() {
        products.getProductElements().shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    @Test
    public void checkLaptopsAvailability() throws CustomException {
        //file reading not implemented yet
        String laptopsExceptionString = "";
        for (int i = 0; products.getProductElements().size() > i; i++) {
            products.getProductElements().get(i).click();
            if (!products.getProductAvailabilityString().getText().equals("Availability: In Stock")) {
                laptopsExceptionString += "\nSkiltyje Laptops and Notebooks prekės " + products.getProductNameInsideCard().getText() + " pasiekiamumas yra \"" + products.getProductAvailabilityString().getText().replace("Availability: ", "") + "\", ";
            }
            navigation.openLaptopsPage();
        }
        if (laptopsExceptionString.length() > 1) {
            throw new CustomException(laptopsExceptionString);
        }
    }
}
