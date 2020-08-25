package ru.sberbank.ex2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.sberbank.ex2.pageObjects.FormTravelInsurancePage;
import ru.sberbank.ex2.settings.WebDriverSettings;
import ru.sberbank.ex2.steps.ChoosePolicyTravelInsuranceSteps;
import ru.sberbank.ex2.steps.FormTravelInsuranceSteps;
import ru.sberbank.ex2.steps.PrivateClientSteps;
import ru.sberbank.ex2.steps.TravelIsuranceSteps;

import java.util.HashMap;
import java.util.Map;

public class Tests extends WebDriverSettings {

    @Test
    public void insuranceTest() {
        driver.get(baseURL);

        PrivateClientSteps privateClientSteps = new PrivateClientSteps(driver);
        privateClientSteps.selectInNavigationMenu("Страхование");
        privateClientSteps.selectInDropdownMenu("Страхование путешественников");

        TravelIsuranceSteps travelIsuranceSteps = new TravelIsuranceSteps(driver);
        travelIsuranceSteps.checkTitle("Страхование путешественников");
        travelIsuranceSteps.clickIssueOnlineButton();

        ChoosePolicyTravelInsuranceSteps choosePolicyTravelInsuranceSteps = new ChoosePolicyTravelInsuranceSteps(driver);
        choosePolicyTravelInsuranceSteps.selectInsuranceType("Минимальная");
        choosePolicyTravelInsuranceSteps.checkSelectedInsurance("Минимальная");
        choosePolicyTravelInsuranceSteps.clickArrangeButton();

//        FormTravelInsurancePage formTravelInsurancePage = new FormTravelInsurancePage(driver);
//        Map<String, String> fieldsToFillAndValues = new HashMap<>();
//        fieldsToFillAndValues.put("застрахованные_фамилия", "Пупкин");
//        fieldsToFillAndValues.put("застрахованные_имя", "Петя");
//        fieldsToFillAndValues.put("застрахованные_дата_рождения", "12.12.1990");
//        fieldsToFillAndValues.put("страхователь_фамилия", "Нестеров");
//        fieldsToFillAndValues.put("страхователь_имя", "Эдмунд");
//        fieldsToFillAndValues.put("страхователь_отчество", "Арагорнович");
//        fieldsToFillAndValues.put("страхователь_дата_рождения", "12.12.2000");
//        fieldsToFillAndValues.put("паспорт_серия", "1234");
//        fieldsToFillAndValues.put("паспорт_номер", "123456");
//        fieldsToFillAndValues.put("паспорт_дата_выдачи", "12.12.2015");
//        fieldsToFillAndValues.put("паспорт_кем_выдан", "Отделом");
//        fieldsToFillAndValues.forEach((field, value) ->
//                formTravelInsurancePage.fillFormField(field, value));
//        fieldsToFillAndValues.forEach((field, value) ->
//                Assertions.assertEquals(
//                        value,
//                        formTravelInsurancePage.getFormFieldValue(field)
//                )
//        );
//        formTravelInsurancePage.clickContinueBtn();
//        Assertions.assertEquals(
//                "При заполнении данных произошла ошибка",
//                formTravelInsurancePage.getErrorText()
//        );
        FormTravelInsuranceSteps formTravelInsuranceSteps = new FormTravelInsuranceSteps(driver);
        Map<String, String> fieldsToFillAndValues = new HashMap<>();
        fieldsToFillAndValues.put("застрахованные_фамилия", "Пупкин");
        fieldsToFillAndValues.put("застрахованные_имя", "Петя");
        fieldsToFillAndValues.put("застрахованные_дата_рождения", "12.12.1990");
        fieldsToFillAndValues.put("страхователь_фамилия", "Нестеров");
        fieldsToFillAndValues.put("страхователь_имя", "Эдмунд");
        fieldsToFillAndValues.put("страхователь_отчество", "Арагорнович");
        fieldsToFillAndValues.put("страхователь_дата_рождения", "12.12.2000");
        fieldsToFillAndValues.put("паспорт_серия", "1234");
        fieldsToFillAndValues.put("паспорт_номер", "123456");
        fieldsToFillAndValues.put("паспорт_дата_выдачи", "12.12.2015");
        fieldsToFillAndValues.put("паспорт_кем_выдан", "Отделом");

        fieldsToFillAndValues.forEach(formTravelInsuranceSteps::fillFields);
        formTravelInsuranceSteps.checkFieldsFilling(fieldsToFillAndValues);
        formTravelInsuranceSteps.clickContinueButton();
        formTravelInsuranceSteps.checkErrorMessage("При заполнении данных произошла ошибка");

    }
}
