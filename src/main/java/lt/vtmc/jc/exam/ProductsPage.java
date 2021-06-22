package lt.vtmc.jc.exam;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ProductsPage {
    private final ElementsCollection productElements = $$(".product-thumb h4 a");
    private final SelenideElement productAvailabilityString = $x("//li[text()[contains(.,'Availability')]]");
    private final SelenideElement productNameInsideCard = $("#content h1");

    //getters
    public ElementsCollection getProductElements() {
        return productElements;
    }

    public SelenideElement getProductAvailabilityString() {
        return productAvailabilityString;
    }

    public SelenideElement getProductNameInsideCard() {
        return productNameInsideCard;
    }
}
