import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * FileLister - це клас, який дозволяє користувачеві знайти файли з певним розширенням
 * в заданій директорії та зберегти список назв файлів в інший файл.
 * Користувач може вказати шлях до директорії, розширення файлів та шлях до вихідного файлу
 * як вхідні параметри. Користувач також може вибрати, чи включати розширення файлу
 * в список чи ні.
 */
public class FileLister {
    /**
     * Головний метод класу, який запускає програму.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Отримуємо вхідні дані від користувача
        System.out.println("Введіть шлях до директорії:");
        String directoryPath = scanner.nextLine();
        System.out.println("Введіть розширення файлів (без крапки), які ви хочете знайти:");
        String fileExtension = scanner.nextLine();
        System.out.println("Ви хочете включити розширення файлу в список? (yes/no):");
        boolean includeExtension = scanner.nextLine().toLowerCase().equals("yes");
        System.out.println("Введіть шлях до файлу, в який ви хочете зберегти список:");
        String outputPath = scanner.nextLine();

        // Знаходимо файли з потрібним розширенням і зберігаємо їх у список
        List<String> files = getFilesWithExtension(directoryPath, fileExtension, includeExtension);

        // Записуємо список у файл
        saveToFile(outputPath, files);
    }

    /**
     * Цей метод повертає список назв файлів, які мають задане розширення
     * в заданій директорії.
     *
     * @param directoryPath    шлях до директорії, в якій шукаємо
     * @param fileExtension    розширення файлів, які шукаємо (без крапки)
     * @param includeExtension чи включати розширення в назви файлів чи ні
     * @return список назв файлів, які відповідають критеріям
     * @throws IOException якщо виникає помилка при читанні директорії
     */
    private static List<String> getFilesWithExtension(String directoryPath, String fileExtension, boolean includeExtension) {
        List<String> files = new ArrayList<String>();
        try {
            // Перебираємо всі файли в директорії
            for (Path path : Files.newDirectoryStream(Paths.get(directoryPath))) {
                // Якщо файл має потрібне розширення, додаємо його до списку
                if (path.toString().endsWith("." + fileExtension)) {
                    String fileName = path.getFileName().toString();
                    // Якщо не потрібно включати розширення, видаляємо його з назви
                    if (!includeExtension) {
                        fileName = fileName.substring(0, fileName.lastIndexOf('.'));
                    }
                    files.add(fileName);
                }
            }
        } catch (IOException ex) {
            // Виводимо повідомлення про помилку
            System.out.println("Помилка при читанні директорії: " + ex.getMessage());
        }
        return files;
    }

    /**
     * Цей метод записує список рядків в файл за заданим шляхом.
     *
     * @param filePath шлях до файлу, в який записуємо
     * @param data     список рядків, які записуємо
     * @throws FileNotFoundException якщо файл не знайдено
     */
    private static void saveToFile(String filePath, List<String> data) {
        try {
            // Створюємо об'єкт PrintWriter для запису в файл
            PrintWriter writer = new PrintWriter(new File(filePath));
            // Перебираємо всі рядки в списку і записуємо їх в файл
            for (String line : data) {
                writer.println(line);
            }
            // Закриваємо потік
            writer.close();
        } catch (FileNotFoundException ex) {
            // Виводимо повідомлення про помилку
            System.out.println("Помилка при запису в файл: " + ex.getMessage());
        }
    }
}
