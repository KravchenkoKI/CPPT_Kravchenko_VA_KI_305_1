package KI305.Kravchenko.lab2;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Клас Logger забезпечує логування повідомлень у файл.
 * Використовується для запису дій та подій, що відбуваються в програмі.
 */
public class Logger {
    private FileWriter fileWriter; // Об'єкт для запису тексту у файл

    /**
     * Конструктор створює об'єкт Logger для запису повідомлень у вказаний файл.
     *
     * @param fileName ім'я файлу для запису логів.
     * @throws IOException якщо виникає помилка при створенні або відкритті файлу.
     */
    public Logger(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName, true); // Відкриття файлу у режимі додавання (append)
    }

    /**
     * Метод записує повідомлення у файл логу.
     *
     * @param message повідомлення, яке потрібно записати у файл.
     * @throws IOException якщо виникає помилка при записі у файл.
     */
    public void log(String message) throws IOException {
        if (fileWriter != null) {           // Перевірка, чи файл відкритий
            fileWriter.write(message + "\n"); // Запис повідомлення з новим рядком
            fileWriter.flush();               // Очищення буфера, щоб дані записалися одразу
        }
    }

    /**
     * Метод закриває файл логу, звільняючи всі ресурси, пов'язані з ним.
     * У разі виникнення помилки при закритті, повідомлення про помилку буде виведено в консоль.
     */
    public void close() {
        if (fileWriter != null) {          // Перевірка, чи файл відкритий
            try {
                fileWriter.close();        // Закриття файлу
            } catch (IOException e) {
                System.err.println("Виникла помилка при закриванні файла: " + e.getMessage()); // Вивід помилки
            }
        }
    }
}
