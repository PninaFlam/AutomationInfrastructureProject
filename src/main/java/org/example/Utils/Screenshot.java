package org.example.Utils;

import io.qameta.allure.Attachment;
import org.example.lifeCycle.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] TakeScreenshot(ExtensionContext context) {
        WebDriver driver = Extension.getDriverFromContext(context);
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}