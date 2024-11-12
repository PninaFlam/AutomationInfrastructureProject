/**
 * A class for log management.
 */
package org.example.lifeCycle;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogExtension implements BeforeAllCallback, ExtensionContext.Store.CloseableResource {

    private static Logger logger = Logger.getLogger("TestLogger");
    private FileHandler fileHandler;
    private static boolean isRun = false;

    /**
     * Callback that is invoked once before all tests in the current container.
     * This method initializes the log file.
     *
     * @param context the current extension context; never null
     */
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        if (!isRun) {
            context.getRoot().getStore(ExtensionContext.Namespace.GLOBAL).put("StartTests", this);

            try {
                // Specify the file path where the log file will be created
                fileHandler = new FileHandler("test.log");
                logger.addHandler(fileHandler);
                SimpleFormatter formatter = new SimpleFormatter();
                fileHandler.setFormatter(formatter);
            } catch (IOException e) {
                e.printStackTrace();
            }
            isRun = true;
        }
    }

    /**
     * Close underlying resources.
     *
     * @throws Throwable any throwable will be caught and rethrown
     */
    @Override
    public void close() throws Throwable {
        fileHandler.close();
    }

    /**
     * Write information to the log file.
     *
     * @param info The information to be written to the log.
     */
    public static void writeToLog(String info) {
        logger.info(info);
    }
}
