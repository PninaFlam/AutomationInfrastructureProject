package org.example.ActionsForDriver;

import org.example.Utils.WaitUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.example.ActionsForDriver.FindElementHelper.findElement;

public class ActionHandler {
    private static WebDriver driver;
    private static WaitUtility waitUtility;
    private FindElementHelper findElement;

    public ActionHandler(WebDriver driver) {
        this.driver = driver;
        this.waitUtility = new WaitUtility(driver);
        this.findElement = new FindElementHelper(driver);
    }
    public static void click(By locator) {
        waitUtility.waitForElementToBeClickable(locator).click();
    }

    public static void sendKeys(By locator, String content) {
        WebElement element = FindElementHelper.findElement(locator);
        element.clear();
        element.sendKeys(content);
    }

    public static boolean isDisplayed(By locator) {
        return findElement(locator).isDisplayed();
    }
}
