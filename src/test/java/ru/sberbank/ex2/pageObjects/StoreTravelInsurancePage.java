package ru.sberbank.ex2.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.sberbank.ex2.GeneralMethods;

import java.util.List;

public class StoreTravelInsurancePage {

    WebDriver driver;
    @FindBy(xpath = "//div[contains(@class, 'online-card-program')]")
    WebElement card;


    @FindBy(xpath = "//button[@class='btn btn-primary btn-large']")
    WebElement takeOutInsuranceBtn;


    public StoreTravelInsurancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean isSelected(String cardName) {
        return card
                .findElement(By.xpath("//h3[contains(text(), '" + cardName + "')]/parent::node()"))
                .getAttribute("class")
                .contains("selected");
    }

    public void selectCard(String cardName) {
        card
                .findElement(By.xpath("//h3[contains(text(), '" + cardName + "')]"))
                .click();
    }

    public void clicktakeOutInsuranceBtn() {
        GeneralMethods.moveToElementAndClick(driver, takeOutInsuranceBtn);
    }




}
