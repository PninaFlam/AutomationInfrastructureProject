package org.example.browser;

import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver driver;

    public WebDriverManager(WebDriver driver) {
        this.driver = driver;
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void setImplicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
}
