package KI305.Kravchenko.lab2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас {@code Water} представляє водойму з характеристиками, такими як
 * екосистема, риби та якість води. Цей клас дозволяє додавати та видаляти риб,
 * змінювати екосистему, оновлювати якість води та виконувати інші операції.
 * Всі дії логуються в файл.
 */
public class Water {
    private List<Fish> fishes;
    private Ecosystem ecosystem;
    private WaterQuality waterQuality;
    private Logger logger;
    private String name;
    private double area;
    private double depth;

    /**
     * Створює об'єкт {@code Water} з певною назвою, площею та глибиною.
     *
     * @param name  назва водойми
     * @param area  площа водойми (в квадратних метрах)
     * @param depth глибина водойми (в метрах)
     * @throws IOException якщо виникає помилка під час створення логера
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
     *
     * @param fishes       список риб
     * @param ecosystem    екосистема водойми
     * @param waterQuality якість води
     * @param name         назва водойми
     * @param area         площа водойми
     * @param depth        глибина водойми
     * @throws IOException якщо виникає помилка під час створення логера
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
     *
     * @param fish риба для додавання
     * @throws IOException якщо виникає помилка під час логування
     */
    public void addFish(Fish fish) throws IOException {
        fishes.add(fish);
        logger.log(String.format("Додано рибу: %s", fish.getName()));
        System.out.printf("Додано рибу: %s\n", fish.getName());
    }

    /**
     * Видаляє рибу з водойми.
     *
     * @param fish риба для видалення
     * @throws IOException якщо виникає помилка під час логування
     */
    public void removeFish(Fish fish) throws IOException {
        fishes.remove(fish);
        logger.log(String.format("Видалено рибу: %s", fish.getName()));
        System.out.printf("Видалено рибу: %s\n", fish.getName());
    }

    /**
     * Оновлює якість води в водоймі.
     *
     * @param ph     рівень pH води
     * @param oxygen рівень кисню у воді (в мг/л)
     * @throws IOException якщо виникає помилка під час логування
     */
    public void updateWaterQuality(double ph, double oxygen) throws IOException {
        waterQuality.setPh(ph);
        waterQuality.setOxygenLevel(oxygen);
        logger.log(String.format("Оновлено якість води: pH=%s, Кисень=%s", ph, oxygen));
        System.out.printf("Оновлено якість води: pH=%s, Кисень=%s\n", ph, oxygen);
    }

    /**
     * Змінює екосистему водойми.
     *
     * @param plantCount  кількість рослин
     * @param animalCount кількість тварин
     * @throws IOException якщо виникає помилка під час логування
     */
    public void changeEcosystem(int plantCount, int animalCount) throws IOException {
        ecosystem.setPlantCount(plantCount);
        ecosystem.setAnimalCount(animalCount);
        logger.log(String.format("Змінено екосистему: Рослини=%s, Тварини=%s", plantCount, animalCount));
        System.out.printf("Змінено екосистему: Рослини=%s, Тварини=%s\n", plantCount, animalCount);
    }

    /**
     * Обчислює об'єм водойми.
     *
     * @return об'єм водойми (в кубічних метрах)
     * @throws IOException якщо виникає помилка під час логування
     */
    public double calculateVolume() throws IOException {
        double volume = area * depth;
        logger.log(String.format("Обчислено об'єм водойми: %s", volume));
        System.out.printf("Обчислено об'єм водойми: %s\n", volume);
        return volume;
    }

    /**
     * Перевіряє, чи є водойма придатною для життя риб.
     *
     * @return {@code true}, якщо якість води дозволяє життя риб, {@code false} в іншому випадку
     * @throws IOException якщо виникає помилка під час логування
     */
    public boolean isSuitableForFish() throws IOException {
        boolean suitable = waterQuality.getPh() >= 6.5 && waterQuality.getPh() <= 8.5 && waterQuality.getOxygenLevel() > 5;
        logger.log(String.format("Перевірка придатності для риб: %s", suitable));
        System.out.printf("Перевірка придатності для риб: %s\n", suitable);
        return suitable;
    }

    /**
     * Повертає інформацію про водойму у вигляді рядка.
     *
     * @return рядок з інформацією про водойму
     * @throws IOException якщо виникає помилка під час логування
     */
    public String getInfo() throws IOException {
        String info = String.format("Водойма: %s, Площа: %.2f м², Глибина: %.2f м, Кількість риб: %d", name, area, depth, fishes.size());
        logger.log(String.format("Отримано інформацію про водойму: %s", info));
        System.out.printf("Отримано інформацію про водойму: %s\n", info);
        return info;
    }

    /**
     * Очищає водойму, встановлюючи оптимальні параметри якості води.
     *
     * @throws IOException якщо виникає помилка під час логування
     */
    public void clean() throws IOException {
        waterQuality.setPh(7.0);
        waterQuality.setOxygenLevel(8.0);
        logger.log("Проведено очищення водойми");
        System.out.println("Проведено очищення водойми");
    }

    /**
     * Проводить інвентаризацію риб, які є у водоймі.
     *
     * @return список назв риб
     * @throws IOException якщо виникає помилка під час логування
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
     *
     * @param newName нова назва водойми
     * @throws IOException якщо виникає помилка під час логування
     */
    public void changeName(String newName) throws IOException {
        String oldName = this.name;
        this.name = newName;
        logger.log(String.format("Змінено назву водойми з '%s' на '%s'", oldName, newName));
    }

    /**
     * Закриває логер для збереження даних у файл.
     *
     * @throws IOException якщо виникає помилка під час закриття логера
     */
    public void closeLogger() throws IOException {
        logger.close();
    }
}
