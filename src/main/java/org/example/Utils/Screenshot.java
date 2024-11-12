/**
 * A utility class for capturing and attaching screenshots to test reports using Allure.
 */
package org.example.Utils;

import io.qameta.allure.Attachment;
import org.example.lifeCycle.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
    /**
     * Takes a screenshot of the current WebDriver instance and attaches it to the test report.
     *
     * @param context the extension context to retrieve the WebDriver instance
     * @return a byte array representing the screenshot in PNG format
     */
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] TakeScreenshot(ExtensionContext context) {
        WebDriver driver = Extension.getDriverFromContext(context);
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
