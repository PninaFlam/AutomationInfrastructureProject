/**
 * The CreateFile class provides a method for creating a new file and writing content to it.
 */
package org.example.Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateFile {

    /**
     * Creates a new file with the specified file name and writes the given content to it.
     *
     * @param fileName The name of the file to create.
     * @param content The content to write to the file.
     */
    public static void CreateFile(String fileName, String content) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
