/**
 * The FindElementHelper class provides helper methods for finding web elements using Selenium WebDriver.
 */
package org.example.ActionsForDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementHelper {
    private static WebDriver driver;

    /**
     * Constructor for FindElementHelper class.
     * @param driver The WebDriver instance to be used for finding elements.
     */
    public FindElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Finds a web element based on the given locator and scrolls it into view.
     * @param locator The locator used to find the web element.
     * @return The web element found.
     */
    public static WebElement findElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }
}
