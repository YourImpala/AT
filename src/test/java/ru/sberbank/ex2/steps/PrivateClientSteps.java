package ru.sberbank.ex2.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.sberbank.ex2.pageObjects.PrivateClientPage;

public class PrivateClientSteps {

    private PrivateClientPage privateClientPage;

    public PrivateClientSteps(WebDriver driver) {
        this.privateClientPage = new PrivateClientPage(driver);
    }

    @Step("Нажать '{menuItem}' в меню навигации")
    public void selectInNavigationMenu(String menuItem) {
        privateClientPage.clickInNavigation(menuItem);
    }

    @Step("Нахать '{dropDownMenuItem}' в выпадающем меню")
    public void selectInDropdownMenu(String dropDownMenuItem) {
        privateClientPage.clickDropdownLink(dropDownMenuItem);
    }
}
