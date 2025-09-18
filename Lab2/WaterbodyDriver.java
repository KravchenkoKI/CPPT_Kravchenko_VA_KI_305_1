package KI305.Kravchenko.Lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Клас-драйвер для тестування класу Waterbody.
 * Демонструє створення водойми, зміну її стану, опис і симуляцію дня.
 */
public class WaterbodyDriver {
    public static void main(String[] args) {
        try (
            // Створюємо нову водойму "Озеро Світязь" з початковими рибою, водою та рослиною
            Waterbody lake = new Waterbody(
                    "Озеро Світязь",
                    new Fish("Щука"),
                    new Water("Прісна"),
                    new Plant("Водорість")
            )
        ) {

            // Описуємо стан першої водойми і проводимо симуляцію дня
            lake.describe();      // Вивід інформації про водойму
            lake.simulateDay();   // Годування риби, ріст рослин, очищення води

            // Змінюємо назву водойми на "Озеро Синевир"
            lake.setName("Озеро Синевир");

            // Додаємо нову рибу та рослину для другого озера
            lake.addFish(new Fish("Форель"));
            lake.addPlant(new Plant("Лотос"));

            // Опис і симуляція дня для нового стану водойми
            lake.describe();      // Вивід інформації про "Озеро Синевир"
            lake.simulateDay();   // Симуляція дня з новою рибою і рослиною

        } catch (Exception e) {
            e.printStackTrace();  // Вивід інформації про помилки, якщо вони виникають
        }
    }
}

/**
 * Клас Waterbody (Водойма) описує водойму з її характеристиками.
 * Містить: назву, рибу, воду, рослини.
 * Веде журнал дій у файл "waterbody_log.txt".
 */
class Waterbody implements AutoCloseable {
    private String name;       // Назва водойми
    private Fish fish;         // Риба у водоймі
    private Water water;       // Тип води
    private Plant plant;       // Рослинність
    private FileWriter logWriter; // Для запису логів у файл

    // Конструктор за замовчуванням
    public Waterbody() throws IOException {
        this("Невідома водойма", new Fish("Короп"), new Water("Прісна"), new Plant("Лілія"));
    }

    // Основний конструктор
    public Waterbody(String name, Fish fish, Water water, Plant plant) throws IOException {
        this.name = name;
        this.fish = fish;
        this.water = water;
        this.plant = plant;
        logWriter = new FileWriter("waterbody_log.txt", true); // Відкриваємо файл для додавання
        log("Створено водойму: " + name);
    }

    /**
     * Зміна назви водойми
     */
    public void setName(String name) throws IOException {
        this.name = name;
        log("Змінено назву водойми на: " + name);
    }

    public String getName() {
        return name;
    }

    /**
     * Додаємо або замінюємо рибу у водоймі
     */
    public void addFish(Fish fish) throws IOException {
        this.fish = fish;
        log("Додано рибу: " + fish.getType());
    }

    /**
     * Змінюємо тип води у водоймі
     */
    public void changeWater(Water water) throws IOException {
        this.water = water;
        log("Змінено тип води: " + water.getType());
    }

    /**
     * Додаємо або замінюємо рослину
     */
    public void addPlant(Plant plant) throws IOException {
        this.plant = plant;
        log("Додано рослину: " + plant.getName());
    }

    /**
     * Описуємо поточний стан водойми
     */
    public void describe() throws IOException {
        String description = "Водойма: " + name + "\n" +
                             "Риба: " + fish.getType() + "\n" +
                             "Вода: " + water.getType() + "\n" +
                             "Рослина: " + plant.getName();
        log("Опис водойми: \n" + description);
        System.out.println(description);
    }

    /**
     * Очищення води у водоймі
     */
    public void cleanWater() throws IOException {
        log("Вода очищена у водоймі: " + name);
    }

    /**
     * Годування риби
     */
    public void feedFish() throws IOException {
        log("Рибу (" + fish.getType() + ") погодували.");
    }

    /**
     * Ріст рослин
     */
    public void growPlants() throws IOException {
        log("Рослина (" + plant.getName() + ") виросла.");
    }

    /**
     * Симуляція одного дня у водоймі:
     * годування риби, ріст рослин, очищення води
     */
    public void simulateDay() throws IOException {
        feedFish();
        growPlants();
        cleanWater();
        log("Завершено симуляцію дня для водойми: " + name);
    }

    /**
     * Логування повідомлення у файл
     */
    private void log(String message) throws IOException {
        logWriter.write(LocalDateTime.now() + " - " + message + "\n");
        logWriter.flush();
    }

    /**
     * Закриття ресурсу FileWriter при завершенні роботи з водоймою
     */
    @Override
    public void close() throws IOException {
        log("Закриття роботи з водоймою: " + name);
        logWriter.close();
    }
}

/**
 * Клас Fish (Риба)
 */
class Fish {
    private String type;

    public Fish(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

/**
 * Клас Water (Вода)
 */
class Water {
    private String type;

    public Water(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

/**
 * Клас Plant (Рослина)
 */
class Plant {
    private String name;

    public Plant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
