package org.example.ActionsForDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementHelper {
    private static WebDriver driver;

    public FindElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    public static WebElement findElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return element;
    }
}
