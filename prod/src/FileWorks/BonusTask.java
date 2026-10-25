import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BonusTask {


    public static void runMemoryTest(String filePath) {
        System.out.println("Начинаем чтение файла через Files.readAllLines()...");
        System.out.println("Ожидаем загрузку всего файла в оперативную память.");

        try {

            List<String> lines = Files.readAllLines(Path.of(filePath));

            System.out.println("Успех! Прочитано строк: " + lines.size());

        } catch (OutOfMemoryError e) {

            System.err.println("\n[КРАШ] ПРОИЗОШЛА ОШИБКА ПАМЯТИ: " + e.toString());
            System.err.println("Сборщик мусора не смог освободить место для новых строк.");
        } catch (IOException e) {
            System.err.println("Ошибка доступа к файлу: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "source.txt"; // Твой файл на 1 000 000 строк (около 60-70 МБ)

        System.out.println("ВНИМАНИЕ: Для правильного теста нужно добавить VM Option: -Xmx16m");

        // Вызываем метод
        runMemoryTest(filePath);
    }
}