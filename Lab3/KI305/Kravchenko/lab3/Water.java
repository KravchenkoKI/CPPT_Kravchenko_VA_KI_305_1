package Lab3.KI305.Kravchenko.Lab3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Абстрактний клас {@code Water} представляє водойму з характеристиками:
 * екосистема, риби, якість води. 
 * Використовується як базовий клас для конкретних типів водойм (наприклад, {@link Sea}).
 */
public abstract class Water {
    protected List<Fish> fishes;         
    protected Ecosystem ecosystem;       
    protected WaterQuality waterQuality; 
    protected Logger logger;             
    protected String name;               
    protected double area;               
    protected double depth;              

    /**
     * Конструктор створює об'єкт {@code Water} з параметрами.
     *
     * @param fishes список риб
     * @param ecosystem екосистема
     * @param waterQuality якість води
     * @param name назва водойми
     * @param area площа
     * @param depth глибина
     */
    public Water(List<Fish> fishes, Ecosystem ecosystem, WaterQuality waterQuality, 
                 String name, double area, double depth) throws IOException {
        this.fishes = fishes != null ? fishes : new ArrayList<>();
        this.ecosystem = ecosystem != null ? ecosystem : new Ecosystem();
        this.waterQuality = waterQuality != null ? waterQuality : new WaterQuality();
        this.name = name;
        this.area = area;
        this.depth = depth;
        this.logger = new Logger("water_log.txt");
        logger.log(String.format("Водойма %s створена.", this.toString()));
    }

    /** Додає рибу до водойми. */
    public void addFish(Fish fish) throws IOException {
        fishes.add(fish);
        logger.log("Додано рибу: " + fish.getName());
    }

    /** Абстрактний метод: очищення водойми. */
    public abstract void clean() throws IOException;

    /** Повертає інформацію про водойму. */
    public String getInfo() throws IOException {
        String info = String.format("Водойма: %s, Площа: %.2f, Глибина: %.2f, Кількість риб: %d",
                name, area, depth, fishes.size());
        logger.log("Отримано інформацію: " + info);
        return info;
    }

    /** Закриває логер. */
    public void closeLogger() {
        logger.close();
    }

    @Override
    public String toString() {
        return name;
    }
}
