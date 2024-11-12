/**
 * The ActionHandler class provides methods for handling actions on web elements using Selenium WebDriver.
 */
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

    /**
     * Constructor for ActionHandler class.
     * @param driver The WebDriver instance to be used for actions.
     */
    public ActionHandler(WebDriver driver) {
        this.driver = driver;
        this.waitUtility = new WaitUtility(driver);
        this.findElement = new FindElementHelper(driver);
    }

    /**
     * Clicks on a web element identified by the given locator.
     * @param locator The locator used to find the web element.
     */
    public static void click(By locator) {
        WebElement elem = FindElementHelper.findElement(locator);
        waitUtility.waitForElementToBeClickable(elem).click();
    }

    /**
     * Enters text into a text field identified by the given locator.
     * @param locator The locator used to find the text field.
     * @param content The text to be entered into the text field.
     */
    public static void sendKeys(By locator, String content) {
        WebElement element = FindElementHelper.findElement(locator);
        element.clear();
        element.sendKeys(content);
    }

    /**
     * Checks if a web element identified by the given locator is displayed.
     * @param locator The locator used to find the web element.
     * @return true if the element is displayed, false otherwise.
     */
    public static boolean isDisplayed(By locator) {
        return findElement(locator).isDisplayed();
    }
}
