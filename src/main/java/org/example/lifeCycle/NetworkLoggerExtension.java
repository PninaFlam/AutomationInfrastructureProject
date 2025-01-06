package org.example.lifeCycle;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.NetworkInterceptor;
import org.openqa.selenium.remote.http.Filter;
import org.openqa.selenium.remote.http.HttpResponse;

import java.util.ArrayList;
import java.util.List;

import static org.example.lifeCycle.Extension.getDriverFromContext;
import static org.example.lifeCycle.LogExtension.writeToLog;

/**
 * A JUnit 5 extension that logs network requests' content types during test failures.
 * Captures network requests and logs their content types in case of a test failure.
 */
public class NetworkLoggerExtension implements TestExecutionExceptionHandler {

    // WebDriver instance to be used for capturing network requests
    static WebDriver driver;

    // List to store the content types of network responses
    List<String> contentType = new ArrayList<>();

    /**
     * Handles exceptions thrown during the test execution.
     * Captures network requests and their content types, logs them, and rethrows the exception.
     *
     * @param context   the test's execution context
     * @param throwable the exception thrown during test execution
     * @throws Throwable rethrows the original exception after logging network requests
     */
    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        // Retrieve the WebDriver instance from the test context
        driver = getDriverFromContext(context);

        // Capture network requests and their content types
        try (NetworkInterceptor ignored = new NetworkInterceptor(
                driver,
                (Filter) next -> req -> {
                    HttpResponse res = next.execute(req);  // Execute the request and get the response
                    contentType.add(res.getHeader("Content-Type"));  // Add the content type to the list
                    return res;  // Return the response
                }
        )) {
            // Log the captured content types
            writeToLog("Logs from network in case of an error:");
            contentType.forEach(log -> writeToLog(log));  // Write each content type to the log
        }
    }
}
