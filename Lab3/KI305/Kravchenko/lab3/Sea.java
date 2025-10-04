package Lab3.KI305.Kravchenko.lab3;

import java.io.IOException;
import java.util.List;

/**
 * Клас {@code Sea} представляє море, що є підкласом {@link Water}.
 * Реалізує інтерфейс {@link Navigable}.
 */
public class Sea extends Water implements Navigable {
    private double salinity; // Солоність моря

    /**
     * Конструктор створює море з параметрами.
     */
    public Sea(List<Fish> fishes, Ecosystem ecosystem, WaterQuality waterQuality,
               String name, double area, double depth, double salinity) throws IOException {
        super(fishes, ecosystem, waterQuality, name, area, depth);
        this.salinity = salinity;
        logger.log("Створене море з солоністю: " + salinity);
    }

    /** Реалізація очищення моря (скидання солоності). */
    @Override
    public void clean() throws IOException {
        salinity = 3.5; // типове значення для морської води
        waterQuality.setPh(8.1);
        waterQuality.setOxygenLevel(7.0);
        logger.log("Море очищене. Встановлено типові параметри.");
    }

    /** Реалізація інтерфейсу Navigable. */
    @Override
    public boolean isNavigable() {
        return depth > 2.0 && area > 10.0;
    }
}
