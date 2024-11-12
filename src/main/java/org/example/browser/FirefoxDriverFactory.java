/**
 * A factory class for creating FirefoxDriver instances.
 */
package org.example.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverFactory implements WebDriverFactory {

    /**
     * Creates a new instance of FirefoxDriver.
     *
     * @return A new FirefoxDriver instance.
     */
    @Override
    public WebDriver createWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }
}
