package org.example.lifeCycle;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v129.network.Network;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.example.lifeCycle.Extension.getDriverFromContext;

/**
 * A JUnit 5 extension that captures network calls during test execution.
 * If a test fails, the captured network calls are logged.
 */
public class NetworkCallLoggerExtension implements TestExecutionExceptionHandler {

    // WebDriver instance used for capturing network calls
    static WebDriver driver;

    // List to store captured network call URLs
    List<String> networkCalls = new ArrayList<>();

    /**
     * Handles exceptions thrown during the test execution.
     * Captures network calls, logs them, and rethrows the exception.
     *
     * @param context   the test's execution context
     * @param throwable the exception thrown during test execution
     * @throws Throwable rethrows the original exception after logging network calls
     */
    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        // Retrieve the WebDriver instance from the test context
        driver = getDriverFromContext(context);

        // Collect network calls using the WebDriver instance
        collectNetworkCalls(driver);

        // Log the captured network calls
        logNetworkCalls(networkCalls);

        // Rethrow the original exception to indicate test failure
        throw throwable;
    }

    /**
     * Captures network calls using Chrome DevTools Protocol (CDP).
     *
     * @param driver the WebDriver instance used in the test
     */
    private void collectNetworkCalls(WebDriver driver) {
        // Create a DevTools session for the ChromeDriver
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        // Enable network tracking with buffer size options
        devTools.send(Network.enable(Optional.of(1000000), Optional.of(1000000), Optional.of(1000000)));

        // Add a listener to capture network requests and responses
        devTools.addListener(Network.requestWillBeSent(), request -> {
            // Capture the URL of the network request
            String url = request.getRequest().getUrl();
            networkCalls.add("Request URL: " + url);
        });

        devTools.addListener(Network.responseReceived(), response -> {
            String url = response.getResponse().getUrl();
            int statusCode = response.getResponse().getStatus();
            String responseBody = devTools.send(Network.getResponseBody(response.getRequestId())).getBody();
            networkCalls.add("Request URL: " + url + " | Status Code: " + statusCode + " | Response Body: " + responseBody);
        });
    }

    /**
     * Logs the captured network calls to an external logging system.
     *
     * @param networkCalls the list of captured network call URLs
     */
    private void logNetworkCalls(List<String> networkCalls) {
        // Write each captured URL to the log
        networkCalls.forEach(Extension::writeToLog);
    }
}
