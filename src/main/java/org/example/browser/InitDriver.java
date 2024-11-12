/**
 * A class responsible for initializing the WebDriver based on properties loaded from a configuration file.
 */
package org.example.browser;

import org.example.Utils.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.Properties;

public class InitDriver {
    private WebDriver driver;

    /**
     * Initializes the WebDriver based on properties loaded from a configuration file.
     */
    public InitDriver() {
        try {
            Properties properties = new PropertiesLoader().loadProperties("webDriver.properties");

            driver = WebDriverCreate.createWebDriver(properties);

            WebDriverManager driverManager = new WebDriverManager(driver);
            driverManager.maximizeWindow();
            driverManager.navigateToUrl(properties.getProperty("url"));
            driverManager.setImplicitWait(5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the initialized WebDriver instance.
     * @return The initialized WebDriver instance.
     */
    public WebDriver getDriver() {
        return driver;
    }
}
