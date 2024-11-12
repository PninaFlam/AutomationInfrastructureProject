/**
 * A factory class for creating ChromeDriver instances.
 */
package org.example.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverFactory implements WebDriverFactory{

    /**
     * Creates a new instance of ChromeDriver.
     * @return A new ChromeDriver instance.
     */
    @Override
    public WebDriver createWebDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
