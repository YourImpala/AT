package ru.sberbank.ex2.steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import ru.sberbank.ex2.GeneralMethods;
import ru.sberbank.ex2.pageObjects.TravelInsurancePage;

public class TravelIsuranceSteps {

    private WebDriver driver;
    private TravelInsurancePage travelInsurancePage;

    public TravelIsuranceSteps(WebDriver driver) {
        this.driver = driver;
        this.travelInsurancePage = new TravelInsurancePage(driver);
    }

    @Step("Наличие на странице заголовка – {titleText}")
    public void checkTitle(String titleText) {
        if(travelInsurancePage.checkTravelInsuranceTitle(titleText)) {
            Assertions.assertTrue(true);
        } else {
            GeneralMethods.getScreenshot(driver);
            Assertions.assertTrue(false, "Заголовок - " + titleText + " не найден");
        }
    }

    @Step("Нажать кнопку 'Оформить онлайн'")
    public void clickIssueOnlineButton() {
        travelInsurancePage.clickIssueOnlineButton();
    }
}
