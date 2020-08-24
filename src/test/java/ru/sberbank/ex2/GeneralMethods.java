package ru.sberbank.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GeneralMethods {

    public static void fillField(WebElement locator, String value){
        locator.clear();
        locator.click();
        locator.sendKeys(value);
    }

    public static void moveToElementAndClick(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).click(element);
        action.perform();
    }
}
