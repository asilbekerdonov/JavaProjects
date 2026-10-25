package Checkers;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReadWithFiles {
    public void readWholeFile() {
        long startTime = System.currentTimeMillis();
        long errorCount = 0;

        Path path = Paths.get("textfile.txt");

        try (BufferedReader bf = Files.newBufferedReader(path)) {
            String line;
            while ((line = bf.readLine()) != null) {
                if (line.contains("ERROR")) {
                    errorCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("FileReadWithFiles (Files.newBufferedReader) заняло: " + (endTime - startTime) + " мс. Найдено ERROR: " + errorCount);
    }
}