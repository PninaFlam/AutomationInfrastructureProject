/**
 * A utility class for creating WebDriver instances based on properties provided.
 */
package org.example.browser;

import org.openqa.selenium.WebDriver;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import static org.example.lifeCycle.LogExtension.writeToLog;

public class WebDriverCreate {

    /**
     * Creates a WebDriver instance based on the specified properties.
     * @param properties The properties containing the driver type information.
     * @return The created WebDriver instance.
     */
    public static WebDriver createWebDriver(Properties properties) {
        String driverType = properties.getProperty("driver");
        WebDriverFactory driverFactory;
        try {
            switch (driverType.toLowerCase()) {
                case "chrome":
                    driverFactory = new ChromeDriverFactory();
                    break;
                case "firefox":
                    driverFactory = new FirefoxDriverFactory();
                    break;
                case "edge":
                    driverFactory = new EdgeDriverFactory();
                    break;
                default:
                    throw new InvalidPropertiesFormatException("The driver is not valid");
            }
            return driverFactory.createWebDriver();
        } catch (Exception e) {
            writeToLog(e.getMessage());
        }
        return null;
    }
}
