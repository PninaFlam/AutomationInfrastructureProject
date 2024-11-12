/**
 * An extension class for managing WebDriver lifecycle in JUnit tests.
 */
package org.example.lifeCycle;

import org.example.ActionsForDriver.ActionHandler;
import org.example.browser.InitDriver;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;

public class Extension extends LogExtension
        implements BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback {

    private static final ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace.create(Extension.class);
    private static WebDriver driver;

    /**
     * Callback that is invoked once before all tests in the current container.
     *
     * @param context the current extension context; never {@code null}
     */
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        driver = new InitDriver().getDriver(); // Initialize the WebDriver instance
        ActionHandler actionHandler = new ActionHandler(driver);
        setDriverInContext(context, driver);
        writeToLog("Start " + context.getDisplayName());
    }

    /**
     * Callback that is invoked before an individual test and any user-defined setup methods
     * for that test have been executed.
     *
     * @param context the current extension context; never {@code null}
     */
    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        writeToLog("Start test " + context.getDisplayName());
    }

    /**
     * Callback that is invoked once after all tests in the current container.
     *
     * @param context the current extension context; never {@code null}
     */
    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        writeToLog("Finish All " + context.getDisplayName());
        driver.quit();
    }

    /**
     * Callback that is invoked after an individual test and any user-defined teardown methods
     * for that test have been executed.
     *
     * @param context the current extension context; never {@code null}
     */
    @Override
    public void afterEach(ExtensionContext context) throws Exception {
        writeToLog("Finish test " + context.getDisplayName());
    }

    private void setDriverInContext(ExtensionContext context, WebDriver driver) {
        context.getStore(NAMESPACE).put("driver", driver);
    }

    public static WebDriver getDriverFromContext(ExtensionContext context) {
        return context.getStore(NAMESPACE).get("driver", WebDriver.class);
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
