package lt.vtmc.jc.exam;

import com.codeborne.selenide.CollectionCondition;
import org.junit.Before;
import org.junit.Test;

public class CamerasPageTest {
    NavigationPage navigation = new NavigationPage();
    ProductsPage products = new ProductsPage();

    @Before
    public void setupMainPage() {
        navigation.openMainPage();
        navigation.clickCamerasMenu();
    }

    @Test
    public void camerasExists() {
        products.getProductElements().shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    @Test
    public void checkCamerasAvailability() throws CustomException {
        //file reading not implemented yet
        String camerasExceptionString = "";
        for (int i = 0; products.getProductElements().size() > i; i++) {
            products.getProductElements().get(i).click();
            if (!products.getProductAvailabilityString().getText().equals("Availability: In Stock")) {
                camerasExceptionString += "\nSkiltyje Cameras prekės " + products.getProductNameInsideCard().getText() + " pasiekiamumas yra \"" + products.getProductAvailabilityString().getText().replace("Availability: ", "") + "\", ";
            }
            navigation.clickCamerasMenu();
        }
        if (camerasExceptionString.length() > 1) {
            throw new CustomException(camerasExceptionString);
        }
    }
}
