/**
 * A factory class for creating EdgeDriver instances.
 */
package org.example.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverFactory implements WebDriverFactory {

    /**
     * Creates a new instance of EdgeDriver.
     *
     * @return A new EdgeDriver instance.
     */
    @Override
    public WebDriver createWebDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}
