/**
 * A utility class for loading properties from a file.
 */
package org.example.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {
    /**
     * Loads properties from a file.
     *
     * @param fileName the name of the file to load properties from
     * @return a Properties object containing the loaded properties
     * @throws IOException if an I/O error occurs while reading the file
     */
    public Properties loadProperties(String fileName) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(fileName));
        return properties;
    }
}
