package org.example.lifeCycle;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import static org.example.lifeCycle.LogExtension.writeToLog;

public class RetryExtension implements TestExecutionExceptionHandler {

    private static final int MAX_RETRIES = 2;
    private int retryCount = 0;

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        if (retryCount < MAX_RETRIES) {
            retryCount++;
            writeToLog("Test failed, retrying... Attempt " + retryCount);
            return;
        }
        throw throwable;
    }
}
