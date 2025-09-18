package KI305.Kravchenko.Lab3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Інтерфейс, що вимагає реалізацію методу опису об'єкта.
 */
interface Describable {
    void describe() throws IOException;
}

/**
 * Абстрактний клас Waterbody (Водойма).
 * Містить базові характеристики: назву, рибу, воду, рослину.
 * Веде журнал подій у файл "waterbody_log3.txt".
 */
public abstract class Waterbody implements AutoCloseable, Describable {
    protected String name;
    protected Fish fish;
    protected Water water;
    protected Plant plant;
    protected FileWriter logWriter;

    public Waterbody(String name, Fish fish, Water water, Plant plant) throws IOException {
        this.name = name;
        this.fish = fish;
        this.water = water;
        this.plant = plant;
        logWriter = new FileWriter("waterbody_log3.txt", true);
        log("Створено водойму: " + name);
    }

    public void setName(String name) throws IOException {
        this.name = name;
        log("Назву водойми змінено на: " + name);
    }

    public String getName() {
        return name;
    }

    public void addFish(Fish fish) throws IOException {
        this.fish = fish;
        log("Додано рибу: " + fish.getType());
    }

    public void changeWater(Water water) throws IOException {
        this.water = water;
        log("Змінено тип води: " + water.getType());
    }

    public void addPlant(Plant plant) throws IOException {
        this.plant = plant;
        log("Додано рослину: " + plant.getName());
    }

    public void feedFish() throws IOException {
        log("Рибу (" + fish.getType() + ") погодували.");
    }

    public void growPlants() throws IOException {
        log("Рослина (" + plant.getName() + ") виросла.");
    }

    public void cleanWater() throws IOException {
        log("Вода очищена у водоймі: " + name);
    }

    public abstract void simulateDay() throws IOException;

    protected void log(String message) throws IOException {
        logWriter.write(LocalDateTime.now() + " - " + message + "\n");
        logWriter.flush();
    }

    @Override
    public void close() throws IOException {
        log("Закрито водойму: " + name);
        logWriter.close();
    }
}

/**
 * Клас Sea (Море), що розширює Waterbody.
 * Реалізує симуляцію дня.
 */
class Sea extends Waterbody {

    public Sea(String name, Fish fish, Water water, Plant plant) throws IOException {
        super(name, fish, water, plant);
    }

    @Override
    public void describe() throws IOException {
        String description = "Море: " + name + "\n" +
                             "Риба: " + fish.getType() + "\n" +
                             "Вода: " + water.getType() + "\n" +
                             "Рослина: " + plant.getName();
        System.out.println(description);
        log("Опис моря:\n" + description);
    }

    @Override
    public void simulateDay() throws IOException {
        feedFish();
        growPlants();
        cleanWater();
        log("Завершено симуляцію дня для моря: " + name);
    }
}

/**
 * Клас Fish (Риба).
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
 * Клас Water (Вода).
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
 * Клас Plant (Рослина).
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

/**
 * Клас-драйвер для тестування підкласу Sea.
 */
class SeaDriver {
    public static void main(String[] args) {
        try (
            Sea blackSea = new Sea(
                    "Чорне море",
                    new Fish("Оселедець"),
                    new Water("Солона"),
                    new Plant("Ламінарія")
            )
        ) {
            blackSea.describe();
            blackSea.simulateDay();

            blackSea.setName("Азовське море");
            blackSea.addFish(new Fish("Камбала"));
            blackSea.addPlant(new Plant("Зостера"));

            blackSea.describe();
            blackSea.simulateDay();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
