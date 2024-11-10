package org.example.browser;

import org.openqa.selenium.WebDriver;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class WebDriverCreate {
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
        }
        return null;
    }
}
