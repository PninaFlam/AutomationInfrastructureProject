/**
 * A class for managing WebDriver operations such as window maximization, navigation, and setting implicit wait.
 */
package org.example.browser;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver driver;

    /**
     * Constructs a new WebDriverManager with the specified WebDriver instance.
     *
     * @param driver The WebDriver instance to be managed.
     */
    public WebDriverManager(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Maximizes the current window of the WebDriver.
     */
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    /**
     * Navigates the WebDriver to the specified URL.
     *
     * @param url The URL to navigate to.
     */
    public void navigateToUrl(String url) {
        driver.get(url);
    }

    /**
     * Sets the implicit wait time for the WebDriver.
     *
     * @param seconds The number of seconds to wait implicitly.
     */
    public void setImplicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
}
