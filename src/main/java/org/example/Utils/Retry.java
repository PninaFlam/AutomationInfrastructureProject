/**
 * The Retry class provides a utility method for retrying a function a specified number of times.
 */
package org.example.Utils;

import static org.example.lifeCycle.LogExtension.writeToLog;

public class Retry {

    /**
     * Retries a function a specified number of times.
     *
     * @param function   The function to be retried.
     * @param maxRetries The maximum number of retries allowed.
     * @throws RuntimeException if the function does not succeed after all retries.
     */
    public static void retry(Runnable function, int maxRetries, long delayMillis) {
        Exception exception = null;
        int retries = 0;
        while (retries < maxRetries) {
            try {
                function.run();
                return;
            } catch (Exception e) {
                writeToLog("Retrying... (" + (retries + 1) + "/" + maxRetries + ")");
                retries++;
                exception = e;
                try {
                    Thread.sleep(delayMillis);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        throw new RuntimeException("Max retries exceeded. Function did not succeed:\n" + exception.getMessage());
    }
}
