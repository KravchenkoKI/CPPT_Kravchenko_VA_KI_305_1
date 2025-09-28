package KI305.Kravchenko.lab2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import KI305.Kravchenko.lab2.Logger;

import KI305.Kravchenko.lab2.Fish;

/**
 * Клас {@code Water} представляє водойму з характеристиками, такими як
 * екосистема, риби та якість води. Цей клас дозволяє додавати та видаляти риб,
 * змінювати екосистему, оновлювати якість води та виконувати інші операції.
 * Всі дії логуються в файл.
 */
public class Water {
    private List<Fish> fishes;         // Список риб у водоймі
    private Ecosystem ecosystem;       // Екосистема водойми (рослини, тварини)
    private WaterQuality waterQuality; // Якість води (pH, кисень)
    private Logger logger;             // Об'єкт для логування дій
    private String name;               // Назва водойми
    private double area;               // Площа водойми (м²)
    private double depth;              // Глибина водойми (м)

    /**
     * Створює об'єкт {@code Water} з певною назвою, площею та глибиною.
     */
    public Water(String name, double area, double depth) throws IOException {
        this.name = name;
        this.area = area;
        this.depth = depth;
        this.fishes = new ArrayList<>();
        this.ecosystem = new Ecosystem();
        this.waterQuality = new WaterQuality();
        this.logger = new Logger("water_log.txt");
        logger.log(String.format("Водойма %s створена.", this.toString()));
    }

    /**
     * Створює об'єкт {@code Water} з параметрами для риб, екосистеми та якості води.
     */
    public Water(List<Fish> fishes, Ecosystem ecosystem, WaterQuality waterQuality, String name, double area, double depth) throws IOException {
        this.fishes = fishes;
        this.ecosystem = ecosystem;
        this.waterQuality = waterQuality;
        this.name = name;
        this.area = area;
        this.depth = depth;
        this.logger = new Logger("water_log.txt");
        logger.log(String.format("Водойма %s створена.", this.toString()));
    }

    /**
     * Додає рибу до водойми.
     */
    public void addFish(Fish fish) throws IOException {
        fishes.add(fish);
        logger.log(String.format("Додано рибу: %s", fish.getName()));
        System.out.printf("Додано рибу: %s\n", fish.getName());
    }

    /**
     * Видаляє рибу з водойми.
     */
    public void removeFish(Fish fish) throws IOException {
        fishes.remove(fish);
        logger.log(String.format("Видалено рибу: %s", fish.getName()));
        System.out.printf("Видалено рибу: %s\n", fish.getName());
    }

    /**
     * Оновлює якість води в водоймі.
     */
    public void updateWaterQuality(double ph, double oxygen) throws IOException {
        waterQuality.setPh(ph);
        waterQuality.setOxygenLevel(oxygen);
        logger.log(String.format("Оновлено якість води: pH=%s, Кисень=%s", ph, oxygen));
        System.out.printf("Оновлено якість води: pH=%s, Кисень=%s\n", ph, oxygen);
    }

    /**
     * Змінює екосистему водойми.
     */
    public void changeEcosystem(int plantCount, int animalCount) throws IOException {
        ecosystem.setPlantCount(plantCount);
        ecosystem.setAnimalCount(animalCount);
        logger.log(String.format("Змінено екосистему: Рослини=%s, Тварини=%s", plantCount, animalCount));
        System.out.printf("Змінено екосистему: Рослини=%s, Тварини=%s\n", plantCount, animalCount);
    }

    /**
     * Обчислює об'єм водойми.
     */
    public double calculateVolume() throws IOException {
        double volume = area * depth;
        logger.log(String.format("Обчислено об'єм водойми: %s", volume));
        System.out.printf("Обчислено об'єм водойми: %s\n", volume);
        return volume;
    }

    /**
     * Перевіряє, чи є водойма придатною для життя риб.
     */
    public boolean isSuitableForFish() throws IOException {
        boolean suitable = waterQuality.getPh() >= 6.5 && waterQuality.getPh() <= 8.5
                && waterQuality.getOxygenLevel() > 5;
        logger.log(String.format("Перевірка придатності для риб: %s", suitable));
        System.out.printf("Перевірка придатності для риб: %s\n", suitable);
        return suitable;
    }

    /**
     * Повертає інформацію про водойму у вигляді рядка.
     */
    public String getInfo() throws IOException {
        String info = String.format("Водойма: %s, Площа: %.2f м², Глибина: %.2f м, Кількість риб: %d",
                name, area, depth, fishes.size());
        logger.log(String.format("Отримано інформацію про водойму: %s", info));
        System.out.printf("Отримано інформацію про водойму: %s\n", info);
        return info;
    }

    /**
     * Очищає водойму, встановлюючи оптимальні параметри якості води.
     */
    public void clean() throws IOException {
        waterQuality.setPh(7.0);
        waterQuality.setOxygenLevel(8.0);
        logger.log("Проведено очищення водойми");
        System.out.println("Проведено очищення водойми");
    }

    /**
     * Проводить інвентаризацію риб.
     */
    public List<String> inventoryFish() throws IOException {
        List<String> fishNames = new ArrayList<>();
        for (Fish fish : fishes) {
            fishNames.add(fish.getName());
        }
        logger.log("Проведено інвентаризацію риб");
        System.out.println("Проведено інвентаризацію риб");
        return fishNames;
    }

    /**
     * Змінює назву водойми.
     */
    public void changeName(String newName) throws IOException {
        String oldName = this.name;
        this.name = newName;
        logger.log(String.format("Змінено назву водойми з '%s' на '%s'", oldName, newName));
    }

    /**
     * Закриває логер для збереження даних у файл.
     */
    public void closeLogger() throws IOException {
        logger.close();
    }

    /**
     * Перевизначення методу toString, щоб повертати назву водойми.
     */
    @Override
    public String toString() {
        return name;
    }
}
