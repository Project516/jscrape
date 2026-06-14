package dev.project516.jscrape.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Save {
    public static void saveFile(String fileName, String fileContent) {
        try {
            Path destination = Path.of(fileName);
            Files.writeString(destination, fileContent);
        } catch (IOException e) {
            System.err.println("Failed to save file: " + e.getMessage());
        }
    }
}
