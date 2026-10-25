package Checkers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedR {
    public void BuffReader() {
        long startTime = System.currentTimeMillis();
        long errorCount = 0;

        try (BufferedReader bf = new BufferedReader(new FileReader("textfile.txt"))) {
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
        System.out.println("BufferedR (FileReader + BufferedReader) заняло: " + (endTime - startTime) + " мс. Найдено ERROR: " + errorCount);
    }
}