import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class File_Writer {

    public static void generateFile(String path, int lines) {
        String[] logLevels = {"INFO", "WARN", "ERROR"};
        Random random = new Random();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, StandardCharsets.UTF_8))) {
            for (int i = 1; i <= lines; i++) {
                // Tasodifiy log darajasini tanlash
                String level = logLevels[random.nextInt(logLevels.length)];

                // Log xabarini shakllantirish va yozish
                writer.write("[" + level + "] Системное сообщение (log message) для строки " + i);
                writer.newLine(); // кроссплатформенный перевод строки
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Файл создан: " + path + " (" + lines + " строк)");
    }

    public static String readFile(String path) {
        try {
            return Files.readString(Path.of(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) {
        String sourcePath = "source.txt";
        String targetPath = "textfile.txt"; // Kengaytmani (.txt) qo'shish tavsiya etiladi

        // 1 000 000 qatorli log fayl yaratish
        generateFile(sourcePath, 1_000_000);

        // Diqqat: 1 million qatorni bitta String ga o'qish xotirani (RAM) ko'p band qiladi!
        String data = readFile(sourcePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(targetPath, StandardCharsets.UTF_8))) {
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Готово. Размер data: " + data.length() + " символов");
    }
}