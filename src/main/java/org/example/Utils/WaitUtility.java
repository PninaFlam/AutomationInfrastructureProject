/**
 * A utility class for handling explicit waits in Selenium WebDriver.
 */
package org.example.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtility {
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Initializes the WaitUtility with the WebDriver and sets up a WebDriverWait with a default timeout of 10 seconds.
     *
     * @param driver the WebDriver instance to use for waiting
     */
    public WaitUtility(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Waits for the element to be clickable.
     *
     * @param elem the WebElement to wait for
     * @return the clickable WebElement
     */
    public WebElement waitForElementToBeClickable(WebElement elem) {
        return wait.until(ExpectedConditions.elementToBeClickable(elem));
    }

    /**
     * Waits for the element to be visible.
     *
     * @param locator the By locator of the element to wait for
     * @return the visible WebElement
     */
    public WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits for the element to be present in the DOM.
     *
     * @param locator the By locator of the element to wait for
     * @return the present WebElement
     */
    public WebElement waitForElementToBePresent(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
