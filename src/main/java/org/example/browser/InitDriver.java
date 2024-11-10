package org.example.browser;

import org.example.Utils.PropertiesLoader;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.Properties;

public class InitDriver {
    private WebDriver driver;

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

    public WebDriver getDriver() {
        return driver;
    }
}
