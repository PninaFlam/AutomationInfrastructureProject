/**
 * An interface for creating WebDriver instances.
 */
package org.example.browser;

import org.openqa.selenium.WebDriver;

public interface WebDriverFactory {

    /**
     * Creates a new instance of WebDriver.
     *
     * @return The created WebDriver instance.
     */
    WebDriver createWebDriver();
}
