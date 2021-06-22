package lt.vtmc.jc.exam;

import com.codeborne.selenide.CollectionCondition;
import org.junit.Before;
import org.junit.Test;

public class PhoneAndPDAsPageTest {
    NavigationPage navigation = new NavigationPage();
    ProductsPage products = new ProductsPage();

    @Before
    public void setupMainPage() {
        navigation.openMainPage();
        navigation.clickPhonesAndPDAsMenu();
    }

    @Test
    public void phonesAndPDAsExists() {
        products.getProductElements().shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    @Test
    public void checkPhonesAndPDAsAvailability() throws CustomException {
        //file reading not implemented yet
        String phonesExceptionString = "";
        for (int i = 0; products.getProductElements().size() > i; i++) {
            products.getProductElements().get(i).click();
            if (!products.getProductAvailabilityString().getText().equals("Availability: In Stock")) {
                phonesExceptionString += "\nSkiltyje Phones And PDAs prekės " + products.getProductNameInsideCard().getText() + " pasiekiamumas yra \"" + products.getProductAvailabilityString().getText().replace("Availability: ", "") + "\", ";
            }
            navigation.clickPhonesAndPDAsMenu();
        }
        if (phonesExceptionString.length() > 1) {
            throw new CustomException(phonesExceptionString);
        }
    }
}
