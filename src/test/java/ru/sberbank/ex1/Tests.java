package ru.sberbank.ex1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;


public class Tests extends WebDriverSettings{
    private String privateClientURL = "http://www.sberbank.ru/ru/person_ab_elena";

    private String insuranceSelector = "//label[@class = ' kitt-top-menu__link kitt-top-menu__link_first  '][contains(text(), 'Страхование')]";
    private String travelInsuranceSelector = "//a[@class = 'kitt-top-menu__link kitt-top-menu__link_second'][contains(text(), 'Страхование путешественников')]";
    private String travelInsuranceTitleSelector = "//div[contains(@class, 'kit-col_lg-top_40')]/h1";
    private String arrangeOnlineSelector = "//div[@class='product-teaser-full-width__button']";
    private String minimumInsuranceSelector = "//h3[contains(text(), 'Минимальная')]/parent::node()";
    private String takeOutInsuranceSelector = "//button[@class='btn btn-primary btn-large']";

    private String insuredNameFormSelector = "//*[@id='surname_vzr_ins_0']";
    private String insuredSurnameFormSelector = "//*[@id='name_vzr_ins_0']";
    private String insuredBirthDayFormSelector = "//*[@id='birthDate_vzr_ins_0']";

    private String personLastnameFormSelector = "//*[@id='person_lastName']";
    private String personNameFormSelector = "//*[@id='person_firstName']";
    private String personMiddlenameFormSelector = "//*[@id='person_middleName']";
    private String personBirthDayFormSelector = "//*[@id='person_birthDate']";

    private String pasportSeriesFormSelector = "//*[@id='passportSeries']";
    private String pasportNumberFormSelector = "//*[@id='passportNumber']";
    private String pasportDocumentDateFormSelector = "//*[@id='documentDate']";
    private String pasportDocumentIssueFormSelector = "//*[@id='documentIssue']";


    private String continueRegistrationSelector = "//button[@class='btn btn-primary page__btn']";

    private String alertFormErrorSelector = "//div[@class='alert-form alert-form-error']";



    @Test
    public void insuranceTest() {
        chromeDriver.get(privateClientURL);


        WebElement insuranceBtn = chromeDriver.findElement(By.xpath(insuranceSelector));
        insuranceBtn.click();

        WebElement travelInsuranceBtn = chromeDriver.findElement(By.xpath(travelInsuranceSelector));
        travelInsuranceBtn.click();

        WebElement title = chromeDriver.findElement(By.xpath(travelInsuranceTitleSelector));
        Assertions.assertEquals(
                "Страхование путешественников",
                title.getText()
        );

        WebElement arrangeOnlineBtn = chromeDriver.findElement(By.xpath(arrangeOnlineSelector));
        arrangeOnlineBtn.click();

        WebElement minimumInsurance = chromeDriver.findElement(By.xpath(minimumInsuranceSelector));
        minimumInsurance.click();
        Assertions.assertTrue(
                minimumInsurance
                        .getAttribute("class")
                        .contains("selected")
        );

        WebElement takeOutInsuranceBtn = chromeDriver.findElement(By.xpath(takeOutInsuranceSelector));
        CustomUtils.moveToElementAndClick(chromeDriver, takeOutInsuranceBtn);

        Map<String, String> fieldsToFill = new HashMap<>();
        fieldsToFill.put(insuredNameFormSelector, "Олег");
        fieldsToFill.put(insuredSurnameFormSelector, "Тестов");
        fieldsToFill.put(insuredBirthDayFormSelector, "01.01.1990");
        fieldsToFill.put(personLastnameFormSelector, "Тестов");
        fieldsToFill.put(personNameFormSelector, "Андрей");
        fieldsToFill.put(personMiddlenameFormSelector, "Тестович");
        fieldsToFill.put(personBirthDayFormSelector, "01.01.1990");
        fieldsToFill.put(pasportSeriesFormSelector, "1221");
        fieldsToFill.put(pasportNumberFormSelector, "111111");
        fieldsToFill.put(pasportDocumentDateFormSelector, "01.01.2010");
        fieldsToFill.put(pasportDocumentIssueFormSelector, "Выдан отделом тестирования");
        fieldsToFill.forEach((field, value) -> CustomUtils.fillField(chromeDriver, field, value));

        fieldsToFill.forEach((field, value) ->
                Assertions.assertEquals(
                        value,
                        chromeDriver.findElement(By.xpath(field)).getAttribute("value"))
                );


        WebElement continueRegistrationBtn = chromeDriver.findElement(By.xpath(continueRegistrationSelector));
        CustomUtils.moveToElementAndClick(chromeDriver, continueRegistrationBtn);

        WebElement alertError = chromeDriver.findElement(By.xpath(alertFormErrorSelector));
        Assertions.assertEquals(
                "При заполнении данных произошла ошибка",
                alertError.getText()
        );

    }


}
