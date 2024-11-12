/**
 * A JUnit 5 extension for retrying failed tests up to a maximum number of retries.
 */
package org.example.lifeCycle;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import static org.example.lifeCycle.LogExtension.writeToLog;

public class RetryExtension implements TestExecutionExceptionHandler {

    private static final int MAX_RETRIES = 3;
    private int retryCount = 0;

    /**
     * Handles test execution exceptions by retrying the test up to a maximum number of retries.
     *
     * @param context   the extension context
     * @param throwable the exception thrown during test execution
     * @throws Throwable if the test should fail after reaching the maximum number of retries
     */
    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        if (retryCount < MAX_RETRIES) {
            retryCount++;
            writeToLog("Test failed, retrying... Attempt " + retryCount);
            return; // Retry the test
        }
        throw throwable; // Fail the test after max retries
    }
}
