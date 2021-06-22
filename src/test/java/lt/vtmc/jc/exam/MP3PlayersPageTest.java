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
        navigation.openMp3Page();
    }

    @Test
    public void mp3PlayersExists() {
        products.getProductElements().shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    @Test
    public void checkMp3Availability() throws CustomException {
        //file reading not implemented yet
        String mp3ExceptionString = "";
        for (int i = 0; products.getProductElements().size() > i; i++) {
            products.getProductElements().get(i).click();
            if (!products.getProductAvailabilityString().getText().equals("Availability: In Stock")) {
                mp3ExceptionString += "\nSkiltyje Mp3 Players prekės " + products.getProductNameInsideCard().getText() + " pasiekiamumas yra \"" + products.getProductAvailabilityString().getText().replace("Availability: ", "") + "\", ";
            }
            navigation.openMp3Page();
        }
        if (mp3ExceptionString.length() > 1) {
            throw new CustomException(mp3ExceptionString);
        }
    }
}
