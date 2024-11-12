/**
 * A custom TestWatcher implementation for monitoring test execution in JUnit 5.
 */
package org.example.lifeCycle;

import io.qameta.allure.Step;
import org.example.Utils.Screenshot;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class TestWatcherProject extends LogExtension implements TestWatcher {
    /**
     * Invoked when a test method finishes successfully.
     *
     * @param context the extension context for the test
     */
    @Override
    @Step
    public void testSuccessful(ExtensionContext context) {
        writeToLog(context.getDisplayName() + " Success!!");
    }

    /**
     * Invoked when a test method fails.
     *
     * @param context the extension context for the test
     * @param cause   the cause of the test failure
     */
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        writeToLog(context.getDisplayName() + " Failed!!\n" + cause.getLocalizedMessage());
        Screenshot.takeScreenshot(context); // add screenshot to Allure
    }

    /**
     * Invoked when a test method is aborted.
     *
     * @param context the extension context for the test
     * @param cause   the cause of the test abortion
     */
    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        writeToLog(context.getDisplayName() + " Aborted!!");
    }

    /**
     * Invoked when a test method is disabled.
     *
     * @param context the extension context for the test
     * @param reason  the reason why the test was disabled
     */
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        writeToLog(context.getDisplayName() + " Disabled!!");
    }
}
