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
            List<Fish> fishes = new ArrayList<>(Arrays.asList(new Fish("Щука"), new Fish("Щука"), new Fish("Карась")));

            Water water = new Water(
                    fishes,
                    new Ecosystem(20, 3),
                    new WaterQuality(),
                    "Річка",
                    20,
                    0.5
            );

            water.addFish(new Fish("Короп"));
            water.removeFish(new Fish("Короп"));
            water.updateWaterQuality(6.8, 7.0);
            water.changeEcosystem(45, 3);
            water.calculateVolume();
            water.isSuitableForFish();
            water.getInfo();
            water.clean();
            water.inventoryFish();
            water.changeName("Річа-Велика");

            water.closeLogger();
        } catch (IOException e) {
            // Обробка помилок, що виникають під час запису в файл
            throw new RuntimeException("Сталася помилка при записі в файл: " + e.getMessage());
        }
    }
}

