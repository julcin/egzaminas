package lt.vtmc.jc.exam;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class NavigationPage {
    private final SelenideElement menu = $("#menu");
    private final SelenideElement laptopsAndNotebooksMenu = $x("//a[normalize-space()='Laptops & Notebooks']");
    private final SelenideElement allLaptopsAndNotebooksMenu = $x("//a[normalize-space()='Show All Laptops & Notebooks']");
    private final SelenideElement tabletsMenu = $x("//a[normalize-space()='Tablets']");
    private final SelenideElement phonesAndPDAsMenu = $x("//a[normalize-space()='Phones & PDAs']");
    private final SelenideElement camerasMenu = $x("//a[normalize-space()='Cameras']");
    private final SelenideElement mp3PlayersMenu = $x("//a[normalize-space()='MP3 Players']");
    private final SelenideElement allMP3PlayersMenu = $x("//a[normalize-space()='Show All MP3 Players']");

    //navigating
    public void openMainPage() {
        open("https://demo.opencart.com/");
    }

    public void openLaptopsPage() {
        clickLaptopsAndNotebooksMenu();
        clickAllLaptopsAndNotebooksMenu();
    }

    public void openMp3Page() {
        clickMP3PlayersMenu();
        clickAllMP3PlayersMenu();
    }

    //clicks
    public void clickLaptopsAndNotebooksMenu() {
        laptopsAndNotebooksMenu.click();
    }

    public void clickAllLaptopsAndNotebooksMenu() {
        allLaptopsAndNotebooksMenu.click();
    }

    public void clickTabletsMenu() {
        tabletsMenu.click();
    }

    public void clickPhonesAndPDAsMenu() {
        phonesAndPDAsMenu.click();
    }

    public void clickCamerasMenu() {
        camerasMenu.click();
    }

    public void clickMP3PlayersMenu() {
        mp3PlayersMenu.click();
    }

    public void clickAllMP3PlayersMenu() {
        allMP3PlayersMenu.click();
    }

    //getters
    public SelenideElement getMenu() {
        return menu;
    }
}
