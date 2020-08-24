package ru.sberbank.ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.sberbank.ex2.pageObjects.PrivateClientPage;
import ru.sberbank.ex2.pageObjects.StoreTravelInsuranceFormPage;
import ru.sberbank.ex2.pageObjects.StoreTravelInsurancePage;
import ru.sberbank.ex2.pageObjects.TravelInsurancePage;
import ru.sberbank.ex2.settings.WebDriverSettings;

import java.util.HashMap;
import java.util.Map;

public class Tests extends WebDriverSettings {

    @Test
    public void insuranceTest() {
        driver.get(baseURL);

        PrivateClientPage privateClientPage = new PrivateClientPage(driver);
        privateClientPage.clickInNavigation("Страхование");
        privateClientPage.clickDropdownLink("Страхование путешественников");

        TravelInsurancePage travelInsurancePage = new TravelInsurancePage(driver);
        Assertions.assertTrue(
                travelInsurancePage.checkTravelInsuranceTitle("Страхование путешественников")
        );
        travelInsurancePage.clickIssueOnlineButton();

        StoreTravelInsurancePage storeTravelInsurancePage = new StoreTravelInsurancePage(driver);
        String card = "Минимальная";
        storeTravelInsurancePage.selectCard(card);
        Assertions.assertTrue(
                storeTravelInsurancePage.isSelected(card)
        );
        storeTravelInsurancePage.clicktakeOutInsuranceBtn();

        StoreTravelInsuranceFormPage storeTravelInsuranceFormPage = new StoreTravelInsuranceFormPage(driver);
        Map<String, String> fieldsToFill = new HashMap<>();
        fieldsToFill.put("застрахованные_фамилия", "Пупкин");
        fieldsToFill.put("застрахованные_имя", "Петя");
        fieldsToFill.put("застрахованные_дата_рождения", "12.12.1990");
        fieldsToFill.put("страхователь_фамилия", "Нестеров");
        fieldsToFill.put("страхователь_имя", "Эдмунд");
        fieldsToFill.put("страхователь_отчество", "Арагорнович");
        fieldsToFill.put("страхователь_дата_рождения", "12.12.2000");
        fieldsToFill.put("паспорт_серия", "1234");
        fieldsToFill.put("паспорт_номер", "123456");
        fieldsToFill.put("паспорт_дата_выдачи", "12.12.2015");
        fieldsToFill.put("паспорт_кем_выдан", "Отделом");
        fieldsToFill.forEach((field, value) ->
                storeTravelInsuranceFormPage.fillFormField(field, value));
        fieldsToFill.forEach((field, value) ->
                Assertions.assertEquals(
                        value,
                        storeTravelInsuranceFormPage.getFormFieldValue(field)
                )
        );
        storeTravelInsuranceFormPage.clickContinueBtn();
        Assertions.assertEquals(
                "При заполнении данных произошла ошибка",
                storeTravelInsuranceFormPage.getErrorText()
        );
    }
}
