package ru.sberbank.ex2.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.sberbank.ex2.GeneralMethods;

import java.util.HashMap;
import java.util.Map;

public class StoreTravelInsuranceFormPage {
    WebDriver driver;
    public Map<String, WebElement> fieldLocators = new HashMap<>();

    @FindBy(xpath = "//*[@id='surname_vzr_ins_0']")
    WebElement insuredName;

    @FindBy(xpath = "//*[@id='name_vzr_ins_0']")
    WebElement insuredSurname
            ;
    @FindBy(xpath = "//*[@id='birthDate_vzr_ins_0']")
    WebElement insuredBirthDay;

    @FindBy(xpath = "//*[@id='person_lastName']")
    WebElement insurantLastname;

    @FindBy(xpath = "//*[@id='person_firstName']")
    WebElement insurantName;

    @FindBy(xpath = "//*[@id='person_middleName']")
    WebElement insurantMiddlename;

    @FindBy(xpath = "//*[@id='person_birthDate']")
    WebElement insurantBirthDay;

    @FindBy(xpath = "//*[@id='passportSeries']")
    WebElement pasportSeries;

    @FindBy(xpath = "//*[@id='passportNumber']")
    WebElement pasportNumber;

    @FindBy(xpath = "//*[@id='documentDate']")
    WebElement pasportDocument;

    @FindBy(xpath = "//*[@id='documentIssue']")
    WebElement pasportDocumentIssue;



    @FindBy(xpath = "//button[@class='btn btn-primary page__btn']")
    WebElement continueBtn;

    @FindBy(xpath = "//div[@class='alert-form alert-form-error']")
    WebElement errorMessage;

    public StoreTravelInsuranceFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

        fieldLocators.put("застрахованные_фамилия", insuredName);
        fieldLocators.put("застрахованные_имя", insuredSurname);
        fieldLocators.put("застрахованные_дата_рождения", insuredBirthDay);

        fieldLocators.put("страхователь_фамилия", insurantLastname);
        fieldLocators.put("страхователь_имя", insurantName);
        fieldLocators.put("страхователь_отчество", insurantMiddlename);
        fieldLocators.put("страхователь_дата_рождения", insurantBirthDay);


        fieldLocators.put("паспорт_серия", pasportSeries);
        fieldLocators.put("паспорт_номер", pasportNumber);
        fieldLocators.put("паспорт_дата_выдачи", pasportDocument);
        fieldLocators.put("паспорт_кем_выдан", pasportDocumentIssue);
    }

    public void fillFormField(String fieldName, String value) {
        GeneralMethods.fillField(fieldLocators.get(fieldName), value);
    }

    public String getFormFieldValue(String fieldName) {
        return fieldLocators.get(fieldName).getAttribute("value");
    }

    public void clickContinueBtn() {
        GeneralMethods.moveToElementAndClick(driver, continueBtn);
    }

    public String getErrorText() {
        return errorMessage.getText();
    }
}
