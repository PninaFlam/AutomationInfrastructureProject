/**
 * The ActionHandler class provides methods for handling actions on web elements using Selenium WebDriver.
 */
package org.example.ActionsForDriver;

import org.example.Utils.Retry;
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
     *
     * @param driver The WebDriver instance to be used for actions.
     */
    public ActionHandler(WebDriver driver) {
        this.driver = driver;
        this.waitUtility = new WaitUtility(driver);
        this.findElement = new FindElementHelper(driver);
    }

    /**
     * Creates a runnable function for clicking an element identified by the given locator.
     *
     * @param locator The locator used to find the element to click.
     * @return A runnable function that clicks the element.
     */
    private static Runnable clickRunnable(By locator) {
        return () -> {
            WebElement elem = FindElementHelper.findElement(locator);
            waitUtility.waitForElementToBeClickable(elem).click();
        };
    }

    /**
     * Clicks an element identified by the given locator with retries in case of failure.
     *
     * @param locator The locator used to find the element to click.
     */
    public static void click(By locator) {
        Retry.retry(clickRunnable(locator), 3,0);
    }

    /**
     * Enters text into a text field identified by the given locator.
     *
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
     *
     * @param locator The locator used to find the web element.
     * @return true if the element is displayed, false otherwise.
     */
    public static boolean isDisplayed(By locator) {
        return findElement(locator).isDisplayed();
    }
}
