package Checkers;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderClass {
    public void File_Reader() {
        long startTime = System.currentTimeMillis();
        long errorCount = 0;

        try (FileReader fr = new FileReader("source.txt")) {
            int code;
            StringBuilder currentLine = new StringBuilder();

            while ((code = fr.read()) != -1) {
                char character = (char) code;

                // Собираем строку до символа переноса
                if (character == '\n') {
                    if (currentLine.indexOf("ERROR") != -1) {
                        errorCount++;
                    }
                    currentLine.setLength(0); // Очищаем буфер для следующей строки
                } else {
                    currentLine.append(character);
                }
            }

            // Проверка самой последней строки (если в конце файла нет \n)
            if (currentLine.indexOf("ERROR") != -1) {
                errorCount++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("FileReaderClass (Посимвольное чтение) заняло: " + (endTime - startTime) + " мс. Найдено ERROR: " + errorCount);
    }
}