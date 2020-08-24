package ru.sberbank.ex2.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravelInsurancePage {
    WebDriver driver;

    @FindBy(xpath = "//div[contains(@class, 'kit-col_lg-top_40')]/h1")
    WebElement travelInsuranceTitle;

    @FindBy(xpath = "//div[@class='product-teaser-full-width__button']")
    WebElement issueOnlineButton;


    public TravelInsurancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public boolean checkTravelInsuranceTitle(String titleName) {
        return travelInsuranceTitle.getText().equals(titleName);
    }


    public void clickIssueOnlineButton() {
        issueOnlineButton.click();
    }
}
