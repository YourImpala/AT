package ru.sberbank.ex2;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

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

    public static  void moveToElement(WebDriver driver, WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.perform();
    }

    @Attachment
    public static byte[] getScreenshot(WebDriver driver){
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot,new File("src/main/resources/screen.png"));
            return Files.readAllBytes(Paths.get("src/main/resources","screen.png"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return new byte[0];
    }
}
