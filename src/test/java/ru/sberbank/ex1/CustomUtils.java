package ru.sberbank.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CustomUtils {

    public static void fillField(WebDriver driver, String locator, String value){
        driver.findElement(By.xpath(locator)).clear();
        driver.findElement(By.xpath(locator)).click();
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    public static void moveToElementAndClick(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).click(element);
        action.perform();
    }

}
