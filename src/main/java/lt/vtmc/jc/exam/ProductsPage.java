package lt.vtmc.jc.exam;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.*;

public class ProductsPage {
    private final ElementsCollection productElements = $$(".product-thumb h4 a");

    //navigating trough URLS


    //filling and clearing


    //clicks


    //getters
    public ElementsCollection getProductElements() {
        return productElements;
    }
}
