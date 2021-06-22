package lt.vtmc.jc.exam;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class MainPageTest {

    NavigationPage navigation = new NavigationPage();

    @Before
    public void setupMainPage() {
        navigation.openMainPage();
    }

    @Test
    public void mainPageIsValid() {
        Assert.assertTrue(Selenide.title().equals("Your Store"));
        Assert.assertTrue(navigation.getMenu().isDisplayed());
    }
}
