package ru.sberbank.ex2.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrivateClientPage {
    WebDriver driver;

    @FindBy(xpath = "//ul[@class='kitt-top-menu__list  kitt-top-menu__list_left']")
    WebElement navigation;


    public PrivateClientPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickInNavigation(String menuItem) {
        navigation
                .findElement(By.xpath(".//label[@class = ' kitt-top-menu__link kitt-top-menu__link_first  '][contains(text(), '" + menuItem + "')]"))
                .click();
    }

    public void clickDropdownLink(String menuItem) {
        navigation
                .findElement(By.xpath(".//a[@class = 'kitt-top-menu__link kitt-top-menu__link_second'][contains(text(), '" + menuItem +"')]"))
                .click();
    }
}
