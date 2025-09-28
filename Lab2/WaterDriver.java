package KI305.Kravchenko.lab2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Клас {@code WaterDriver} є точкою входу в програму, яка демонструє роботу з класом {@link Water}.
 * Програма моделює взаємодію з водоймою, її екосистемою, рибами та якістю води.
 */
public class WaterDriver {
    /**
     * Основний метод для запуску програми.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        try {
            // Створення списку риб для початкового наповнення водойми
            List<Fish> fishes = new ArrayList<>(Arrays.asList(
                    new Fish("Щука"), 
                    new Fish("Щука"), 
                    new Fish("Карась")
            ));

            // Створення об'єкта Water із заданими параметрами
            Water water = new Water(
                    fishes,                       // Початковий список риб
                    new Ecosystem(20, 3),         // Початкова екосистема (20 рослин, 3 тварини)
                    new WaterQuality(),            // Якість води за замовчуванням
                    "Річка",                       // Назва водойми
                    20,                            // Площа водойми
                    0.5                            // Глибина водойми
            );

            water.addFish(new Fish("Короп"));       // Додавання нової риби
            water.removeFish(new Fish("Короп"));    // Видалення риби
            water.updateWaterQuality(6.8, 7.0);    // Оновлення якості води (pH та кисень)
            water.changeEcosystem(45, 3);          // Зміна екосистеми (кількість рослин і тварин)
            water.calculateVolume();                // Обчислення об'єму водойми
            water.isSuitableForFish();             // Перевірка придатності водойми для риб
            water.getInfo();                        // Виведення інформації про водойму
            water.clean();                          // Очищення водойми
            water.inventoryFish();                  // Інвентаризація риб
            water.changeName("Річа-Велика");       // Зміна назви водойми

            water.closeLogger();                    // Закриття логера для збереження всіх записів
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}
